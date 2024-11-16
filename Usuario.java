import java.util.List;

public class Usuario extends Persona{
    private PerfilMedico perfilMedico;
    private Calendario calendario;
    private List<Materia> materias;

    public Usuario(int id, String nombre, String apellido, int edad, String sexo, Direccion direccion, PerfilMedico perfilMedico, Calendario calendario, List<Materia> materias){
        super(id, nombre, apellido, edad, sexo, direccion);
        this.perfilMedico = perfilMedico;
        this.calendario = calendario;
        this.materias = materias;
    }
}
