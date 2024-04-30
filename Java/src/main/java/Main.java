import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import org.checkerframework.checker.units.qual.C;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Looca looca = new Looca();
        JdbcTemplate con = conexao.getConexaoDoBanco();

        // Objetos da Maquina
        Cpu cpu = new Cpu();
        HD hd = new HD();
        HDSpec hdSpec = new HDSpec();
        RAM ram = new RAM();

        //Dados da API - Looca
        Processador processador = looca.getProcessador();
        DiscoGrupo grupoDeDiscos = looca.getGrupoDeDiscos();
        List<Disco> discos = grupoDeDiscos.getDiscos();
        Memoria memoria = looca.getMemoria();


        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");

        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formatoHoje = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String dataFormatada = hoje.format(formatoHoje);

        String hora = agora.format(formato);

        //Inserindo no banco de dados dados da CPU, puxando os dados pela API - looca
        cpu.setQtdUtilizado(20.0);
        cpu.setVelocidadeGhz(processador.getFrequencia()); // getFrequencia vindo da API - looca
        cpu.setTempoAtividade(hora);
        cpu.setDataHoraLeitura(dataFormatada);
        cpu.setFkMaquina(1);

        con.update("INSERT INTO CPU (Uso, TempoAtividade, VelocidadeGhz, DataHoraLeitura, fkMaquina) values (?, ?, ?, ?, ?)", cpu.getQtdUtilizado(), cpu.getTempoAtividade(), cpu.getVelocidadeGhz(), cpu.getDataHoraLeitura(), cpu.getFkMaquina());
        List<Cpu> cpuList = con.query("SELECT * FROM Cpu", new BeanPropertyRowMapper<>(Cpu.class));

        //Inserindo no banco de dados dados da HD, puxando os dados pela API - looca
        hd.setTempoDeAtividade(hora);
        hd.setTaxaTransferenciaDados(discos.get(0).getLeituras());
        hd.setDataHoraLeitura(dataFormatada);
        hd.setFkMaquina(1);

        con.update("INSERT INTO HD (TempoDeAtividade, TaxaTransferenciaDados, DataHoraLeitura, fkMaquina) values (?, ?, ?, ?)", hd.getTempoDeAtividade(), hd.getTaxaTransferenciaDados(), hd.getDataHoraLeitura(), hd.getFkMaquina());
        List<HD> hdList = con.query("SELECT * FROM HD", new BeanPropertyRowMapper<>(HD.class));

        //Inserindo no banco de dados dados da HDSpec, puxando os dados pela API - looca
        hdSpec.setMarca(discos.get(0).getNome());
        hdSpec.setModelo(discos.get(0).getModelo());
        hdSpec.setArmazenamentoTotal(grupoDeDiscos.getTamanhoTotal());
        hdSpec.setTransferenciaDadosGBs(discos.get(0).getTempoDeTransferencia());
        hdSpec.setConector("conectado");
        hdSpec.setFkHD(1);

        con.update("INSERT INTO HDSpec (Marca, Modelo, ArmazenamentoTotal, TransferenciaDadosGBs, Conector, fkHD) values (?, ?, ?, ?, ?, ?)", hdSpec.getMarca(), hdSpec.getModelo(), hdSpec.getArmazenamentoTotal(), hdSpec.getTransferenciaDadosGBs(), hdSpec.getConector(), hdSpec.getFkHD());
        List<HDSpec> hdSpecList = con.query("SELECT * FROM HDSpec", new BeanPropertyRowMapper<>(HDSpec.class));

        //Inserindo no banco de dados dados da RAM, puxando os dados pela API - looca
        ram.setTOTALMemoria(memoria.getTotal());
        ram.setUsoMemoria(memoria.getEmUso());
        ram.setDataHoraLeitura(dataFormatada);
        ram.setFkMaquina(1);

        con.update("INSERT INTO RAM (UsoMemoria, TotalMemoria,DataHoraLeitura, fkMaquina) values (?, ?, ?, ?)", ram.getUsoMemoria(), ram.getTOTALMemoria(), ram.getDataHoraLeitura(), ram.getFkMaquina());
        List<RAM> ramList = con.query("SELECT * FROM RAM", new BeanPropertyRowMapper<>(RAM.class));

        System.out.println(cpuList);
        System.out.println(hdList);
        System.out.println(hdSpecList);
        System.out.println(ramList);
    }
}
