import java.util.ArrayList;
import java.util.List;

public class Materia {
    private int id;
    private List<Float> porcentajeCortes;
    private float porcentajeTI;
    private float porcentajeQuiz;
    private float porcentajeParcial;
    private List<Tarea> tareas;

    public Materia(int id, List<Float> porcentajeCortes, float porcentajeTI, float porcentajeQuiz, float porcentajeParcial) {
        this.id = id;
        this.porcentajeCortes = porcentajeCortes;
        this.porcentajeTI = porcentajeTI;
        this.porcentajeQuiz = porcentajeQuiz;
        this.porcentajeParcial = porcentajeParcial;
        this.tareas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public float calcularNotas() {
        float notaTotal = 0;
        float sumaTareas = 0;
        
        for (Tarea tarea : tareas) {
            sumaTareas += tarea.getNota();
        }
        
        float promedioTareas = tareas.isEmpty() ? 0 : sumaTareas / tareas.size();
        notaTotal += promedioTareas * (porcentajeTI / 100);

        float notaQuiz = 3.5f;
        float notaParcial = 4.0f;

        notaTotal += notaQuiz * (porcentajeQuiz / 100);
        notaTotal += notaParcial * (porcentajeParcial / 100);

        return notaTotal;
    }

    public float calcularNotaCortes() {
        float notaCortesTotal = 0;
        for (Float porcentajeCorte : porcentajeCortes) {
            notaCortesTotal += porcentajeCorte;
        }
        return notaCortesTotal;
    }

    public void darRecomendacion() {
        float notaFinal = calcularNotas();
        
        if (notaFinal >= 4.5) {
            System.out.println("Excelente trabajo Sigue asi");
        } else if (notaFinal >= 3.0) {
            System.out.println("Buen trabajo, pero puedes mejorar en algunas areas");
        } else {
            System.out.println("Debes esforzarte mas Considera repasar el contenido y mejorar en proximas evaluaciones");
        }
    }
}

