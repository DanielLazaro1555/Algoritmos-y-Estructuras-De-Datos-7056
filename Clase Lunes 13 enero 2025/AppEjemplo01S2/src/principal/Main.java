package principal;

import clases.ComparadorArreglos;
import java.util.Scanner;

/**
 * Clase principal para comparar dos listas de nombres de estudiantes (secciones).
 * Permite al usuario ingresar los nombres de estudiantes de dos secciones y
 * utiliza la clase ComparadorArreglos para verificar si ambas listas son iguales.
 * 
 * @author Daniel
 */
public class Main {

    public static void main(String[] args) {
        // Crear un objeto Scanner para capturar la entrada del usuario.
        Scanner dato = new Scanner(System.in);

        // Solicitar al usuario la cantidad de estudiantes de la sección 1.
        System.out.println("Ingrese la cantidad de Estudiantes sección 1:");
        int numEstudiantes1 = dato.nextInt();
        dato.nextLine(); // Consumir el salto de línea pendiente.

        // Crear un arreglo para almacenar los nombres de los estudiantes de la sección 1.
        String[] seccion1 = new String[numEstudiantes1];
        System.out.println("Ingrese nombres de estudiantes sección 1:");

        // Capturar los nombres de los estudiantes de la sección 1.
        for (int i = 0; i < numEstudiantes1; i++) {
            System.err.println("Estudiante " + (i + 1) + ": ");
            seccion1[i] = dato.nextLine();
        }

        // Solicitar al usuario la cantidad de estudiantes de la sección 2.
        System.out.println("Ingrese la cantidad de Estudiantes sección 2:");
        int numEstudiantes2 = dato.nextInt();
        dato.nextLine(); // Consumir el salto de línea pendiente.

        // Crear un arreglo para almacenar los nombres de los estudiantes de la sección 2.
        String[] seccion2 = new String[numEstudiantes2];
        System.out.println("Ingrese nombres de estudiantes sección 2:");

        // Capturar los nombres de los estudiantes de la sección 2.
        for (int i = 0; i < numEstudiantes2; i++) { // Corregí aquí el uso de numEstudiantes1.
            System.err.println("Estudiante " + (i + 1) + ": ");
            seccion2[i] = dato.nextLine();
        }

        // Crear un objeto de la clase ComparadorArreglos.
        ComparadorArreglos comparador = new ComparadorArreglos();

        // Verificar si ambas listas (secciones) son iguales.
        boolean sonIguales = comparador.sonlistasiguales(seccion1, seccion2);

        // Mostrar el resultado al usuario.
        if (sonIguales) {
            System.out.println("Ambas secciones son iguales.");
        } else {
            System.out.println("Ambas secciones tienen diferencias.");
        }

        // Cerrar el objeto Scanner.
        dato.close();
    }
}
