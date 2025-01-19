/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3;

import java.util.Scanner;
/**
 *
 * @author daniel
 */
/**
 * Clase Ventas
 * Calcula cuántos empleados superaron un objetivo de ventas.
 */
public class Ventas {

    public void calcularVentas() {
        Scanner dato = new Scanner(System.in);

        System.out.print("Ingrese el número de empleados: ");
        int n = dato.nextInt();

        double[] ventas = new double[n];
        System.out.print("Ingrese el objetivo de ventas: ");
        double objetivo = dato.nextDouble();

        for (int i = 0; i < n; i++) {
            System.out.printf("Ingrese las ventas del empleado %d: ", i + 1);
            ventas[i] = dato.nextDouble();
            while (ventas[i] < 0) {
                System.out.print("Ventas inválidas. Inténtelo nuevamente: ");
                ventas[i] = dato.nextDouble();
            }
        }

        int superaronObjetivo = 0;
        for (double venta : ventas) {
            if (venta > objetivo) {
                superaronObjetivo++;
            }
        }

        System.out.printf("El número de empleados que superaron el objetivo es: %d%n", superaronObjetivo);
    }
}
