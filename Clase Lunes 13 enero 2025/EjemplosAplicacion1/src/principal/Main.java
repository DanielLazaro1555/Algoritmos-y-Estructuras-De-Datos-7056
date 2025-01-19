/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;

import clases.ComparadorSecciones;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
/**
 * Clase principal Main
 * Interactúa con el usuario para verificar si dos secciones tienen los mismos estudiantes.
 * EJEMPLOS DE APLICACION
1. Una institución educativa cuenta con dos secciones para un mismo curso, y necesita verificar si ambas
tienen exactamente los mismos estudiantes inscritos. Diseña un programa que permita al usuario ingresar
los nombres de los estudiantes de ambas secciones. El programa debe:
• Comparar ambas listas y determinar si son iguales, independientemente del orden en que se ingresaron
los nombres.
• Mostrar un mensaje indicando si las secciones tienen los mismos estudiantes o si existen diferencias.
• Implementar una clase auxiliar que realice la comparación de arreglos de forma ordenada.
Nota: El programa debe utilizar métodos predefinidos para ordenar y comparar los arreglos.
 */
public class Main {

    public static void main(String[] args) {
        Scanner dato = new Scanner(System.in);
        ComparadorSecciones comparador = new ComparadorSecciones();

        System.out.print("Ingrese el número de estudiantes en la sección 1: ");
        int n1 = dato.nextInt();
        dato.nextLine(); // Consumir el salto de línea

        String[] seccion1 = new String[n1];
        System.out.println("Ingrese los nombres de los estudiantes de la sección 1:");
        for (int i = 0; i < n1; i++) {
            System.out.print("Estudiante " + (i + 1) + ": ");
            seccion1[i] = dato.nextLine();
        }

        System.out.print("\nIngrese el número de estudiantes en la sección 2: ");
        int n2 = dato.nextInt();
        dato.nextLine(); // Consumir el salto de línea

        String[] seccion2 = new String[n2];
        System.out.println("Ingrese los nombres de los estudiantes de la sección 2:");
        for (int i = 0; i < n2; i++) {
            System.out.print("Estudiante " + (i + 1) + ": ");
            seccion2[i] = dato.nextLine();
        }

        // Comparar las dos secciones
        boolean sonIguales = comparador.compararListas(seccion1, seccion2);

        // Mostrar el resultado
        System.out.println("\n=== Resultado ===");
        if (sonIguales) {
            System.out.println("Ambas secciones tienen exactamente los mismos estudiantes.");
        } else {
            System.out.println("Las secciones tienen estudiantes diferentes.");
        }
    }
}