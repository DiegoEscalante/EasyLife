import java.util.ArrayList;
import java.util.StringTokenizer;

public class TareaRepository extends Repository<Tarea>{
    public TareaRepository(){
        super("tarea.txt", "|");
    }
    @Override
    public void insertDataEntity(Tarea Tarea) {
        this.fileManage.writeFile(this.getDataLine(Tarea));
    }

    @Override
    public ArrayList<Tarea> getDataList(){
        ArrayList<Tarea> tareas = null;
        ArrayList<String> lines = this.fileManage.getDataOfFile();
        if(lines != null){
            tareas = new ArrayList<>();
            for (String line : lines){
                StringTokenizer tokens = new StringTokenizer(line, this.delimiter);
                int id = Integer.parseInt(tokens.nextToken());
                String nombre = tokens.nextToken();
                String fecha = tokens.nextToken();
                String hora = tokens.nextToken();
                String modalidad = tokens.nextToken();
                String tipoTrabajo = tokens.nextToken();
                float nota = Float.parseFloat(tokens.nextToken());
                tareas.add(new Tarea(id, nombre, fecha, hora, modalidad, tipoTrabajo, nota));
            }
        }
        return tareas;
    }

    @Override
    public void updateDataEntity(Tarea oldTarea, Tarea newTarea){
        this.fileManage.updateFile(
                this.getDataLine(oldTarea),
                this.getDataLine(newTarea)
        );
    }

    @Override
    public void deleteDataEntity(Tarea tarea) {
        this.fileManage.deleteFile(this.getDataLine(tarea));
    }


    @Override
    public String getDataLine(Tarea tarea){
        return tarea.getId() + this.delimiter + tarea.getNombre() + this.delimiter + tarea.getFecha() + this.delimiter + tarea.getHora() + this.delimiter + tarea.getModalidad() + this.delimiter + tarea.getTipoTrabajo() + this.delimiter + tarea.getNota();
    }

    public Tarea findEntityById(int id){
        ArrayList<Tarea> tareas = this.getDataList();
        for (Tarea Tarea : tareas){
            if(Tarea.getId() == id){
                return Tarea;
            }
        }
        return null;
    }

}
