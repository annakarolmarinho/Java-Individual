package BD;

import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PegarDadosDaTabelas {
    Conexao conexao = new Conexao();
    JdbcTemplate con = conexao.getConexaoDoBanco();

    public void pegarDadosTabela(){
        List<Processador> processadorList = con.query("SELECT * FROM Cpu", new BeanPropertyRowMapper<>(Processador.class));
        List<DiscoGrupo> discoList = con.query("SELECT * FROM HD", new BeanPropertyRowMapper<>(DiscoGrupo.class));
        List<DiscoGrupo> discoList1 = con.query("SELECT * FROM HDSpec", new BeanPropertyRowMapper<>(DiscoGrupo.class));
        List<Memoria> memoriaListe = con.query("SELECT * FROM RAM", new BeanPropertyRowMapper<>(Memoria.class));

        System.out.println(processadorList);
        System.out.println();
        System.out.println(discoList);
        System.out.println();
        System.out.println(discoList1);
        System.out.println();
        System.out.println(memoriaListe);
    }
}
