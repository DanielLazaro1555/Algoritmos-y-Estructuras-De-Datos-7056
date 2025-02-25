package view;

import controller.GestorProductos;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
/**
 * Clase que representa la interfaz en consola para interactuar con el usuario.
 */
public class Menu {

    private GestorProductos gestor;
    private Scanner scanner;

    /**
     * Constructor del menú. Inicializa el gestor de productos y el scanner.
     */
    public Menu() {
        this.gestor = new GestorProductos();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Método para mostrar el menú interactivo.
     */
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n📌 MENÚ DE GESTIÓN DE PRODUCTOS");
            System.out.println("1⃣ Agregar producto");
            System.out.println("2⃣ Buscar producto por código");
            System.out.println("3⃣ Listar productos en orden");
            System.out.println("4⃣ Eliminar producto por código");
            System.out.println("5⃣ Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) { // Validar entrada numérica
                System.out.println("❌ Entrada inválida. Ingrese un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    buscarProducto();
                    break;
                case 3:
                    gestor.listarProductos();
                    break;
                case 4:
                    eliminarProducto();
                    break;
                case 5:
                    System.out.println("👋 Saliendo del sistema...");
                    break;
                default:
                    System.out.println("❌ Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    /**
     * Método para solicitar datos y agregar un nuevo producto.
     */
    private void agregarProducto() {
        System.out.print("Ingrese el código del producto: ");
        int codigo = validarEntero();
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la cantidad en inventario: ");
        int cantidad = validarEntero();

        gestor.agregarProducto(codigo, nombre, cantidad);
    }

    /**
     * Método para buscar un producto por código.
     */
    private void buscarProducto() {
        System.out.print("Ingrese el código del producto a buscar: ");
        int codigo = validarEntero();
        gestor.buscarProducto(codigo);
    }

    /**
     * Método para eliminar un producto por código.
     */
    private void eliminarProducto() {
        System.out.print("Ingrese el código del producto a eliminar: ");
        int codigo = validarEntero();
        gestor.eliminarProducto(codigo);
    }

    /**
     * Método auxiliar para validar la entrada de números enteros.
     *
     * @return Un número entero válido ingresado por el usuario.
     */
    private int validarEntero() {
        while (!scanner.hasNextInt()) {
            System.out.println("❌ Entrada inválida. Ingrese un número válido.");
            scanner.next();
        }
        int numero = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        return numero;
    }
}
