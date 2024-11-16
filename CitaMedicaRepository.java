import java.util.ArrayList;
import java.util.StringTokenizer;

public class CitaMedicaRepository extends Repository<CitaMedica> {
    private MedicoRepository medicoRepository;
    private DireccionRepository direccionRepository;

    public CitaMedicaRepository(){
        super("citaMedica.txt", "|");
        this.medicoRepository = new MedicoRepository();
        this.direccionRepository = new DireccionRepository();
    }

    @Override
    public void insertDataEntity(CitaMedica citaMedica) {
        this.fileManage.writeFile(this.getDataLine(citaMedica));
    }

    @Override
    public ArrayList<CitaMedica> getDataList() {
        ArrayList<CitaMedica> citasMedicas = null;
        ArrayList<String> lines = this.fileManage.getDataOfFile();
        if (lines != null) {
            citasMedicas = new ArrayList<>();
            for (String line : lines) {
                StringTokenizer tokens = new StringTokenizer(line, this.delimiter);

                int id = Integer.parseInt(tokens.nextToken());
                String nombre = tokens.nextToken();
                String fecha = tokens.nextToken();
                String hora = tokens.nextToken();
                int medicoId = Integer.parseInt(tokens.nextToken());
                String motivo = tokens.nextToken();
                String especialidad = tokens.nextToken();
                int direccionId = Integer.parseInt(tokens.nextToken());

                Medico medico = medicoRepository.findEntityById(medicoId);
                Direccion direccion = direccionRepository.findEntityById(direccionId);

                if (medico != null && direccion != null) {
                    CitaMedica citaMedica = new CitaMedica(id, nombre, fecha, hora, medico, motivo, especialidad, direccion);
                    citasMedicas.add(citaMedica);
                }
            }
        }
        return citasMedicas;
    }

    @Override
    public void updateDataEntity(CitaMedica oldCita, CitaMedica newCita) {
        this.fileManage.updateFile(
                this.getDataLine(oldCita),
                this.getDataLine(newCita)
        );
    }

    @Override
    public void deleteDataEntity(CitaMedica citaMedica) {
        this.fileManage.deleteFile(this.getDataLine(citaMedica));
    }

    @Override
    public String getDataLine(CitaMedica citaMedica) {
        return citaMedica.getId() + this.delimiter +
                citaMedica.getNombre() + this.delimiter +
                citaMedica.getFecha() + this.delimiter +
                citaMedica.getHora() + this.delimiter +
                citaMedica.getMedico().getId() + this.delimiter +
                citaMedica.getMotivo() + this.delimiter +
                citaMedica.getEspecialidad() + this.delimiter +
                citaMedica.getDireccion().getId();
    }

    public CitaMedica findEntityById(int id) {
        ArrayList<CitaMedica> citasMedicas = this.getDataList();
        for (CitaMedica citaMedica : citasMedicas) {
            if (citaMedica.getId() == id) {
                return citaMedica;
            }
        }
        return null;
    }
}
