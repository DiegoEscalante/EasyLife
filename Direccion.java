public class Direccion {
    private int id;
    private int calle;
    private int numero;
    private String barrio;
    private int codigoPostal;
    private String estado;
    private String pais;

    public Direccion(int id, int calle, int numero, String barrio, int codigoPostal, String estado, String pais){
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.barrio = barrio;
        this.codigoPostal = codigoPostal;
        this.estado = estado;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCalle() {
        return calle;
    }

    public void setCalle(int calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}