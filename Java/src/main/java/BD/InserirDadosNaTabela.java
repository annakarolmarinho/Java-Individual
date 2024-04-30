package BD;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class InserirDadosNaTabela {
    Conexao conexao = new Conexao();
    Looca looca = new Looca();
    JdbcTemplate con = conexao.getConexaoDoBanco();

    //Dados da API - Looca
    Processador processador = looca.getProcessador();
    DiscoGrupo grupoDeDiscos = looca.getGrupoDeDiscos();
    List<Disco> discos = grupoDeDiscos.getDiscos();
    Memoria memoria = looca.getMemoria();

    public void inserindoDadosNaTabela(){

        //Inserindo no banco de dados dados da CPU, puxando os dados pela API - looca
        con.update("INSERT INTO CPU (uso, DataHoraLeitura, fkMaquina) values (?, now(), 1)", processador.getUso());

        //Inserindo no banco de dados dados da CPUSpec, puxando os dados pela API - looca
        con.update("INSERT INTO CPUSpec (fabricante, nome, identificador, qtdNucleo, frequenciaGHz ,fkCPU) values (?, ?, ?,?,?,1)", processador.getFabricante(),processador.getNome(),processador.getIdentificador(),processador.getNumeroCpusFisicas(),processador.getFrequencia());

        //Inserindo no banco de dados dados da HD, puxando os dados pela API - looca
        con.update("INSERT INTO HD (DataHoraLeitura, fkMaquina) values (now(), 1)");

        //Inserindo no banco de dados dados da HDSpec, puxando os dados pela API - looca
        con.update("INSERT INTO HDSpec (Modelo, Tamanho, Leitura, fkHD) values (?, ?, ?, 1)", discos.get(0).getModelo(), discos.get(0).getTamanho(), discos.get(0).getLeituras());

        //Inserindo no banco de dados dados da RAM, puxando os dados pela API - looca
        con.update("INSERT INTO RAM (EmUso, Total, Disponivel,DataHoraLeitura, fkMaquina) values (?, ?, ?, now(), 1)", memoria.getEmUso(), memoria.getTotal(), memoria.getDisponivel());

        System.out.println("Dados inseridos!!");
    }
}
