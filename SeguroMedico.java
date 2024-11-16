public class SeguroMedico {
    private int id;
    private String proveedor;
    private String cobertura;

    public SeguroMedico(int id, String proveedor, String cobertura) {
        this.id = id;
        this.proveedor = proveedor;
        this.cobertura = cobertura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }
}
