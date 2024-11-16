import java.util.List;
public class PerfilMedico {
    private int id;
    private List<String> discapacidades;
    private List<String> vacunas;
    private List<String> enfermedades;
    private List<Medicamento> medicamentos;
    private List<String> alergias;
    private List<String> restricciones;
    private SeguroMedico seguro;

    public PerfilMedico(int id, List<String> discapacidades, List<String> vacunas, List<String> enfermedades,
                        List<Medicamento> medicamentos, List<String> alergias, List<String> restricciones, SeguroMedico seguro) {
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

    public List<String> getDiscapacidades() {
        return discapacidades;
    }

    public void setDiscapacidades(List<String> discapacidades) {
        this.discapacidades = discapacidades;
    }

    public List<String> getVacunas() {
        return vacunas;
    }

    public void setVacunas(List<String> vacunas) {
        this.vacunas = vacunas;
    }

    public List<String> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(List<String> enfermedades) {
        this.enfermedades = enfermedades;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public List<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(List<String> alergias) {
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
}
