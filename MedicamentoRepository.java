import java.util.ArrayList;
import java.util.StringTokenizer;

public class MedicamentoRepository extends Repository<Medicamento> {

    private EventoRepository eventoRepository;

    public MedicamentoRepository(){
        super("medicamento.txt", "|");
        this.eventoRepository = new EventoRepository();
    }

    @Override
    public void insertDataEntity(Medicamento medicamento) {
        this.fileManage.writeFile(this.getDataLine(medicamento));
    }

    @Override
    public ArrayList<Medicamento> getDataList(){
        ArrayList<Medicamento> medicamentos = null;
        ArrayList<String> lines = this.fileManage.getDataOfFile();
        if(lines != null){
            medicamentos = new ArrayList<>();
            for (String line : lines){
                StringTokenizer tokens = new StringTokenizer(line, this.delimiter);
                int id = Integer.parseInt(tokens.nextToken());
                String nombre = tokens.nextToken();
                float dosis = Float.parseFloat(tokens.nextToken());
                float cantidadRestante = Float.parseFloat(tokens.nextToken());
                float periodo = Float.parseFloat(tokens.nextToken());
                int fechaCaducidadId = Integer.parseInt(tokens.nextToken());
                int lote = Integer.parseInt(tokens.nextToken());


                Evento fechaCaducidad = eventoRepository.findEntityById(fechaCaducidadId);
                if (fechaCaducidad != null) {
                    Medicamento medicamento = new Medicamento(id, nombre, dosis, cantidadRestante, periodo, fechaCaducidad, lote);
                    medicamentos.add(medicamento);
                }
            }
        }
        return medicamentos;
    }

    @Override
    public void updateDataEntity(Medicamento oldMedicamento, Medicamento newMedicamento){
        this.fileManage.updateFile(
                this.getDataLine(oldMedicamento),
                this.getDataLine(newMedicamento)
        );
    }

    @Override
    public void deleteDataEntity(Medicamento medicamento) {
        this.fileManage.deleteFile(this.getDataLine(medicamento));
    }


    @Override
    public String getDataLine(Medicamento medicamento){
        return medicamento.getId() + this.delimiter + medicamento.getNombre() + this.delimiter + medicamento.getDosis() + this.delimiter + medicamento.getCantidadRestante() + this.delimiter + medicamento.getPeriodo() + this.delimiter + medicamento.getFechaCaducidad().getId() + this.delimiter + medicamento.getLote();
    }

    public Medicamento findEntityById(int id){
        ArrayList<Medicamento> medicamentos = this.getDataList();
        for (Medicamento medicamento : medicamentos){
            if(medicamento.getId() == id){
                return medicamento;
            }
        }
        return null;
    }

}
