/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import java.util.Scanner;
/**
 *
 * @author daniel
 */
/**
 * Clase Calificaciones
 * Calcula promedios de calificaciones de alumnos y el mejor promedio.
 */
public class Calificaciones {

    public void calcularCalificaciones() {
        Scanner dato = new Scanner(System.in);

        System.out.print("Ingrese el número de alumnos: ");
        int n = dato.nextInt();

        while (n <= 0) {
            System.out.print("El número de alumnos debe ser mayor a 0. Inténtelo nuevamente: ");
            n = dato.nextInt();
        }

        double[][] calificaciones = new double[n][3];
        double[] promedios = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("=== Alumno %d ===%n", i + 1);
            double suma = 0;
            for (int j = 0; j < 3; j++) {
                System.out.printf("Ingrese la calificación del examen %d: ", j + 1);
                calificaciones[i][j] = dato.nextDouble();
                while (calificaciones[i][j] < 0 || calificaciones[i][j] > 20) {
                    System.out.print("Calificación inválida. Inténtelo nuevamente: ");
                    calificaciones[i][j] = dato.nextDouble();
                }
                suma += calificaciones[i][j];
            }
            promedios[i] = suma / 3;
        }

        double promedioGeneral = 0;
        for (double promedio : promedios) {
            promedioGeneral += promedio;
        }
        promedioGeneral /= n;

        int mejorAlumno = -1;
        double mayorPromedio = -1;
        for (int i = 0; i < n; i++) {
            if (promedios[i] > mayorPromedio) {
                mayorPromedio = promedios[i];
                mejorAlumno = i + 1;
            }
        }

        System.out.printf("%nEl promedio general del grupo es: %.2f%n", promedioGeneral);
        System.out.printf("El alumno con el mayor promedio es el Alumno %d con un promedio de %.2f%n", mejorAlumno, mayorPromedio);
    }
}
