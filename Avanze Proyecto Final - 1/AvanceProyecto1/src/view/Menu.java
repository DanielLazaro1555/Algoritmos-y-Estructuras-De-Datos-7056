package view;

import controller.GestorTareas;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class Menu {

    public static void mostrarMenu(GestorTareas gestor) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=== Sistema de Gestión de Tareas Pendientes ===");
            System.out.println("1. Agregar Tarea");
            System.out.println("2. Listar Tareas");
            System.out.println("3. Completar Tarea");
            System.out.println("4. Buscar Tarea");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 ->
                    agregarTarea(gestor, sc);
                case 2 ->
                    gestor.listarTareas();
                case 3 ->
                    completarTarea(gestor, sc);
                case 4 ->
                    buscarTarea(gestor, sc);
                case 5 ->
                    System.out.println("Saliendo del sistema...");
                default ->
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    private static void agregarTarea(GestorTareas gestor, Scanner sc) {
        System.out.print("Descripción de la tarea: ");
        String descripcion = sc.nextLine();
        System.out.print("Prioridad (Alta, Media, Baja): ");
        String prioridad = sc.nextLine();
        gestor.agregarTarea(descripcion, prioridad);
    }

    private static void completarTarea(GestorTareas gestor, Scanner sc) {
        System.out.print("Ingrese la descripción de la tarea a completar: ");
        String descripcion = sc.nextLine();
        gestor.completarTarea(descripcion);
    }

    private static void buscarTarea(GestorTareas gestor, Scanner sc) {
        System.out.print("Ingrese la descripción de la tarea a buscar: ");
        String descripcion = sc.nextLine();
        gestor.buscarTarea(descripcion);
    }
}
