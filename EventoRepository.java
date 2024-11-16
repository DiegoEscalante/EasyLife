import java.util.ArrayList;
import java.util.StringTokenizer;

public class EventoRepository extends Repository<Evento>{
    public EventoRepository(){
        super("evento.txt", "|");
    }
    @Override
    public void insertDataEntity(Evento evento) {
        this.fileManage.writeFile(this.getDataLine(evento));
    }

    @Override
    public ArrayList<Evento> getDataList(){
        ArrayList<Evento> eventos = null;
        ArrayList<String> lines = this.fileManage.getDataOfFile();
        if(lines != null){
            eventos = new ArrayList<>();
            for (String line : lines){
                StringTokenizer tokens = new StringTokenizer(line, this.delimiter);
                int id = Integer.parseInt(tokens.nextToken());
                String nombre = tokens.nextToken();
                String fecha = tokens.nextToken();
                String hora = tokens.nextToken();
                eventos.add(new Evento(id, nombre, fecha, hora));
            }
        }
        return eventos;
    }

    @Override
    public void updateDataEntity(Evento oldEvento, Evento newEvento){
        this.fileManage.updateFile(
                this.getDataLine(oldEvento),
                this.getDataLine(newEvento)
        );
    }

    @Override
    public void deleteDataEntity(Evento evento) {
        this.fileManage.deleteFile(this.getDataLine(evento));
    }


    @Override
    public String getDataLine(Evento evento){
        return evento.getId() + this.delimiter + evento.getNombre() + this.delimiter + evento.getFecha() + this.delimiter + evento.getHora();
    }

    public Evento findEntityById(int id){
        ArrayList<Evento> eventos = this.getDataList();
        for (Evento Evento : eventos){
            if(Evento.getId() == id){
                return Evento;
            }
        }
        return null;
    }

}