public class CitaMedica extends Evento{
    private Medico medico;
    private String motivo;
    private String especialidad;
    private Direccion direccion;

    public CitaMedica(int id, String nombre, String fecha, String hora, Medico medico, String motivo, String especialidad, Direccion direccion) {
        super(id, nombre, fecha, hora);
        this.medico = medico;
        this.motivo = motivo;
        this.especialidad = especialidad;
        this.direccion = direccion;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
