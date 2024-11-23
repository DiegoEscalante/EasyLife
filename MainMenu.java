import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    private static ArrayList<Tarea> tareas = new ArrayList<>();
    private static ArrayList<CitaMedica> citasMedicas = new ArrayList<>();
    private static ArrayList<Evento> eventos = new ArrayList<>();
    private static ArrayList<Medicamento> medicamentos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ejecutarMenuPrincipal();
    }

    private static void ejecutarMenuPrincipal() {
        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = obtenerEntradaEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1 -> gestionarLista("Tareas", tareas, MainMenu::crearTarea);
                case 2 -> gestionarLista("Citas Médicas", citasMedicas, MainMenu::crearCitaMedica);
                case 3 -> gestionarLista("Eventos", eventos, MainMenu::crearEvento);
                case 4 -> gestionarLista("Medicamentos", medicamentos, MainMenu::crearMedicamento);
                case 5 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- ¿Qué desea visualizar? ---");
        System.out.println("1. Tareas");
        System.out.println("2. Citas Médicas");
        System.out.println("3. Eventos");
        System.out.println("4. Medicamentos");
        System.out.println("5. Salir");
    }


    private static <T> void gestionarLista(String nombre, ArrayList<T> lista, CrearElemento<T> creador) {
        int opcion;
        do {
            System.out.println("\n--- Gestión de " + nombre + " ---");
            mostrarLista(lista);
            mostrarMenuLista();
            opcion = obtenerEntradaEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1 -> añadirElemento(lista, creador);
                case 2 -> modificarElemento(lista);
                case 3 -> eliminarElemento(lista);
                case 4 -> System.out.println("Saliendo de Gestión de " + nombre + "...");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 4);
    }

    private static void mostrarMenuLista() {
        System.out.println("1. Añadir");
        System.out.println("2. Modificar");
        System.out.println("3. Eliminar");
        System.out.println("4. Salir");
    }

    private static <T> void mostrarLista(ArrayList<T> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay elementos en la lista.");
        } else {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println((i + 1) + " - " + lista.get(i));
            }
        }
    }

    private static <T> void añadirElemento(ArrayList<T> lista, CrearElemento<T> creador) {
        T nuevoElemento = creador.crear();
        lista.add(nuevoElemento);
        System.out.println("Elemento añadido exitosamente.");
    }

    private static <T> void modificarElemento(ArrayList<T> lista) {
        mostrarLista(lista);
        int indice = obtenerEntradaEntero("Ingrese el índice del elemento que desea modificar: ") - 1;
        if (esIndiceValido(indice, lista.size())) {
            System.out.println("Modificación no implementada. (Personalice este método según sea necesario)");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private static <T> void eliminarElemento(ArrayList<T> lista) {
        mostrarLista(lista);
        int indice = obtenerEntradaEntero("Ingrese el índice del elemento que desea eliminar: ") - 1;
        if (esIndiceValido(indice, lista.size())) {
            lista.remove(indice);
            System.out.println("Elemento eliminado exitosamente.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private static boolean esIndiceValido(int indice, int tamaño) {
        return indice >= 0 && indice < tamaño;
    }

    private static int obtenerEntradaEntero(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    private static String obtenerEntradaTexto(String mensaje) {
        System.out.print(mensaje);
        scanner.nextLine(); // Limpiar buffer
        return scanner.nextLine();
    }

    // Métodos específicos para crear entidades
    private static Tarea crearTarea() {
        int id = obtenerEntradaEntero("Ingrese el ID de la tarea: ");
        String nombre = obtenerEntradaTexto("Ingrese el nombre de la tarea: ");
        String fecha = obtenerEntradaTexto("Ingrese la fecha de entrega (DD-MM-AAAA): ");
        String hora = obtenerEntradaTexto("Ingrese la hora de entrega (HH:MM): ");
        String modalidad = obtenerEntradaTexto("Ingrese el tipo de trabajo: ");
        float nota = Float.parseFloat(obtenerEntradaTexto("Ingrese la calificación obtenida: "));
        return new Tarea(id, nombre, fecha, hora, modalidad, modalidad, nota);
    }

    private static CitaMedica crearCitaMedica() {
        int id = obtenerEntradaEntero("Ingrese el ID de la cita: ");
        String nombre = obtenerEntradaTexto("Ingrese el nombre de la cita: ");
        String fecha = obtenerEntradaTexto("Ingrese la fecha de la cita (DD-MM-AAAA): ");
        String hora = obtenerEntradaTexto("Ingrese la hora de la cita (HH:MM): ");
        String nombreMedico = obtenerEntradaTexto("Ingrese el nombre del médico: ");
        String motivo = obtenerEntradaTexto("Ingrese el motivo de la cita: ");
        String especialidad = obtenerEntradaTexto("Ingrese la especialidad del médico: ");
        Medico medico = new Medico(id, nombreMedico, "Apellido", "M", especialidad);
        Direccion direccion = new Direccion(id, 123, 456, "Barrio", 98765, "Estado", "Pais");
        return new CitaMedica(id, nombre, fecha, hora, medico, motivo, especialidad, direccion);
    }

    private static Evento crearEvento() {
        int id = obtenerEntradaEntero("Ingrese el ID del evento: ");
        String nombre = obtenerEntradaTexto("Ingrese el nombre del evento: ");
        String fecha = obtenerEntradaTexto("Ingrese la fecha del evento (DD-MM-AAAA): ");
        String hora = obtenerEntradaTexto("Ingrese la hora del evento (HH:MM): ");
        return new Evento(id, nombre, fecha, hora);
    }

    private static Medicamento crearMedicamento() {
        int id = obtenerEntradaEntero("Ingrese el ID del medicamento: ");
        String nombre = obtenerEntradaTexto("Ingrese el nombre del medicamento: ");
        float dosis = Float.parseFloat(obtenerEntradaTexto("Ingrese la dosis: "));
        float cantidadRestante = Float.parseFloat(obtenerEntradaTexto("Ingrese la cantidad restante: "));
        float periodo = Float.parseFloat(obtenerEntradaTexto("Ingrese el período (días): "));
        int lote = obtenerEntradaEntero("Ingrese el lote: ");
        Evento fechaCaducidad = new Evento(id, "Fecha Caducidad", "01-01-2025", "00:00");
        return new Medicamento(id, nombre, dosis, cantidadRestante, periodo, fechaCaducidad, lote);
    }

    // Interfaz funcional para la creación de elementos
    interface CrearElemento<T> {
        T crear();
    }
}

