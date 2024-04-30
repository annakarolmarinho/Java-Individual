public class HD {

    private int idHD;
    private String TempoDeAtividade;
    private Long TaxaTransferenciaDados;
    private String DataHoraLeitura;
    private int fkMaquina;

    public HD(){}
    public HD(int idHD, String tempoDeAtividade, Long taxaTransferenciaDados, String dataHoraLeitura, int fkMaquina) {
        this.idHD = idHD;
        TempoDeAtividade = tempoDeAtividade;
        TaxaTransferenciaDados = taxaTransferenciaDados;
        DataHoraLeitura = dataHoraLeitura;
        this.fkMaquina = fkMaquina;
    }

    public int getIdHD() {
        return idHD;
    }

    public void setIdHD(int idHD) {
        this.idHD = idHD;
    }

    public String getTempoDeAtividade() {
        return TempoDeAtividade;
    }

    public void setTempoDeAtividade(String tempoDeAtividade) {
        TempoDeAtividade = tempoDeAtividade;
    }

    public Long getTaxaTransferenciaDados() {
        return TaxaTransferenciaDados;
    }

    public void setTaxaTransferenciaDados(Long taxaTransferenciaDados) {
        TaxaTransferenciaDados = taxaTransferenciaDados;
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
        return "HD{" +
                "idHD=" + idHD +
                ", TempoDeAtividade='" + TempoDeAtividade + '\'' +
                ", TaxaTransferenciaDados=" + TaxaTransferenciaDados +
                ", DataHoraLeitura='" + DataHoraLeitura + '\'' +
                ", fkMaquina=" + fkMaquina +
                '}';
    }
}
