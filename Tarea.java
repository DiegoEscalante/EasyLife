public class Tarea extends Evento{
    private String modalidad;
    private String tipoTrabajo;
    private float nota;

    public Tarea(int id, String nombre, String fecha, String hora, String modalidad, String tipoTrabajo, float nota) {
        super(id, nombre, fecha, hora);
        this.modalidad = modalidad;
        this.tipoTrabajo = tipoTrabajo;
        this.nota = nota;
    }

    public String getModalidad() {
        return modalidad;
    }

    public String getTipoTrabajo() {
        return tipoTrabajo;
    }

    public float getNota() {
        return nota;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public void setTipoTrabajo(String tipoTrabajo) {
        this.tipoTrabajo = tipoTrabajo;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
}