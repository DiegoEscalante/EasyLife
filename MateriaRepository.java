import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class MateriaRepository extends Repository<Materia> {
    private TareaRepository tareaRepository;

    public MateriaRepository(){
        super("materia.txt", "|");
        this.tareaRepository = new TareaRepository();
    }

    @Override
    public void insertDataEntity(Materia materia) {
        this.fileManage.writeFile(this.getDataLine(materia));
    }

    @Override
    public ArrayList<Materia> getDataList() {
        ArrayList<Materia> materias = null;
        ArrayList<String> lines = this.fileManage.getDataOfFile();
        if (lines != null) {
            materias = new ArrayList<>();
            for (String line : lines) {
                StringTokenizer tokens = new StringTokenizer(line, this.delimiter);
                
                int id = Integer.parseInt(tokens.nextToken());
                
                ArrayList<Float> porcentajeCortes = parseStringToFloatList(tokens.nextToken());

                float porcentajeTI = Float.parseFloat(tokens.nextToken());

                float porcentajeQuiz = Float.parseFloat(tokens.nextToken());
                float porcentajeParcial = Float.parseFloat(tokens.nextToken());
                
                ArrayList<Integer> tareas_id = parseStringToIntegerList(tokens.nextToken());
                ArrayList<Tarea> tareas = new ArrayList<>();
                for (int tarea_id : tareas_id) {
                    tareas.add(tareaRepository.findEntityById(tarea_id));
                }
                Materia materia = new Materia(id, porcentajeCortes, porcentajeTI, porcentajeQuiz, porcentajeParcial, tareas);
                materias.add(materia);
            }
        }
        return materias;
    }


    @Override
    public void updateDataEntity(Materia oldMateria, Materia newMateria) {
        this.fileManage.updateFile(
                this.getDataLine(oldMateria),
                this.getDataLine(newMateria)
        );
    }

    @Override
    public void deleteDataEntity(Materia materia) {
        this.fileManage.deleteFile(this.getDataLine(materia));
    }

    @Override
    public String getDataLine(Materia materia) {
        ArrayList<Tarea> tareas = materia.getTareas();
        ArrayList<Integer> tareas_id = new ArrayList<>();
        for (Tarea tarea : tareas) {
            tareas_id.add(tarea.getId());
        }
        String tareas_id_String = convertIntegerListToString(tareas_id);


        return materia.getId() + this.delimiter +
                convertFloatListToString(materia.getPorcentajeCortes()) + this.delimiter +
                materia.getPorcentajeTI() + this.delimiter +
                materia.getPorcentajeQuiz() + this.delimiter +
                materia.getPorcentajeParcial() +
                tareas_id_String;
    }

    public Materia findEntityById(int id) {
        ArrayList<Materia> materias = this.getDataList();
        for (Materia materia : materias) {
            if (materia.getId() == id) {
                return materia;
            }
        }
        return null;
    }


    private ArrayList<Float> parseStringToFloatList(String input) {
        ArrayList<Float> list = new ArrayList<>();
        if (input != null && !input.isEmpty()) {
            String[] items = input.split(",");
            for (String item : items) {
                list.add(Float.parseFloat(item.trim()));
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

    private String convertFloatListToString(ArrayList<Float> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        return list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
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


