import com.mysql.cj.protocol.a.StringValueEncoder;

import java.sql.Time;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;

public class Cpu {
    private int idCPU;
    private Double qtdUtilizado;
    private String TempoAtividade;
    private Long VelocidadeGhz;
    private String DataHoraLeitura;
    private int fkMaquina;

    public Cpu(){}

    public Cpu(int idCPU, Double qtdUtilizado, Long velocidadeGhz, String tempoAtividade, String dataHoraLeitura,int fkMaquina) {
        this.idCPU = idCPU;
        this.qtdUtilizado = qtdUtilizado;
        this.TempoAtividade = tempoAtividade;
        this.VelocidadeGhz = velocidadeGhz;
        this.DataHoraLeitura = dataHoraLeitura;
        this.fkMaquina = fkMaquina;
    }

    public int getIdCPU() {
        return idCPU;
    }

    public void setIdCPU(int idCPU) {
        this.idCPU = idCPU;
    }

    public Double getQtdUtilizado() {
        return qtdUtilizado;
    }

    public void setQtdUtilizado(Double qtdUtilizado) {
        this.qtdUtilizado = qtdUtilizado;
    }

    public String getTempoAtividade() {
        return TempoAtividade;
    }

    public void setTempoAtividade(String tempoAtividade) {
        TempoAtividade = tempoAtividade;
    }

    public Long getVelocidadeGhz() {
        return VelocidadeGhz;
    }

    public void setVelocidadeGhz(Long velocidadeGhz) {
        VelocidadeGhz = velocidadeGhz;
    }

    public String getDataHoraLeitura() {
        return DataHoraLeitura;
    }

    public void setDataHoraLeitura(String dataHoraLeitura) {
        DataHoraLeitura = dataHoraLeitura;
    }

    public int getFkMaquina() {
        return fkMaquina;
    }

    public void setFkMaquina(int fkMaquina) {
        this.fkMaquina = fkMaquina;
    }

    @Override
    public String toString() {
        return "Cpu{" +
                "idCPU=" + idCPU +
                ", qtdUtilizado=" + qtdUtilizado +
                ", TempoAtividade=" + TempoAtividade +
                ", VelocidadeGhz=" + VelocidadeGhz +
                ", DataHoraLeitura=" + DataHoraLeitura +
                ", fkMaquina=" + fkMaquina +
                '}';
    }

}
