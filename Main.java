import java.util.ArrayList;
import java.util.Scanner;

public class Main {     
    private static ArrayList<Tarea> tareas = new ArrayList<>();
    private static ArrayList<CitaMedica> citasMedicas = new ArrayList<>();
    private static ArrayList<Evento> eventos = new ArrayList<>();
    private static ArrayList<Medicamento> medicamentos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EventoRepository eventoRepo = new EventoRepository();
        MedicamentoRepository medicamentoRepo = new MedicamentoRepository();
        SeguroMedicoRepository seguroMedicoRepo = new SeguroMedicoRepository();
        PerfilMedicoRepository perfilMedicoRepo = new PerfilMedicoRepository();
        MedicoRepository medicoRepository = new MedicoRepository();
        DireccionRepository direccionRepository = new DireccionRepository();
        CitaMedicaRepository citaMedicaRepository = new CitaMedicaRepository();
        MateriaRepository materiaRepository = new MateriaRepository();

        //Evento fechaCaducidad = new Evento(1, "Fecha de Caducidad", "2025-12-31", "23:59");
        //Medicamento medicamento = new Medicamento(2, "paracetamol", 100, 200, 2, fechaCaducidad, 654123);
        //medicamentoRepo.insertDataEntity(medicamento);
        //eventoRepo.insertDataEntity(fechaCaducidad);
        seguroMedicoRepo.insertDataEntity(new SeguroMedico(1, "Proovedor1", "cobertura1"));


        //ArrayList<Evento> lista_eventos = eventoRepo.getDataList();
        //ArrayList<Materia> lista_materias = materiaRepository.getDataList();
        //ArrayList<Medicamento> lista_medicamentos = medicamentoRepo.getDataList();
        //ArrayList<Medico> lista_medicos = medicoRepository.getDataList();
        //ArrayList<Direccion> lista_direcciones = direccionRepository.getDataList();
        //ArrayList<CitaMedica> lista_CitaMedicas = citaMedicaRepository.getDataList();
        //ArrayList<PerfilMedico> lista_PerfilesMedicos = perfilMedicoRepo.getDataList();
        //ArrayList<SeguroMedico> lista_SegurosMedicos = seguroMedicoRepo.getDataList();
        

        
        ArrayList<String> discapacidades = new ArrayList<>();
        discapacidades.add("Visual");
        ArrayList<String> vacunas = new ArrayList<>();
        vacunas.add("Covid-19");
        ArrayList<String> enfermedades = new ArrayList<>();
        enfermedades.add("Asma");
        ArrayList<String> alergias = new ArrayList<>();
        alergias.add("Polen");
        ArrayList<String> restricciones = new ArrayList<>();
        restricciones.add("Paracetamol");


        ArrayList<Medicamento> lista_Medicamentos = medicamentoRepo.getDataList();

        medicamentos.add(lista_Medicamentos.get(0));
        medicamentos.add(lista_Medicamentos.get(1));


        //SeguroMedico seguro = seguroMedicoRepo.findEntityById(1);

        //PerfilMedico perfil = new PerfilMedico(1, discapacidades, vacunas, enfermedades, medicamentos, alergias, restricciones, seguro);
        //perfilMedicoRepo.insertDataEntity(perfil);

        //eventoRepo.insertDataEntity(fechaCaducidad);
        //ArrayList<Medicamento> medicamentos = new ArrayList<>();








        ArrayList<PerfilMedico> listaPerfiles = perfilMedicoRepo.getDataList();
        if (listaPerfiles != null && !listaPerfiles.isEmpty()) {
            System.out.println("Lista de Perfiles Médicos:");
            for (PerfilMedico perfilMedico : listaPerfiles) {
                System.out.println("ID: " + perfilMedico.getId());
                System.out.println("Discapacidades: " + perfilMedico.getDiscapacidades());
                System.out.println("Vacunas: " + perfilMedico.getVacunas());
                System.out.println("Enfermedades: " + perfilMedico.getEnfermedades());

                System.out.print("Medicamentos: ");
                for (Medicamento med : perfilMedico.getMedicamentos()) {
                    System.out.print(med.getNombre() + " ");
                }
                System.out.println();

                System.out.println("Alergias: " + perfilMedico.getAlergias());
                System.out.println("Restricciones: " + perfilMedico.getRestricciones());
                System.out.println("Seguro Médico: " + (perfilMedico.getSeguro() != null ? perfilMedico.getSeguro().getProveedor() : "N/A"));
                System.out.println("-----------------------------");
            }
        }


        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1 -> gestionarTareas();
                case 2 -> gestionarCitasMedicas();
                case 3 -> gestionarEventos();
                case 4 -> gestionarMedicamentos();
                case 5 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opcion no valida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- Que desea visualizar? ---");
        System.out.println("1. Tareas");
        System.out.println("2. Citas Medicas");
        System.out.println("3. Eventos");
        System.out.println("4. Medicamentos");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    //Gestion de Tareas
    private static void gestionarTareas() {
        gestionarLista("Tareas", tareas, Main::crearTarea);
    }

    private static Tarea crearTarea() {
        System.out.print("Ingrese el ID de la tarea: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el nombre de la tarea: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la fecha de entrega (DD-MM-AAAA): ");
        String fecha = scanner.nextLine();

        System.out.print("Ingrese la hora de entrega (HH:MM): ");
        String hora = scanner.nextLine();

        System.out.print("Ingrese el tipo de trabajo (Taller, Trabajo Individual, Parcial, Trabajo Grupal): ");
        String modalidad = scanner.nextLine();

        System.out.print("Ingrese la calificacion obtenida en el trabajo: ");
        float nota = scanner.nextFloat();
        scanner.nextLine();

        return new Tarea(id, nombre, fecha, hora, modalidad, modalidad, nota);
    }

    //Gestion de Citas Medicas 
    private static void gestionarCitasMedicas() {
        gestionarLista("Citas Medicas", citasMedicas, Main::crearCitaMedica);
    }

    private static CitaMedica crearCitaMedica() {
        System.out.print("Ingrese el ID de la cita: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el nombre de la cita: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la fecha de la cita (DD-MM-AAAA): ");
        String fecha = scanner.nextLine();

        System.out.print("Ingrese la hora de la cita (HH:MM): ");
        String hora = scanner.nextLine();

        System.out.print("Ingrese el nombre del medico: ");
        String nombreMedico = scanner.nextLine();

        System.out.print("Ingrese el motivo de la cita: ");
        String motivo = scanner.nextLine();

        System.out.print("Ingrese la especialidad del medico: ");
        String especialidad = scanner.nextLine();

        Medico medico = new Medico(id, nombreMedico, "Apellido", "M", especialidad);
        Direccion direccion = new Direccion(id, 123, 456, "Barrio", 98765, "Estado", "Pais");

        return new CitaMedica(id, nombre, fecha, hora, medico, motivo, especialidad, direccion);
    }

    //Gestion de Eventos
    private static void gestionarEventos() {
        gestionarLista("Eventos", eventos, Main::crearEvento);
    }

    private static Evento crearEvento() {
        System.out.print("Ingrese el ID del evento: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el nombre del evento: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la fecha del evento (DD-MM-AAAA): ");
        String fecha = scanner.nextLine();

        System.out.print("Ingrese la hora del evento (HH:MM): ");
        String hora = scanner.nextLine();

        return new Evento(id, nombre, fecha, hora);
    }

    // Gestion de Medicamentos 
    private static void gestionarMedicamentos() {
        gestionarLista("Medicamentos", medicamentos, Main::crearMedicamento);
    }

    private static Medicamento crearMedicamento() {
        System.out.print("Ingrese el ID del medicamento: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el nombre del medicamento: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la dosis del medicamento: ");
        float dosis = scanner.nextFloat();
        scanner.nextLine();

        System.out.print("Ingrese la cantidad restante del medicamento: ");
        float cantidadRestante = scanner.nextFloat();
        scanner.nextLine();

        System.out.print("Ingrese el periodo del medicamento en dias: ");
        float periodo = scanner.nextFloat();
        scanner.nextLine();

        System.out.print("Ingrese el lote del medicamento: ");
        int lote = scanner.nextInt();
        scanner.nextLine();

        Evento fechaCaducidad = new Evento(id, "Fecha Caducidad", "01-01-2025", "00:00");

        return new Medicamento(id, nombre, dosis, cantidadRestante, periodo, fechaCaducidad, lote);
    }

    
    private static <T> void gestionarLista(String nombre, ArrayList<T> lista, CrearElemento<T> creador) {
        int opcion;
        do {
            System.out.println("\n--- Gestion de " + nombre + " ---");
            mostrarLista(lista);
            System.out.println("1. Anadir");
            System.out.println("2. Modificar");
            System.out.println("3. Eliminar");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    T nuevoElemento = creador.crear();
                    lista.add(nuevoElemento);
                    System.out.println(nombre.substring(0, nombre.length() - 1) + " anadido exitosamente.");
                }
                case 2 -> modificarElemento(lista);
                case 3 -> eliminarElemento(lista);
                case 4 -> System.out.println("Saliendo de Gestion de " + nombre + "...");
                default -> System.out.println("Opcion no valida. Intente nuevamente.");
            }
        } while (opcion != 4);
    }

    private static <T> void modificarElemento(ArrayList<T> lista) {
        mostrarLista(lista);
        System.out.print("Ingrese el indice del elemento que desea modificar: ");
        int indice = scanner.nextInt();
        scanner.nextLine();

        if (indice >= 1 && indice <= lista.size()) {
            System.out.println("Modificacion no implementada. (Puedes personalizar esto para cada tipo de elemento)");
        } else {
            System.out.println("Indice invalido.");
        }
    }

    private static <T> void eliminarElemento(ArrayList<T> lista) {
        mostrarLista(lista);
        System.out.print("Ingrese el indice del elemento que desea eliminar: ");
        int indice = scanner.nextInt();
        scanner.nextLine();

        if (indice >= 1 && indice <= lista.size()) {
            lista.remove(indice - 1);
            System.out.println("Elemento eliminado exitosamente.");
        } else {
            System.out.println("Indice invalido.");
        }
    }

    
    private static <T> void mostrarLista(ArrayList<T> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay elementos en la lista.");
            return;
        }
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + " - " + lista.get(i).toString());
        }
    }

    interface CrearElemento<T> {
        T crear();
    }
}