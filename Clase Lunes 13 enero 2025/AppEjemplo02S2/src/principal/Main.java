package principal;

import clases.GestionProductos;
import java.util.Scanner;

/**
 * Clase Main
 * Esta clase contiene el método principal del programa, donde se realiza la interacción
 * con el usuario para ingresar los datos y se utiliza la clase GestionProductos para procesarlos.
 * 
 * @author daniel
 */
public class Main {

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer datos ingresados por el usuario.
        Scanner dato = new Scanner(System.in);
        
        // Solicitar al usuario la cantidad de productos vendidos en el turno de la mañana.
        System.out.println("Ingrese cantidad de productos TM: ");
        int cantidadM = dato.nextInt();
        dato.nextLine(); // Consumir el salto de línea restante.

        // Crear un arreglo para almacenar los productos del turno de la mañana.
        String[] productosM = new String[cantidadM];
        System.out.println("Ingrese productos vendidos turno M: ");
        for (int i = 0; i < cantidadM; i++) {
            System.out.println("Producto " + (i + 1) + ": ");
            productosM[i] = dato.nextLine(); // Leer el nombre de cada producto.
        }
        
        // Solicitar al usuario la cantidad de productos vendidos en el turno de la tarde.
        System.out.println("Ingrese cantidad de productos TT: ");
        int cantidadT = dato.nextInt();
        dato.nextLine(); // Consumir el salto de línea restante.

        // Crear un arreglo para almacenar los productos del turno de la tarde.
        String[] productosT = new String[cantidadT];
        System.out.println("Ingrese productos vendidos turno T: ");
        for (int i = 0; i < cantidadT; i++) {
            System.out.println("Producto " + (i + 1) + ": ");
            productosT[i] = dato.nextLine(); // Leer el nombre de cada producto.
        }
        
        // Crear una instancia de la clase GestionProductos para procesar los datos.
        GestionProductos gestion = new GestionProductos();
        
        // Llamar al método combinarYOrdenar para obtener un listado único de productos.
        String[] productosUnicos = gestion.combinarYOrdenar(productosM, productosT);
        
        // Mostrar el listado único de productos al usuario.
        System.out.println("Listado único de productos: ");
        for (String producto : productosUnicos) {
            System.err.println(producto); // Imprimir cada producto en una nueva línea.
        }
    }
}
