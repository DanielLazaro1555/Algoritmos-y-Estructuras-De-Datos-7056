/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;

import clases.FusionProductos;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
/**
 * Clase principal Main
 * Permite al usuario ingresar productos y muestra el listado único y ordenado.
 * 2. Un supermercado registra los productos vendidos durante el turno de la mañana y el turno de la tarde. Se
requiere generar un listado único de productos vendidos durante todo el día, ordenado alfabéticamente.
Diseña un programa que permita al usuario:
• Ingresar los nombres de los productos vendidos en cada turno.
• Combinar ambas listas en un solo arreglo.
• Ordenar el arreglo combinado y mostrar el listado final de productos en pantalla.
• Implementar una clase auxiliar que realice la fusión y ordenamiento de los arreglos.
Nota: El programa debe ser modular, empleando buenas prácticas de programación para facilitar su
reutilización.
 */
public class Main {

    public static void main(String[] args) {
        Scanner dato = new Scanner(System.in);
        FusionProductos fusionador = new FusionProductos();

        // Entrada de datos para el turno de la mañana
        System.out.print("Ingrese la cantidad de productos vendidos en el turno de la mañana: ");
        int cantidadManana = dato.nextInt();
        dato.nextLine(); // Consumir el salto de línea

        String[] turnoManana = new String[cantidadManana];
        System.out.println("Ingrese los nombres de los productos vendidos en el turno de la mañana:");
        for (int i = 0; i < cantidadManana; i++) {
            System.out.print("Producto " + (i + 1) + ": ");
            turnoManana[i] = dato.nextLine();
        }

        // Entrada de datos para el turno de la tarde
        System.out.print("\nIngrese la cantidad de productos vendidos en el turno de la tarde: ");
        int cantidadTarde = dato.nextInt();
        dato.nextLine(); // Consumir el salto de línea

        String[] turnoTarde = new String[cantidadTarde];
        System.out.println("Ingrese los nombres de los productos vendidos en el turno de la tarde:");
        for (int i = 0; i < cantidadTarde; i++) {
            System.out.print("Producto " + (i + 1) + ": ");
            turnoTarde[i] = dato.nextLine();
        }

        // Combinar y ordenar los productos
        String[] productosUnicos = fusionador.combinarYOrdenar(turnoManana, turnoTarde);

        // Mostrar el listado único y ordenado
        System.out.println("\n=== Listado único de productos vendidos durante todo el día ===");
        for (String producto : productosUnicos) {
            System.out.println(producto);
        }
    }
}
