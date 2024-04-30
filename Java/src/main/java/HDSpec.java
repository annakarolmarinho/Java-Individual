public class HDSpec {

    private int idHDSpec;
    private String marca;
    private String modelo;
    private Long armazenamentoTotal;
    private Long transferenciaDadosGBs;
    private String conector;
    private int fkHD;

    public HDSpec(){}
    public HDSpec(int idHDSpec, String marca, String modelo, Long armazenamentoTotal, Long transferenciaDadosGBs, String conector, int fkHD) {
        this.idHDSpec = idHDSpec;
        this.marca = marca;
        this.modelo = modelo;
        this.armazenamentoTotal = armazenamentoTotal;
        this.transferenciaDadosGBs = transferenciaDadosGBs;
        this.conector = conector;
        this.fkHD = fkHD;
    }

    public int getIdHDSpec() {
        return idHDSpec;
    }

    public void setIdHDSpec(int idHDSpec) {
        this.idHDSpec = idHDSpec;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Long getArmazenamentoTotal() {
        return armazenamentoTotal;
    }

    public void setArmazenamentoTotal(Long armazenamentoTotal) {
        this.armazenamentoTotal = armazenamentoTotal;
    }

    public Long getTransferenciaDadosGBs() {
        return transferenciaDadosGBs;
    }

    public void setTransferenciaDadosGBs(Long transferenciaDadosGBs) {
        this.transferenciaDadosGBs = transferenciaDadosGBs;
    }

    public String getConector() {
        return conector;
    }

    public void setConector(String conector) {
        this.conector = conector;
    }

    public int getFkHD() {
        return fkHD;
    }

    public void setFkHD(int fkHD) {
        this.fkHD = fkHD;
    }

    @Override
    public String toString() {
        return "HDSpec{" +
                "idHDSpec=" + idHDSpec +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", armazenamentoTotal=" + armazenamentoTotal +
                ", transferenciaDadosGBs=" + transferenciaDadosGBs +
                ", conector='" + conector + '\'' +
                ", fkHD=" + fkHD +
                '}';
    }
}
