package principal;

import clases.Producto;
import clases.ListaEnlazada;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class Main {

    public static void main(String[] args) {
        ListaEnlazada inventario = new ListaEnlazada();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== Menú de Inventario ===");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Eliminar Producto");
            System.out.println("3. Mostrar Inventario");
            System.out.println("4. Buscar Producto");
            System.out.println("5. Ordenar Inventario por Precio");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Nombre del producto: ");
                        String nombre = sc.nextLine();
                        System.out.print("Precio: ");
                        double precio = sc.nextDouble();
                        System.out.print("Cantidad: ");
                        int cantidad = sc.nextInt();
                        inventario.agregarProducto(new Producto(nombre, precio, cantidad));
                        System.out.println("Producto agregado con éxito.");
                        break;

                    case 2:
                        System.out.print("Ingrese el nombre del producto a eliminar: ");
                        String nombreEliminar = sc.nextLine();
                        inventario.eliminarProducto(nombreEliminar);
                        System.out.println("Producto eliminado.");
                        break;

                    case 3:
                        inventario.mostrarInventario();
                        break;

                    case 4:
                        System.out.print("Ingrese el nombre del producto a buscar: ");
                        String nombreBuscar = sc.nextLine();
                        Producto producto = inventario.buscarProducto(nombreBuscar);
                        System.out.println("Producto encontrado: " + producto);
                        break;

                    case 5:
                        inventario.ordenarPorPrecio();
                        System.out.println("Inventario ordenado por precio.");
                        break;

                    case 6:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 6);

        sc.close();
    }
}
