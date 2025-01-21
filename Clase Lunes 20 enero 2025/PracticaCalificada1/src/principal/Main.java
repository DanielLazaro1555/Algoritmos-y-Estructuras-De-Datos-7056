/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;

import clases.PropiedadesMatriz;
import clases.CalculosVentas;
import java.util.Scanner;

/**
 * Clase principal del programa. Permite ingresar datos, analizar propiedades de
 * la matriz y realizar cálculos relacionados con las ventas.
 *
 * @author daniel
 */
public class Main {

    public static void main(String[] args) {
        // Escáner para leer los datos del usuario
        Scanner sc = new Scanner(System.in);
        int[][] ventas = new int[12][12]; // Matriz para almacenar las ventas

        // Ingreso de datos
        System.out.println("Ingrese las ventas mensuales (números enteros no negativos):");
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                while (true) {
                    System.out.print("Mes " + (i + 1) + ", Sucursal " + (j + 1) + ": ");
                    try {
                        int valor = Integer.parseInt(sc.nextLine());
                        if (valor >= 0) {
                            ventas[i][j] = valor; // Guardar el valor en la matriz
                            break;
                        } else {
                            System.out.println("Error: Ingrese un número no negativo.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Ingrese un número válido.");
                    }
                }
            }
        }

        // Verificar propiedades de la matriz
        boolean triangularSuperior = PropiedadesMatriz.esTriangularSuperior(ventas);
        boolean triangularInferior = PropiedadesMatriz.esTriangularInferior(ventas);
        boolean simetrica = PropiedadesMatriz.esSimetrica(ventas);

        // Mostrar propiedades de la matriz
        System.out.println("\nPropiedades de la matriz:");
        if (triangularSuperior) {
            System.out.println("- Es triangular superior.");
        }
        if (triangularInferior) {
            System.out.println("- Es triangular inferior.");
        }
        if (simetrica) {
            System.out.println("- Es simétrica.");
        }
        if (!triangularSuperior && !triangularInferior && !simetrica) {
            System.out.println("- Es asimétrica.");
        }

        // Cálculos de ventas por mes y por sucursal
        int[] totalMes = CalculosVentas.calcularTotalPorMes(ventas);
        int[] totalSucursal = CalculosVentas.calcularTotalPorSucursal(ventas);

        // Identificar el mes con mayores ventas
        int mesMayorVenta = 0;
        for (int i = 0; i < totalMes.length; i++) {
            if (totalMes[i] > totalMes[mesMayorVenta]) {
                mesMayorVenta = i;
            }
        }

        // Mostrar totales por mes
        System.out.println("\nTotales de ventas por mes:");
        for (int i = 0; i < totalMes.length; i++) {
            System.out.println("Mes " + (i + 1) + ": " + totalMes[i]);
        }
        System.out.println("Mes con mayores ventas: Mes " + (mesMayorVenta + 1));

        // Identificar sucursales con mayor y menor ventas totales
        int maxVenta = 0, minVenta = Integer.MAX_VALUE;
        for (int i = 0; i < totalSucursal.length; i++) {
            maxVenta = Math.max(maxVenta, totalSucursal[i]);
            minVenta = Math.min(minVenta, totalSucursal[i]);
        }

        // Mostrar totales por sucursal
        System.out.println("\nTotales de ventas por sucursal:");
        for (int i = 0; i < totalSucursal.length; i++) {
            System.out.println("Sucursal " + (i + 1) + ": " + totalSucursal[i]);
        }
        System.out.println("Sucursal con mayor venta total: " + maxVenta);
        System.out.println("Sucursal con menor venta total: " + minVenta);

// Calcular el promedio general de ventas
        double sumaTotal = 0;
        for (int total : totalSucursal) {
            sumaTotal += total;
        }
        double promedioGeneral = sumaTotal / totalSucursal.length;

// Mostrar sucursales que superan un 20% del promedio general
        System.out.println("\nSucursales que superan un 20% del promedio general:");
        double umbral = promedioGeneral * 1.2;
        for (int i = 0; i < totalSucursal.length; i++) {
            if (totalSucursal[i] > umbral) {
                System.out.println("Sucursal " + (i + 1) + " (Total: " + totalSucursal[i] + ")");
            }
        }

// Ordenar sucursales según sus ventas totales
        int[] indicesOrdenados = CalculosVentas.ordenarIndicesPorVentas(totalSucursal);
        System.out.println("\nSucursales ordenadas por ventas totales:");
        for (int i : indicesOrdenados) {
            System.out.print("Sucursal " + (i + 1) + ": ");
            for (int j = 0; j < 12; j++) {
                System.out.print(ventas[j][i] + " "); // Mostrar meses en orden
            }
            System.out.println();
        }
    }
}
