/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio5;

import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class MainProductosVentas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner dato = new Scanner(System.in);

        System.out.print("Ingrese el número de productos: ");
        int n = dato.nextInt();
        dato.nextLine(); // Consumir salto de línea

        // Validar que el número de productos sea positivo
        while (n <= 0) {
            System.out.print("El número de productos debe ser mayor a 0. Inténtelo nuevamente: ");
            n = dato.nextInt();
            dato.nextLine(); // Consumir salto de línea
        }

        // Crear arreglos para productos y ventas
        String[] productos = new String[n];
        int[] ventas = new int[n];

        // Leer nombres de productos y sus ventas
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el nombre del producto " + (i + 1) + ": ");
            productos[i] = dato.nextLine();

            System.out.print("Ingrese la cantidad de ventas de " + productos[i] + ": ");
            ventas[i] = dato.nextInt();
            dato.nextLine(); // Consumir salto de línea

            while (ventas[i] < 0) { // Validar que las ventas no sean negativas
                System.out.print("La cantidad de ventas no puede ser negativa. Inténtelo nuevamente: ");
                ventas[i] = dato.nextInt();
                dato.nextLine(); // Consumir salto de línea
            }
        }

        // Crear una instancia de ProductosVentas y encontrar el producto más vendido
        ProductosVentas productosVentas = new ProductosVentas();
        String resultado = productosVentas.productoMasVendido(productos, ventas);

        // Mostrar el resultado
        System.out.println("\n=== Resultado ===");
        System.out.println(resultado);
    }

}
