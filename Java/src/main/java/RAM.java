public class RAM {

    private int idRAM;
    private Long UsoMemoria;
    private Long TOTALMemoria;
    private String DataHoraLeitura;
    private int fkMaquina;

    public RAM(){}
    public RAM(int idRAM, Long usoMemoria, Long TOTALMemoria, String dataHoraLeitura, int fkMaquina) {
        this.idRAM = idRAM;
        UsoMemoria = usoMemoria;
        this.TOTALMemoria = TOTALMemoria;
        DataHoraLeitura = dataHoraLeitura;
        this.fkMaquina = fkMaquina;
    }

    public int getIdRAM() {
        return idRAM;
    }

    public void setIdRAM(int idRAM) {
        this.idRAM = idRAM;
    }

    public Long getUsoMemoria() {
        return UsoMemoria;
    }

    public void setUsoMemoria(Long usoMemoria) {
        UsoMemoria = usoMemoria;
    }

    public Long getTOTALMemoria() {
        return TOTALMemoria;
    }

    public void setTOTALMemoria(Long TOTALMemoria) {
        this.TOTALMemoria = TOTALMemoria;
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
        return "RAM{" +
                "idRAM=" + idRAM +
                ", UsoMemoria=" + UsoMemoria +
                ", TOTALMemoria=" + TOTALMemoria +
                ", DataHoraLeitura='" + DataHoraLeitura + '\'' +
                ", fkMaquina=" + fkMaquina +
                '}';
    }
}
