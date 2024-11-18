import java.util.ArrayList;
public class PerfilMedico {
    private int id;
    private ArrayList<String> discapacidades;
    private ArrayList<String> vacunas;
    private ArrayList<String> enfermedades;
    private ArrayList<Medicamento> medicamentos;
    private ArrayList<String> alergias;
    private ArrayList<String> restricciones;
    private SeguroMedico seguro;

    public PerfilMedico(int id, ArrayList<String> discapacidades, ArrayList<String> vacunas, ArrayList<String> enfermedades,
                        ArrayList<Medicamento> medicamentos, ArrayList<String> alergias, ArrayList<String> restricciones, SeguroMedico seguro) {
        this.id = id;
        this.discapacidades = discapacidades;
        this.vacunas = vacunas;
        this.enfermedades = enfermedades;
        this.medicamentos = medicamentos;
        this.alergias = alergias;
        this.restricciones = restricciones;
        this.seguro = seguro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getDiscapacidades() {
        return discapacidades;
    }

    public void setDiscapacidades(ArrayList<String> discapacidades) {
        this.discapacidades = discapacidades;
    }

    public ArrayList<String> getVacunas() {
        return vacunas;
    }

    public void setVacunas(ArrayList<String> vacunas) {
        this.vacunas = vacunas;
    }

    public ArrayList<String> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(ArrayList<String> enfermedades) {
        this.enfermedades = enfermedades;
    }

    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(ArrayList<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public ArrayList<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(ArrayList<String> alergias) {
        this.alergias = alergias;
    }

    public SeguroMedico getSeguro() {
        return this.seguro;
    }

    public void setSeguro(SeguroMedico seguro) {
        this.seguro = seguro;
    }

    

    public void comprobarIncompatibilidades() {
        boolean hayIncompatibilidades = false;

        for (String restriccion : restricciones) {
            for (Medicamento medicamento : medicamentos) {
                if (restriccion.equalsIgnoreCase(medicamento.getNombre())) {
                    System.out.println("Incompatibilidad encontrada con el medicamento: " + medicamento.getNombre());
                    hayIncompatibilidades = true;
                }
            }
        }

        if (!hayIncompatibilidades) {
            System.out.println("No se encontraron incompatibilidades.");
        }
    }


    public ArrayList<String> getRestricciones() {
        return restricciones;
    }

    public void setRestricciones(ArrayList<String> restricciones) {
        this.restricciones = restricciones;
    }

}
