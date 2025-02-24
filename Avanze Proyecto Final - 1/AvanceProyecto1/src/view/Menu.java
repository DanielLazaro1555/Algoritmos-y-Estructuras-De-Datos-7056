package view;

import clases.ValidadorTareas;
import controller.GestorTareas;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class Menu {

    public static void mostrarMenu(GestorTareas gestor) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            imprimirMenu(gestor);

            // Validar entrada del usuario
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1 ->
                        agregarTarea(gestor, sc);
                    case 2 ->
                        moverTareaAEnProgreso(gestor, sc);
                    case 3 ->
                        completarTarea(gestor, sc);
                    case 4 ->
                        buscarTarea(gestor, sc);
                    case 5 ->
                        gestor.mostrarHistorialTareas();
                    case 6 -> {
                        gestor.mostrarTareasPorEstado();
                        pausar();
                    }
                    case 7 -> {
                        gestor.exportarTareasAPdf(); // 🔹 Exporta a PDF
                        pausar();
                    }
                    case 8 -> {
                        System.out.println("👋 Saliendo del sistema...");
                        return;
                    }
                    default ->
                        System.out.println("⚠️ Opción no válida. Intente nuevamente.");
                }

            } else {
                System.out.println("\n⚠️ Error: Debe ingresar un número válido.");
                sc.next(); // Limpiar entrada incorrecta
                pausar();
            }
        } while (true); // 🔹 Se quita la condición anterior y se usa return para salir
        // 🔹 Se cambió la condición para salir correctamente
    }

    /**
     * Método para imprimir el menú de opciones y las tareas pendientes.
     */
    private static void imprimirMenu(GestorTareas gestor) {
        System.out.println("\n=== Sistema de Gestión de Tareas Pendientes ===");
        System.out.println("1. Agregar Tarea");
        System.out.println("2. Mover Tarea a 'En Progreso'");
        System.out.println("3. Completar Tarea");
        System.out.println("4. Buscar Tarea");
        System.out.println("5. Ver Historial de Tareas Completadas");
        System.out.println("6. Ver Tareas por Estado");
        System.out.println("7. Exportar Tareas a PDF"); // 🔹 Nueva opción
        System.out.println("8. Salir");

        System.out.println("\n📌 Tareas Pendientes actuales:");
        gestor.mostrarTareasPendientes();

        System.out.print("\nSeleccione una opción: ");
    }

    private static void agregarTarea(GestorTareas gestor, Scanner sc) {
        System.out.print("\nDescripción de la tarea: ");
        String descripcion = sc.nextLine();

        String prioridad;
        do {
            System.out.print("Prioridad (Alta, Media, Baja): ");
            prioridad = sc.nextLine();

            if (!ValidadorTareas.validarPrioridad(prioridad)) {
                System.out.println("⚠️  Prioridad no válida. Debe ser Alta, Media o Baja.");
            }
        } while (!ValidadorTareas.validarPrioridad(prioridad)); // 🔹 Repite hasta que sea válida

        gestor.agregarTarea(descripcion, prioridad);
    }

    private static void completarTarea(GestorTareas gestor, Scanner sc) {
        System.out.print("\nIngrese la descripción de la tarea a completar: ");
        String descripcion = sc.nextLine();
        gestor.completarTarea(descripcion);
    }

    private static void buscarTarea(GestorTareas gestor, Scanner sc) {
        System.out.print("\nIngrese la descripción de la tarea a buscar: ");
        String descripcion = sc.nextLine();
        gestor.buscarTarea(descripcion);
    }

    private static void moverTareaAEnProgreso(GestorTareas gestor, Scanner sc) {
        System.out.print("Ingrese la descripción de la tarea a mover a 'En Progreso': ");
        String descripcion = sc.nextLine();
        gestor.moverTareaAEnProgreso(descripcion);
    }

    /**
     * Método para pausar la ejecución y permitir al usuario ver los mensajes.
     */
    private static void pausar() {
        System.out.println("\nPresiona Enter para continuar...");
        new Scanner(System.in).nextLine();
    }
}
