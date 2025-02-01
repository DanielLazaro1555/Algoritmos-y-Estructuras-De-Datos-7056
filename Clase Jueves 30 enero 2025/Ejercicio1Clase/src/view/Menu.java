package view;

import controller.GestorEstudiantes;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class Menu {
    public static void mostrarMenu(GestorEstudiantes gestor) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("===== Gestión de Estudiantes =====");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Mostrar estudiantes");
            System.out.println("3. Ordenar por promedio");
            System.out.println("4. Buscar estudiante");
            System.out.println("5. Eliminar estudiante");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            while (!sc.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    agregarEstudiante(gestor, sc);
                    break;
                case 2:
                    gestor.mostrarEstudiantes();
                    break;
                case 3:
                    seleccionarMetodoOrdenamiento(gestor, sc);
                    break;
                case 4:
                    buscarEstudiante(gestor, sc);
                    break;
                case 5:
                    eliminarEstudiante(gestor, sc);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);

        sc.close();
    }

    private static void agregarEstudiante(GestorEstudiantes gestor, Scanner sc) {
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese la cantidad de calificaciones: ");
        int cantidadNotas = validarEnteroPositivo(sc);

        int[] calificaciones = new int[cantidadNotas];
        for (int i = 0; i < cantidadNotas; i++) {
            System.out.print("Ingrese la calificación " + (i + 1) + " (0-100): ");
            calificaciones[i] = validarCalificacion(sc);
        }

        gestor.agregarEstudiante(nombre, calificaciones);
        System.out.println("Estudiante agregado correctamente.");
    }

    private static void buscarEstudiante(GestorEstudiantes gestor, Scanner sc) {
        System.out.print("Ingrese el nombre del estudiante a buscar: ");
        String nombre = sc.nextLine();
        gestor.buscarEstudiante(nombre);
    }

    private static void eliminarEstudiante(GestorEstudiantes gestor, Scanner sc) {
        System.out.print("Ingrese el nombre del estudiante a eliminar: ");
        String nombre = sc.nextLine();
        gestor.eliminarEstudiante(nombre);
    }

    private static void seleccionarMetodoOrdenamiento(GestorEstudiantes gestor, Scanner sc) {
        System.out.println("Seleccione el método de ordenamiento:");
        System.out.println("1. Burbuja");
        System.out.println("2. Selección");
        System.out.println("3. Inserción");
        int metodo = validarEnteroPositivo(sc);

        gestor.ordenarPorPromedio(metodo);
    }

    private static int validarEnteroPositivo(Scanner sc) {
        while (true) {
            try {
                int valor = Integer.parseInt(sc.nextLine());
                if (valor > 0) return valor;
                System.out.println("Debe ingresar un número positivo.");
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
    }

    private static int validarCalificacion(Scanner sc) {
        while (true) {
            try {
                int nota = Integer.parseInt(sc.nextLine());
                if (nota >= 0 && nota <= 100) return nota;
                System.out.println("La calificación debe estar entre 0 y 100.");
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
    }
}