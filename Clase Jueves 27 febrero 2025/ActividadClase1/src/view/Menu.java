package view;

import controller.GestorArboles;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
/**
 * Clase que gestiona el menú interactivo para el usuario. Permite insertar,
 * buscar, eliminar y mostrar productos en ABB y AVL.
 */
public class Menu {

    private GestorArboles gestor;
    private Scanner scanner;

    /**
     * Constructor que inicializa el gestor de árboles y el scanner.
     */
    public Menu() {
        this.gestor = new GestorArboles();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Método para mostrar el menú interactivo y manejar la entrada del usuario.
     */
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n📌 Menú de Gestión de Inventario");
            System.out.println("1 Insertar producto");
            System.out.println("2 Buscar producto");
            System.out.println("3 Eliminar producto");
            System.out.println("4 Mostrar productos en orden ascendente");
            System.out.println("0 Salir");
            System.out.print("👉 Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        insertarProducto();
                        break;
                    case 2:
                        buscarProducto();
                        break;
                    case 3:
                        eliminarProducto();
                        break;
                    case 4:
                        gestor.mostrarProductos();
                        break;
                    case 0:
                        System.out.println("🚀 Saliendo del programa...");
                        break;
                    default:
                        System.out.println("❌ Opción no válida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Error: Debe ingresar un número válido.");
                scanner.nextLine(); // Limpiar buffer para evitar bucle infinito
                opcion = -1; // Forzar repetir el menú
            }
        } while (opcion != 0);
    }

    /**
     * Método para insertar un producto solicitando los datos al usuario.
     */
    /**
     * Método para insertar un producto solicitando los datos al usuario.
     */
    private void insertarProducto() {
        int codigo = leerEntero("📌 Ingrese el código del producto: ");

        System.out.print("📌 Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();

        int stock = leerEntero("📌 Ingrese el stock disponible: ");

        gestor.insertarProducto(codigo, nombre, stock);
    }

    /**
     * Método para buscar un producto por su código.
     */
    private void buscarProducto() {
        int codigo = leerEntero("Ingrese el código del producto a buscar: ");
        gestor.buscarProducto(codigo);
    }

    /**
     * Método para eliminar un producto por su código.
     */
    private void eliminarProducto() {
        int codigo = leerEntero("Ingrese el código del producto a eliminar: ");
        gestor.eliminarProducto(codigo);
    }

    /**
     * Método auxiliar para leer un número entero con validación.
     *
     * @param mensaje Mensaje a mostrar antes de la entrada.
     * @return Un número entero válido ingresado por el usuario.
     */
    private int leerEntero(String mensaje) {
        int numero;
        while (true) {
            try {
                System.out.print(mensaje);
                numero = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Error: Debe ingresar un número válido.");
                scanner.nextLine(); // Limpiar buffer para evitar bucle infinito
            }
        }
    }
}
