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
4. Incluir operaciones básicas como agregar, eliminar, buscar y listar productos.
*/

public class Main {

    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ DE INVENTARIO ===");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Eliminar Producto");
            System.out.println("3. Buscar Producto por ID");
            System.out.println("4. Listar Productos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Ingrese una opción válida.");
                scanner.next(); // Limpiar entrada inválida
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpieza del buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese Precio: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Ingrese Cantidad: ");
                    int cantidad = scanner.nextInt();
                    Producto producto = new Producto(id, nombre, precio, cantidad);
                    inventario.agregarProducto(producto);
                    break;

                case 2:
                    System.out.print("Ingrese ID del producto a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    inventario.eliminarProducto(idEliminar);
                    break;

                case 3:
                    System.out.print("Ingrese ID del producto a buscar: ");
                    int idBuscar = scanner.nextInt();
                    Producto encontrado = inventario.buscarProducto(idBuscar);
                    System.out.println(encontrado != null ? encontrado : "Producto no encontrado.");
                    break;

                case 4:
                    inventario.listarProductos();
                    break;

                case 5:
                    System.out.println("Saliendo del sistema... ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 5);

        scanner.close();
    }
}
