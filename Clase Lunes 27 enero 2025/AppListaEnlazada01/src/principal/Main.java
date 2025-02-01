package principal;

import clases.Empleado;
import clases.ListaEnlazada;
import java.util.Scanner;

/**
 * En una empresa, la lista de empleados está representada por una lista enlazada simple.
 * Cada nodo de la lista contiene los datos de un empleado (nombre y puesto).
 * 
 * Funcionalidades:
 * - El usuario puede insertar empleados en la lista:
 *     - Al inicio.
 *     - Al final.
 *     - En una posición específica.
 * - También puede eliminar empleados:
 *     - El primer empleado.
 *     - El último empleado.
 *     - Un empleado en una posición específica.
 * 
 * Condiciones:
 * - Un empleado no puede tener un puesto vacío.
 * - Un empleado no puede ser insertado si ya existe otro con el mismo nombre.
 * - La lista no puede tener más de 50 empleados.
 * - No se puede eliminar un empleado si la lista está vacía.
 * - El nombre de los empleados debe tener al menos 3 caracteres.
 */


/**
 *
 * @author daniel
 */
public class Main {

    public static void main(String[] args) {
        ListaEnlazada listaEmpleados = new ListaEnlazada(); // Instancia de la lista enlazada
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            // Menú de opciones
            System.out.println("1. Insertar empleado al inicio");
            System.out.println("2. Insertar empleado al final");
            System.out.println("3. Insertar empleado en una posicion");
            System.out.println("4. Eliminar primer empleado");
            System.out.println("5. Eliminar ultimo empleado");
            System.out.println("6. Eliminar empleado en una posicion");
            System.out.println("7. Mostrar lista de empleados");
            System.out.println("8. Salir");
            System.out.print("Ingrese opcion: ");

            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            try {
                switch (opcion) {
                    case 1:
                        Empleado empleadoInicio = crearEmpleado(sc);
                        listaEmpleados.insertarAlInicio(empleadoInicio); // CORRECCIÓN: Se debe insertar al inicio
                        System.out.println("Empleado insertado al inicio");
                        break;

                    case 2:
                        Empleado empleadoFinal = crearEmpleado(sc);
                        listaEmpleados.insertarAlFinal(empleadoFinal);
                        System.out.println("Empleado insertado al final");
                        break;

                    case 3:
                        Empleado empleadoPosicion = crearEmpleado(sc);
                        System.out.print("Ingrese posicion a insertar: ");
                        int posicionInsertar = sc.nextInt();
                        listaEmpleados.insertarEnPosicion(empleadoPosicion, posicionInsertar);
                        System.out.println("Empleado insertado en la posicion " + posicionInsertar);
                        break;

                    case 4:
                        listaEmpleados.eliminarPrimero();
                        System.out.println("Primer empleado eliminado");
                        break;

                    case 5:
                        listaEmpleados.eliminarUltimo();
                        System.out.println("Último empleado eliminado");
                        break;

                    case 6:
                        System.out.print("Ingrese posicion del empleado a eliminar: ");
                        int posicionEliminar = sc.nextInt();
                        listaEmpleados.eliminarEnPosicion(posicionEliminar);
                        System.out.println("Empleado eliminado");
                        break;

                    case 7:
                        System.out.println("=== Lista de empleados ===");
                        listaEmpleados.mostrarLista();
                        break;

                    case 8:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage()); // Manejo de excepciones genérico
            }

        } while (opcion != 8);

        sc.close(); // Cierre del scanner
    }

    /**
     * Método para crear un nuevo empleado a partir de la entrada del usuario.
     */
    private static Empleado crearEmpleado(Scanner sc) {
        System.out.print("Ingrese nombre del empleado: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese puesto del empleado: ");
        String puesto = sc.nextLine();

        return new Empleado(nombre, puesto);
    }
}
