/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio1;

import java.util.Scanner;
/**
 *
 * @author daniel
 */
/**
 * Clase Alturas
 * Calcula cuántas personas tienen una altura superior o inferior a la media.
 */
public class Alturas {

    public void calcularAlturas() {
        Scanner dato = new Scanner(System.in);

        System.out.print("Ingrese el número de personas: ");
        int n = dato.nextInt();

        while (n <= 0) {
            System.out.print("El número de personas debe ser mayor a 0. Inténtelo nuevamente: ");
            n = dato.nextInt();
        }

        double[] alturas = new double[n];
        double suma = 0;

        System.out.println("Ingrese las alturas en centímetros:");
        for (int i = 0; i < n; i++) {
            System.out.printf("Persona %d: ", i + 1);
            alturas[i] = dato.nextDouble();
            while (alturas[i] <= 0) {
                System.out.print("Altura inválida. Inténtelo nuevamente: ");
                alturas[i] = dato.nextDouble();
            }
            suma += alturas[i];
        }

        double media = suma / n;
        System.out.printf("La altura media es: %.2f cm%n", media);

        int superiores = 0, inferiores = 0;
        for (double altura : alturas) {
            if (altura > media) {
                superiores++;
            } else if (altura < media) {
                inferiores++;
            }
        }

        System.out.println("Personas con altura superior a la media: " + superiores);
        System.out.println("Personas con altura inferior a la media: " + inferiores);
    }
}
