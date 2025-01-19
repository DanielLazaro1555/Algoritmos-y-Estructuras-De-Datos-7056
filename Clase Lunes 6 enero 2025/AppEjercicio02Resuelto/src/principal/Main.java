/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;

import clases.Ventas;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
/**
 * Clase Main
 * Interactúa con el usuario para registrar ventas y mostrar resultados.
 */
public class Main {

    public static void main(String[] args) {
        Scanner dato = new Scanner(System.in);

        // Solicitar el número de vendedores
        System.out.print("Ingrese el número de vendedores: ");
        int numVendedores = dato.nextInt();

        // Crear una instancia de Ventas
        Ventas ventas = new Ventas(numVendedores);

        // Registrar las ventas mensuales para cada vendedor
        for (int vendedor = 0; vendedor < numVendedores; vendedor++) {
            System.out.printf("=== Vendedor %d ===%n", vendedor + 1);
            for (int mes = 0; mes < 12; mes++) {
                System.out.printf("Ingrese las ventas del mes %d: ", mes + 1);
                double monto = dato.nextDouble();
                ventas.registrarVenta(vendedor, mes, monto);
            }
        }

        // Mostrar las ventas registradas
        System.out.println("\n=== Ventas Registradas ===");
        ventas.mostrarVentas();

        // Calcular y mostrar el total de ventas anuales por vendedor
        System.out.println("\n=== Total de Ventas Anuales por Vendedor ===");
        for (int vendedor = 0; vendedor < numVendedores; vendedor++) {
            double totalVentas = ventas.calcularTotalVentas(vendedor);
            System.out.printf("Vendedor %d: %.2f%n", vendedor + 1, totalVentas);
        }

        // Determinar y mostrar el vendedor con mayores ventas
        int mejorVendedor = ventas.obtenerVendedorConMayorVentas();
        System.out.printf("%nEl vendedor con mayores ventas es el Vendedor %d.%n", mejorVendedor + 1);

        // Calcular y mostrar el promedio mensual de ventas por vendedor
        System.out.println("\n=== Promedio Mensual de Ventas por Vendedor ===");
        for (int vendedor = 0; vendedor < numVendedores; vendedor++) {
            double promedio = ventas.calcularPromedioVentas(vendedor);
            System.out.printf("Vendedor %d: %.2f%n", vendedor + 1, promedio);
        }
    }
}
