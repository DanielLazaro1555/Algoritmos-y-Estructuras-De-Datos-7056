/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4;

import java.util.Scanner;
/**
 *
 * @author daniel
 */
/**
 * Clase Asistencia
 * Calcula cuántos empleados asistieron todos los días de la semana.
 */
public class Asistencia {

    public void calcularAsistencia() {
        Scanner dato = new Scanner(System.in);

        System.out.print("Ingrese el número de empleados: ");
        int empleados = dato.nextInt();

        int[][] asistencia = new int[empleados][7];

        for (int i = 0; i < empleados; i++) {
            System.out.printf("=== Empleado %d ===%n", i + 1);
            for (int j = 0; j < 7; j++) {
                System.out.printf("Día %d (1=Presente, 0=Ausente): ", j + 1);
                asistencia[i][j] = dato.nextInt();
                while (asistencia[i][j] < 0 || asistencia[i][j] > 1) {
                    System.out.print("Valor inválido. Inténtelo nuevamente (1 o 0): ");
                    asistencia[i][j] = dato.nextInt();
                }
            }
        }

        int asistieronTodos = 0;
        for (int i = 0; i < empleados; i++) {
            boolean presenteTodaSemana = true;
            for (int j = 0; j < 7; j++) {
                if (asistencia[i][j] == 0) {
                    presenteTodaSemana = false;
                    break;
                }
            }
            if (presenteTodaSemana) {
                asistieronTodos++;
            }
        }

        System.out.printf("El número de empleados que asistieron todos los días es: %d%n", asistieronTodos);
    }
}
