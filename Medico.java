public class Medico extends Persona {
    private String especialidad;

    public Medico(int id, String nombre, String apellido, String sexo, String especialidad) {
        super(id, nombre, apellido, sexo);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getInfoMedico() {
        return getNombre() + " " + getApellido() + ", Especialidad: " + especialidad;
    }
}
