import java.util.ArrayList;
import java.util.List;

public class Calendario {
    private int id;
    private List<Evento> eventos;

    public Calendario(int id) {
        this.id = id;
        eventos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void agendarEvento(Evento evento) {
        eventos.add(evento);
    }

    public void eliminarEvento(int index) {
        if (index >= 0 && index < eventos.size()) {
            eventos.remove(index);
        }
    }

    public void actualizarEvento(int index, Evento eventoActualizado) {
        if (index >= 0 && index < eventos.size()) {
            eventos.set(index, eventoActualizado);
        }
    }

    public String mostrarEventos() {
        String resultado = "";
        for (Evento evento : eventos) {
            resultado += "Nombre: " + evento.getNombre() + ", Fecha: " + evento.getFecha() + ", Hora: " + evento.getHora() + "\n";
        }
        return resultado;
    }
}


