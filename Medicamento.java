public class Medicamento {
    private int id;
    private String nombre;
    private float dosis;
    private float cantidadRestante;
    private float periodo;
    private Evento fechaCaducidad;
    private int lote;

    public Medicamento(int id, String nombre, float dosis, float cantidadRestante, float periodo, Evento fechaCaducidad, int lote) {
        this.id = id;
        this.nombre = nombre;
        this.dosis = dosis;
        this.cantidadRestante = cantidadRestante;
        this.periodo = periodo;
        this.fechaCaducidad = fechaCaducidad;
        this.lote = lote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getDosis() {
        return dosis;
    }

    public void setDosis(float dosis) {
        this.dosis = dosis;
    }

    public float getCantidadRestante() {
        return cantidadRestante;
    }

    public void setCantidadRestante(float cantidadRestante) {
        this.cantidadRestante = cantidadRestante;
    }

    public float getPeriodo() {
        return periodo;
    }

    public void setPeriodo(float periodo) {
        this.periodo = periodo;
    }

    public Evento getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Evento fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public String getInformacion() {
        return "Medicamento: " + nombre + ", Lote: " + lote+ ", Dosis: " + dosis + "mg, Cantidad Restante: " + cantidadRestante + "mg, Periodo: " + periodo + " días, Fecha de Caducidad: " + fechaCaducidad.getFecha();
    }

    public void actualizarCantidad(float cantidadUsada) {
        if (cantidadUsada > 0 && cantidadUsada <= cantidadRestante) {
            cantidadRestante -= cantidadUsada;
        }
    }



}
