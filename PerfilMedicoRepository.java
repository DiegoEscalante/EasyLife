
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class PerfilMedicoRepository extends Repository<PerfilMedico> {

    private MedicamentoRepository medicamentoRepository;
    private SeguroMedicoRepository seguroMedicoRepository;

    public PerfilMedicoRepository() {
        super("PerfilMedicos.txt", "|");
        this.medicamentoRepository = new MedicamentoRepository();
        this.seguroMedicoRepository = new SeguroMedicoRepository();
    }

    @Override
    public ArrayList<PerfilMedico> getDataList() {
        ArrayList<PerfilMedico> perfiles = null;
        ArrayList<String> lines = this.fileManage.getDataOfFile();
        if (lines != null) {
            perfiles = new ArrayList<>();
            for (String line : lines) {
                StringTokenizer tokens = new StringTokenizer(line, this.delimiter);
                int id = Integer.parseInt(tokens.nextToken());
                ArrayList<String> discapacidades = parseStringToStringList(tokens.nextToken());
                ArrayList<String> vacunas = parseStringToStringList(tokens.nextToken());
                ArrayList<String> enfermedades = parseStringToStringList(tokens.nextToken());
                ArrayList<Integer> medicamentos_id = parseStringToIntegerList(tokens.nextToken());
                ArrayList<Medicamento> medicamentos = new ArrayList<>();
                for (int medicamento_id : medicamentos_id) {
                    medicamentos.add(medicamentoRepository.findEntityById(medicamento_id));
                }
                ArrayList<String> alergias = parseStringToStringList(tokens.nextToken());
                ArrayList<String> restricciones = parseStringToStringList(tokens.nextToken());
                SeguroMedico seguroMedico = seguroMedicoRepository.findEntityById(Integer.parseInt(tokens.nextToken()));

                perfiles.add(new PerfilMedico(id, discapacidades, vacunas, enfermedades, medicamentos, alergias, restricciones, seguroMedico));
            }
        }
        return perfiles;
    }

    @Override
    public void insertDataEntity(PerfilMedico perfilMedico) {
        this.fileManage.writeFile(this.getDataLine(perfilMedico));
    }

    @Override
    public void updateDataEntity(PerfilMedico oldPerfilMedico, PerfilMedico newPerfilMedico) {
        this.fileManage.updateFile(
                this.getDataLine(oldPerfilMedico),
                this.getDataLine(newPerfilMedico)
        );
    }

    @Override
    public void deleteDataEntity(PerfilMedico deletePerfilMedico) {
        this.fileManage.deleteFile(this.getDataLine(deletePerfilMedico));
    }

    @Override
    public String getDataLine(PerfilMedico perfilMedico) {
        ArrayList<Medicamento> medicamentos = perfilMedico.getMedicamentos();
        ArrayList<Integer> medicamentos_id = new ArrayList<>();
        for (Medicamento medicamento : medicamentos) {
            medicamentos_id.add(medicamento.getId());
        }
        String medicamentos_id_String = convertIntegerListToString(medicamentos_id);

        return perfilMedico.getId() + this.delimiter
                + convertStringListToString(perfilMedico.getDiscapacidades()) + this.delimiter
                + convertStringListToString(perfilMedico.getVacunas()) + this.delimiter
                + convertStringListToString(perfilMedico.getEnfermedades()) + this.delimiter
                + medicamentos_id_String + this.delimiter
                + convertStringListToString(perfilMedico.getAlergias()) + this.delimiter
                + convertStringListToString(perfilMedico.getRestricciones()) + this.delimiter
                + perfilMedico.getSeguro().getId();
    }

    private ArrayList<String> parseStringToStringList(String input) {
        ArrayList<String> list = new ArrayList<>();
        if (input != null && !input.isEmpty()) {
            String[] items = input.split(",");
            for (String item : items) {
                list.add(item.trim());
            }
        }
        return list;
    }

    private ArrayList<Integer> parseStringToIntegerList(String input) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input != null && !input.isEmpty()) {
            String[] items = input.split(",");
            for (String item : items) {
                list.add(Integer.parseInt(item.trim()));
            }
        }
        return list;
    }

    private String convertStringListToString(ArrayList<String> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        return String.join(",", list);
    }

    private String convertIntegerListToString(ArrayList<Integer> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        return list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }
}
