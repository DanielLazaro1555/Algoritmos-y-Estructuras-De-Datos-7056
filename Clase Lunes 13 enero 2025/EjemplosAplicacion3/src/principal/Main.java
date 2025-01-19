package principal;

import clases.*;

import java.util.Scanner;

/**
 *
 * @author daniel
 */
/**
 * Clase principal para ejecutar el programa.
 */
public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("**************** Gestión de Inventario ****************");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Actualizar Producto");
            System.out.println("3. Eliminar Producto");
            System.out.println("4. Mostrar Inventario");
            System.out.println("5. Copiar Inventario");
            System.out.println("6. Buscar Producto");
            System.out.println("7. Ordenar por Precio");
            System.out.println("8. Salir");
            System.out.print("Ingrese una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1: // Agregar Producto
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el precio del producto: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Ingrese la cantidad en stock: ");
                    int cantidadStock = scanner.nextInt();
                    if (precio > 0 && cantidadStock >= 0) {
                        inventario.agregarProducto(new Producto(nombre, precio, cantidadStock));
                        System.out.println("Producto agregado.");
                    } else {
                        System.out.println("Datos inválidos. Intente de nuevo.");
                    }
                    break;

                case 2: // Actualizar Producto
                    System.out.print("Ingrese el índice del producto a actualizar: ");
                    int indiceActualizar = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("Ingrese el nuevo nombre del producto: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Ingrese el nuevo precio: ");
                    double nuevoPrecio = scanner.nextDouble();
                    System.out.print("Ingrese la nueva cantidad en stock: ");
                    int nuevaCantidad = scanner.nextInt();
                    if (nuevoPrecio > 0 && nuevaCantidad >= 0) {
                        inventario.actualizarProducto(indiceActualizar,
                                new Producto(nuevoNombre, nuevoPrecio, nuevaCantidad));
                        System.out.println("Producto actualizado.");
                    } else {
                        System.out.println("Datos inválidos.");
                    }
                    break;

                case 3: // Eliminar Producto
                    System.out.print("Ingrese el índice del producto a eliminar: ");
                    int indiceEliminar = scanner.nextInt();
                    if (inventario.eliminarProducto(indiceEliminar)) {
                        System.out.println("Producto eliminado.");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 4: // Mostrar Inventario
                    inventario.mostrarInventario();
                    break;

                case 5: // Copiar Inventario
                    inventario.copiarInventario();
                    break;

                case 6: // Buscar Producto
                    System.out.print("Ingrese el nombre del producto a buscar: ");
                    String buscarNombre = scanner.nextLine();
                    Producto encontrado = inventario.buscarProducto(buscarNombre);
                    if (encontrado != null) {
                        System.out.println("Producto encontrado: " + encontrado);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 7: // Ordenar por Precio
                    inventario.ordenarPorPrecio();
                    System.out.println("Inventario ordenado por precio.");
                    break;

                case 8: // Salir
                    System.out.println("Saliendo...");
                    return;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
