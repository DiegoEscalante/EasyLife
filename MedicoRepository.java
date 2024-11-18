import java.util.ArrayList;
import java.util.StringTokenizer;

public class MedicoRepository extends Repository<Medico> {
    public MedicoRepository() {
        super("medico.txt", "|");
    }

    @Override
    public void insertDataEntity(Medico medico) {
        this.fileManage.writeFile(this.getDataLine(medico));
    }

    @Override
    public ArrayList<Medico> getDataList() {
        ArrayList<Medico> medicos = null;
        ArrayList<String> lines = this.fileManage.getDataOfFile();
        if (lines != null) {
            medicos = new ArrayList<>();
            for (String line : lines) {
                StringTokenizer tokens = new StringTokenizer(line, this.delimiter);
                int id = Integer.parseInt(tokens.nextToken());
                String nombre = tokens.nextToken();
                String apellido = tokens.nextToken();
                String sexo = tokens.nextToken();
                String especialidad = tokens.nextToken();
                medicos.add(new Medico(id, nombre, apellido, sexo, especialidad));
            }
        }
        return medicos;
    }

    @Override
    public void updateDataEntity(Medico oldMedico, Medico newMedico) {
        this.fileManage.updateFile(
                this.getDataLine(oldMedico),
                this.getDataLine(newMedico)
        );
    }

    @Override
    public void deleteDataEntity(Medico medico) {
        this.fileManage.deleteFile(this.getDataLine(medico));
    }

    @Override
    public String getDataLine(Medico medico) {
        return medico.getId() + this.delimiter +
               medico.getNombre() + this.delimiter +
               medico.getApellido() + this.delimiter +
               //medico.getEdad() + this.delimiter +
               medico.getSexo() + this.delimiter +
               //medico.getDireccion() + this.delimiter +
               medico.getEspecialidad();
    }

    public Medico findEntityById(int id) {
        ArrayList<Medico> medicos = this.getDataList();
        for (Medico medico : medicos) {
            if (medico.getId() == id) {
                return medico;
            }
        }
        return null;
    }
}
