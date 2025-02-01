package clases;

import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class GestionEmpleados {
    private static Scanner dato = new Scanner(System.in);
    private Empleado[] empleados = new Empleado[100];
    private int numEmpleados = 0;
    
    public void iniciarMenu() {
        while (true) {
            mostrarMenu();
            int opcion = obtenerOpcionUsuario();
            switch (opcion) {
                case 1:
                    agregarEmpleado();
                    break;
                case 2:
                    mostrarEmpleados();
                    break;
                case 3:
                    eliminarEmpleado();
                    break;
                case 4:
                    buscarEmpleado();
                    break;
                case 5:
                    System.out.println("SALIENDO DEL SISTEMA");
                    dato.close();
                    return;
                default:
                    System.out.println("OPCIÓN NO VÁLIDA");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("1. Agregar Empleado");
        System.out.println("2. Mostrar Empleados");
        System.out.println("3. Eliminar Empleado");
        System.out.println("4. Buscar Empleado");
        System.out.println("5. SALIR");
        System.out.print("Seleccionar una opción: ");
    }

    private int obtenerOpcionUsuario() {
        while (!dato.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            dato.next(); // Limpiar la entrada inválida
        }
        return dato.nextInt();
    }

    private void agregarEmpleado() {
        dato.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese nombre del empleado: ");
        String nombre = dato.nextLine();

        System.out.print("Ingrese ID del empleado: ");
        while (!dato.hasNextInt()) {
            System.out.println("Por favor, ingrese un ID válido.");
            dato.next();
        }
        int id = dato.nextInt();

        System.out.print("Ingrese salario del empleado: ");
        while (!dato.hasNextDouble()) {
            System.out.println("Por favor, ingrese un salario válido.");
            dato.next();
        }
        double salario = dato.nextDouble();

        empleados[numEmpleados++] = new Empleado(nombre, id, salario);
        System.out.println("Empleado agregado exitosamente.");
    }

    private void mostrarEmpleados() {
        if (numEmpleados == 0) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        for (int i = 0; i < numEmpleados; i++) {
            System.out.println(empleados[i]);
        }
    }
    
    private void eliminarEmpleado() {
        System.out.print("Ingrese ID del empleado a eliminar: ");
        while (!dato.hasNextInt()) {
            System.out.println("Por favor, ingrese un ID válido.");
            dato.next();
        }
        int idEliminar = dato.nextInt();

        for (int i = 0; i < numEmpleados; i++) {
            if (empleados[i].getId() == idEliminar) {
                for (int j = i; j < numEmpleados - 1; j++) {
                    empleados[j] = empleados[j + 1];
                }
                empleados[--numEmpleados] = null; // Limpiar el último registro
                System.out.println("Empleado eliminado exitosamente.");
                return;
            }
        }
        System.out.println("Empleado no encontrado.");
    }

    private void buscarEmpleado() {
        System.out.print("Ingrese ID del empleado a buscar: "); // CORREGIDO EL MENSAJE
        while (!dato.hasNextInt()) {
            System.out.println("Por favor, ingrese un ID válido.");
            dato.next();
        }
        int idBuscar = dato.nextInt();

        for (int i = 0; i < numEmpleados; i++) {
            if (empleados[i].getId() == idBuscar) {
                System.out.println("Empleado encontrado: " + empleados[i]);
                return;
            }
        }
        System.out.println("Empleado no encontrado.");
    }
}
