package principal;

import clases.GestionProductos;
import java.util.Scanner;

/**
 * Clase Main
 * Punto de entrada del programa. Permite al usuario ingresar productos de cada turno
 * y genera un listado único, ordenado alfabéticamente.
 * 
 * @author daniel
 */
public class Main {

    public static void main(String[] args) {
        // Crear una instancia de Scanner para leer la entrada del usuario.
        Scanner scanner = new Scanner(System.in);

        // Leer productos del turno de la mañana.
        System.out.println("== Turno de la Mañana ==");
        String[] productosMañana = leerProductos(scanner);

        // Leer productos del turno de la tarde.
        System.out.println("== Turno de la Tarde ==");
        String[] productosTarde = leerProductos(scanner);

        // Crear una instancia de GestionProductos para procesar los datos.
        GestionProductos gestion = new GestionProductos();

        // Combinar y ordenar los productos de ambos turnos.
        String[] productosUnicos = gestion.combinarYOrdenar(productosMañana, productosTarde);

        // Mostrar el listado único de productos.
        System.out.println("\n== Listado único de productos vendidos durante el día ==");
        imprimirProductos(productosUnicos);
    }

    /**
     * Método para leer una lista de productos desde la entrada del usuario.
     * 
     * @param scanner Objeto Scanner para leer la entrada.
     * @return Un arreglo con los nombres de los productos ingresados.
     */
    public static String[] leerProductos(Scanner scanner) {
        System.out.print("Ingrese la cantidad de productos: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea restante.

        String[] productos = new String[cantidad];
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Producto " + (i + 1) + ": ");
            productos[i] = scanner.nextLine().trim();
        }
        return productos;
    }

    /**
     * Método para imprimir una lista de productos.
     * 
     * @param productos Arreglo de productos a imprimir.
     */
    public static void imprimirProductos(String[] productos) {
        for (String producto : productos) {
            System.out.println(producto);
        }
    }
}
