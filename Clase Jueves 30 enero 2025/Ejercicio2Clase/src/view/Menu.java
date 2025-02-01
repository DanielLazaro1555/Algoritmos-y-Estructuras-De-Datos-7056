package view;

import controller.GestorInventario;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class Menu {

    public static void mostrarMenu(GestorInventario gestor) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=== Gestión de Inventario ===");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Actualizar Producto");
            System.out.println("3. Eliminar Producto");
            System.out.println("4. Mostrar Inventario");
            System.out.println("5. Buscar Producto");
            System.out.println("6. Ordenar Inventario por Precio");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 ->
                    agregarProducto(gestor, sc);
                case 2 ->
                    actualizarProducto(gestor, sc);
                case 3 ->
                    eliminarProducto(gestor, sc);
                case 4 ->
                    gestor.mostrarInventario();
                case 5 ->
                    buscarProducto(gestor, sc);
                case 6 ->
                    gestor.ordenarInventarioPorPrecio();
                case 7 ->
                    System.out.println("Saliendo del sistema...");
                default ->
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 7);
    }

    private static void agregarProducto(GestorInventario gestor, Scanner sc) {
        System.out.print("Nombre del producto: ");
        String nombre = sc.nextLine();
        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();
        gestor.agregarProducto(nombre, precio, cantidad);
    }

    private static void actualizarProducto(GestorInventario gestor, Scanner sc) {
        System.out.print("Nombre del producto a actualizar: ");
        String nombre = sc.nextLine();
        System.out.print("Nuevo precio: ");
        double nuevoPrecio = sc.nextDouble();
        System.out.print("Nueva cantidad: ");
        int nuevaCantidad = sc.nextInt();
        gestor.actualizarProducto(nombre, nuevoPrecio, nuevaCantidad);
    }

    private static void eliminarProducto(GestorInventario gestor, Scanner sc) {
        System.out.print("Nombre del producto a eliminar: ");
        String nombre = sc.nextLine();
        gestor.eliminarProducto(nombre);
    }

    private static void buscarProducto(GestorInventario gestor, Scanner sc) {
        System.out.print("Nombre del producto a buscar: ");
        String nombre = sc.nextLine();
        gestor.buscarProducto(nombre);
    }
}
