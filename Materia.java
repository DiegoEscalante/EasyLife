import java.util.ArrayList;

public class Materia {
    private int id;
    private ArrayList<Float> porcentajeCortes;
    private float porcentajeTI;
    private float porcentajeQuiz;
    private float porcentajeParcial;
    private ArrayList<Tarea> tareas;

    public Materia(int id, ArrayList<Float> porcentajeCortes, float porcentajeTI, float porcentajeQuiz, float porcentajeParcial, ArrayList<Tarea> tareas) {
        this.id = id;
        this.porcentajeCortes = porcentajeCortes;
        this.porcentajeTI = porcentajeTI;
        this.porcentajeQuiz = porcentajeQuiz;
        this.porcentajeParcial = porcentajeParcial;
        this.tareas = new ArrayList<>();
    }

    public Materia() {
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
        for (float porcentajeCorte : porcentajeCortes) {
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



    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return ArrayList<float> return the porcentajeCortes
     */
    public ArrayList<Float> getPorcentajeCortes() {
        return porcentajeCortes;
    }

    /**
     * @param porcentajeCortes the porcentajeCortes to set
     */
    public void setPorcentajeCortes(ArrayList<Float> porcentajeCortes) {
        this.porcentajeCortes = porcentajeCortes;
    }

    /**
     * @return float return the porcentajeTI
     */
    public float getPorcentajeTI() {
        return porcentajeTI;
    }

    /**
     * @param porcentajeTI the porcentajeTI to set
     */
    public void setPorcentajeTI(float porcentajeTI) {
        this.porcentajeTI = porcentajeTI;
    }

    /**
     * @return float return the porcentajeQuiz
     */
    public float getPorcentajeQuiz() {
        return porcentajeQuiz;
    }

    /**
     * @param porcentajeQuiz the porcentajeQuiz to set
     */
    public void setPorcentajeQuiz(float porcentajeQuiz) {
        this.porcentajeQuiz = porcentajeQuiz;
    }

    /**
     * @return float return the porcentajeParcial
     */
    public float getPorcentajeParcial() {
        return porcentajeParcial;
    }

    /**
     * @param porcentajeParcial the porcentajeParcial to set
     */
    public void setPorcentajeParcial(float porcentajeParcial) {
        this.porcentajeParcial = porcentajeParcial;
    }

    /**
     * @return ArrayList<Tarea> return the tareas
     */
    public ArrayList<Tarea> getTareas() {
        return tareas;
    }

    /**
     * @param tareas the tareas to set
     */
    public void setTareas(ArrayList<Tarea> tareas) {
        this.tareas = tareas;
    }

}

