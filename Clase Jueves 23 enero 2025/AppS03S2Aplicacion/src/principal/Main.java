package principal;

import clases.Inventario;
import clases.Producto;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
// Descripción del ejercicio:
/*
El negocio de productos electrónicos ha implementado un sistema para gestionar su inventario usando
arreglos unidimensionales. Sin embargo, debido a sus limitaciones, se requiere reestructurar el sistema
utilizando Tipos Abstractos de Datos (TAD) más eficientes y flexibles.

La tarea consiste en:
1. Implementar una clase llamada 'Inventario' para gestionar productos electrónicos de manera dinámica.
2. Utilizar TADs adecuados como ArrayList para almacenar los productos.
3. Representar cada producto con una clase 'Producto' utilizando programación orientada a objetos (POO).
4. Incluir operaciones básicas como agregar, eliminar, buscar, actualizar, ordenar y copiar productos.
5. Validar que el precio > 0 y la cantidad >= 0.
6. Duplicar la capacidad del inventario de manera dinámica si se supera el límite de 10 productos.
 */
public class Main {

    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ DE INVENTARIO ===");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Actualizar Producto");
            System.out.println("3. Eliminar Producto");
            System.out.println("4. Buscar Producto por Nombre");
            System.out.println("5. Listar Productos");
            System.out.println("6. Ordenar Productos por Precio");
            System.out.println("7. Copiar Inventario");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ID (o -1 para cancelar): ");
                    int id = scanner.nextInt();
                    if (id == -1) {
                        break;
                    }
                    scanner.nextLine();

                    System.out.print("Ingrese Nombre (o escriba 'cancelar' para cancelar): ");
                    String nombre = scanner.nextLine();
                    if (nombre.equalsIgnoreCase("cancelar")) {
                        break;
                    }

                    double precio;
                    while (true) {
                        System.out.print("Ingrese Precio (>0) o -1 para cancelar: ");
                        precio = scanner.nextDouble();
                        if (precio == -1) {
                            break;
                        }
                        if (precio > 0) {
                            break;
                        }
                        System.out.println("Error: El precio debe ser mayor que 0.");
                    }
                    if (precio == -1) {
                        break;
                    }

                    int cantidad;
                    while (true) {
                        System.out.print("Ingrese Cantidad (>=0) o -1 para cancelar: ");
                        cantidad = scanner.nextInt();
                        if (cantidad == -1) {
                            break;
                        }
                        if (cantidad >= 0) {
                            break;
                        }
                        System.out.println("Error: La cantidad no puede ser negativa.");
                    }
                    if (cantidad == -1) {
                        break;
                    }

                    inventario.agregarProducto(new Producto(id, nombre, precio, cantidad));
                    break;

                case 2:
                    System.out.print("Ingrese ID del producto a actualizar (o -1 para cancelar): ");
                    int idActualizar = scanner.nextInt();
                    if (idActualizar == -1) {
                        break;
                    }
                    scanner.nextLine();

                    System.out.print("Nuevo Nombre (o escriba 'cancelar' para cancelar): ");
                    String nuevoNombre = scanner.nextLine();
                    if (nuevoNombre.equalsIgnoreCase("cancelar")) {
                        break;
                    }

                    System.out.print("Nuevo Precio (o -1 para cancelar): ");
                    double nuevoPrecio = scanner.nextDouble();
                    if (nuevoPrecio == -1) {
                        break;
                    }

                    System.out.print("Nueva Cantidad (o -1 para cancelar): ");
                    int nuevaCantidad = scanner.nextInt();
                    if (nuevaCantidad == -1) {
                        break;
                    }

                    inventario.actualizarProducto(idActualizar, nuevoNombre, nuevoPrecio, nuevaCantidad);
                    break;

                case 3:
                    System.out.print("Ingrese ID del producto a eliminar (o -1 para cancelar): ");
                    int idEliminar = scanner.nextInt();
                    if (idEliminar == -1) {
                        break;
                    }
                    inventario.eliminarProducto(idEliminar);
                    break;

                case 4:
                    System.out.print("Ingrese Nombre del producto a buscar (o escriba 'cancelar' para cancelar): ");
                    String nombreBuscar = scanner.nextLine();
                    if (nombreBuscar.equalsIgnoreCase("cancelar")) {
                        break;
                    }
                    Producto encontrado = inventario.buscarProductoPorNombre(nombreBuscar);
                    System.out.println(encontrado != null ? encontrado : "Producto no encontrado.");
                    break;

                case 5:
                    inventario.listarProductos();
                    break;

                case 6:
                    inventario.ordenarPorPrecio();
                    break;

                case 7:
                    Inventario copia = inventario.copiarInventario();
                    copia.listarProductos();
                    break;

                case 8:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 8);

        scanner.close();
    }
}
