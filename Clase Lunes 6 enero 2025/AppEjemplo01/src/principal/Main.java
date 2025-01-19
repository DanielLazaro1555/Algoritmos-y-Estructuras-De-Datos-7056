package principal;

import java.util.Scanner;
import clases.Alumno;

/**
 * Clase principal Main
 * Permite ingresar datos de alumnos, validar las notas y mostrar resultados.
 * 
 * @author daniel
 */
public class Main {

    public static void main(String[] args) {
        Scanner dato = new Scanner(System.in);
        
        // Declaración de arrays para almacenar los datos de los alumnos
        String[] nombres = new String[2];
        double[] notas = new double[2];
        String[] calificaciones = new String[2];
        
        // Bucle para ingresar datos de los alumnos
        for (int i = 0; i < 2; i++) {
            // Ingreso del nombre
            System.out.println("Ingrese el nombre del alumno " + (i + 1) + ": ");
            nombres[i] = dato.nextLine();

            // Validación e ingreso de la nota
            double nota = -1;
            while (nota < 0 || nota > 20) {
                System.out.println("Ingrese la nota de " + nombres[i] + " (0-20): ");
                try {
                    nota = Double.parseDouble(dato.nextLine()); // Intentar convertir la entrada a número
                    if (nota < 0 || nota > 20) {
                        System.out.println("Nota inválida. Debe estar entre 0 y 20.");
                    } else {
                        notas[i] = nota; // Asignar nota válida
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número.");
                }
            }

            // Crear instancia de Alumno y obtener su calificación
            Alumno alumno = new Alumno(nombres[i], notas[i]);
            calificaciones[i] = alumno.getCalificacion();
        }

        // Mostrar los datos de los alumnos
        System.out.println("\n=== Resumen de Alumnos ===");
        for (int i = 0; i < 2; i++) {
            System.out.println("Alumno: " + nombres[i]);
            System.out.println("Nota: " + notas[i]);
            System.out.println("Calificación: " + calificaciones[i]);
            System.out.println();
        }
    }
}
