package view;

import controller.InventarioController;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class ConsoleView {

    private InventarioController controller;
    private Scanner scanner;

    /**
     * Constructor que inicializa el controlador y el escáner para la entrada
     * del usuario.
     */
    public ConsoleView() {
        this.controller = new InventarioController(5); // Capacidad inicial de la pila
        this.scanner = new Scanner(System.in);
    }

    /**
     * Muestra el menú y gestiona las opciones seleccionadas por el usuario.
     */
    public void showMenu() {
        int option = 0;
        do {
            System.out.println("\n=== 📦 Sistema de Gestión de Inventario ===");
            System.out.println("1. Agregar producto");
            System.out.println("2. Eliminar último producto");
            System.out.println("3. Consultar último producto agregado");
            System.out.println("4. Mostrar inventario");
            System.out.println("5. Copiar inventario");
            System.out.println("6. Buscar producto por nombre");
            System.out.println("7. Ordenar inventario por precio");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) { // Verifica si la entrada es un número válido
                option = scanner.nextInt();
                scanner.nextLine(); // Limpia el buffer
            } else {
                System.out.println("⚠ Entrada no válida. Por favor, ingrese un número.");
                scanner.nextLine(); // Limpia la entrada incorrecta
                continue;
            }

            switch (option) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    controller.eliminarProducto();
                    break;
                case 3:
                    controller.consultarUltimoProducto();
                    break;
                case 4:
                    controller.mostrarInventario();
                    break;
                case 5:
                    controller.copiarInventario();
                    break;
                case 6:
                    buscarProducto();
                    break;
                case 7:
                    controller.ordenarPorPrecio();
                    break;
                case 8:
                    System.out.println("🚀 Saliendo del sistema...");
                    break;
                default:
                    System.out.println("⚠ Opción no válida. Intente de nuevo.");
            }
        } while (option != 8);
    }

    /**
     * Solicita al usuario los datos del nuevo producto y lo agrega al
     * inventario.
     */
    private void agregarProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();

        double precio = obtenerPrecio();
        int cantidad = obtenerCantidad();

        controller.agregarProducto(nombre, precio, cantidad);
    }

    /**
     * Permite al usuario buscar un producto por su nombre.
     */
    private void buscarProducto() {
        System.out.print("Ingrese el nombre del producto a buscar: ");
        String nombre = scanner.nextLine();
        controller.buscarProducto(nombre);
    }

    /**
     * Solicita al usuario el precio del producto, validando la entrada.
     *
     * @return Precio válido.
     */
    private double obtenerPrecio() {
        double precio;
        while (true) {
            System.out.print("Ingrese el precio del producto: ");
            if (scanner.hasNextDouble()) {
                precio = scanner.nextDouble();
                scanner.nextLine(); // Limpia el buffer
                if (precio >= 0) {
                    return precio;
                }
            } else {
                scanner.nextLine(); // Limpia la entrada inválida
            }
            System.out.println("⚠ Entrada no válida. Ingrese un número positivo.");
        }
    }

    /**
     * Solicita al usuario la cantidad de productos, validando la entrada.
     *
     * @return Cantidad válida.
     */
    private int obtenerCantidad() {
        int cantidad;
        while (true) {
            System.out.print("Ingrese la cantidad en stock: ");
            if (scanner.hasNextInt()) {
                cantidad = scanner.nextInt();
                scanner.nextLine(); // Limpia el buffer
                if (cantidad >= 0) {
                    return cantidad;
                }
            } else {
                scanner.nextLine(); // Limpia la entrada inválida
            }
            System.out.println("⚠ Entrada no válida. Ingrese un número entero positivo.");
        }
    }
}
