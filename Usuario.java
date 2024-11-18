import java.util.ArrayList;

public class Usuario extends Persona{
    private PerfilMedico perfilMedico;
    private ArrayList<Evento> calendario;
    private ArrayList<Materia> materias;

    public Usuario(int id, String nombre, String apellido, int edad, String sexo, Direccion direccion, PerfilMedico perfilMedico, ArrayList<Evento> calendario, ArrayList<Materia> materias){
        super(id, nombre, apellido, edad, sexo, direccion);
        this.perfilMedico = perfilMedico;
        this.calendario = calendario;
        this.materias = materias;
    }
}
