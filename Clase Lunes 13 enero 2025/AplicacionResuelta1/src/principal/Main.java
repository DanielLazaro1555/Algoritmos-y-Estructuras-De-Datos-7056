/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;

import clases.MatrizDesempeño;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
/**
 * Clase principal Main Permite gestionar la matriz triangular inferior de
 * desempeño.
 * 1. En una organización, cada equipo de trabajo es evaluado en función de varios indicadores de desempeño en
diferentes proyectos. Esta información se organiza en una matriz triangular inferior, donde cada fila representa
un proyecto y las columnas corresponden a los indicadores evaluados.
El programa debe permitir:
• Ingresar por teclado los puntajes de desempeño para cada proyecto. Los valores deben estar en el rango de
0 a 100.
• Validar que cada valor ingresado esté dentro del rango especificado. Si no lo está, solicitar nuevamente el
ingreso del dato.
• Crear una copia de la matriz para realizar simulaciones sin alterar los datos originales.
• Verificar si dos matrices de desempeño son iguales.
• Combinar los datos de dos matrices de desempeño sumando los valores correspondientes.
• Calcular y mostrar el promedio global del desempeño, pero únicamente considerando los proyectos cuyo
desempeño total (suma de sus valores) supere un umbral especificado por el usuario.
• Identificar y mostrar el proyecto con el mayor desempeño total.
• Validar que todos los datos ingresados estén completos antes de realizar cualquier operación adicional.
 */
public class Main {

    public static void main(String[] args) {
        Scanner dato = new Scanner(System.in);

        System.out.print("Ingrese el número de proyectos: ");
        int numProyectos = dato.nextInt();

        MatrizDesempeño matriz = new MatrizDesempeño(numProyectos);

        // Ingreso de datos
        System.out.println("Ingrese los puntajes de desempeño (0 a 100):");
        for (int i = 0; i < numProyectos; i++) {
            for (int j = 0; j <= i; j++) {
                int valor;
                do {
                    System.out.printf("Ingrese el valor para la posición (%d, %d): ", i + 1, j + 1);
                    valor = dato.nextInt();
                    if (valor < 0 || valor > 100) {
                        System.out.println("Valor inválido. Debe estar entre 0 y 100.");
                    }
                } while (valor < 0 || valor > 100);

                matriz.ingresarDato(i, j, valor);
            }
        }

        // Mostrar la matriz original
        System.out.println("\n=== Matriz de Desempeño ===");
        matriz.mostrarMatriz();

        // Clonar la matriz
        MatrizDesempeño clon = matriz.clonar();
        System.out.println("\n=== Clonación de la Matriz ===");
        clon.mostrarMatriz();

        // Comparar la matriz original con el clon
        System.out.println("\n¿La matriz original y el clon son iguales? " + (matriz.comparar(clon) ? "Sí" : "No"));

        // Fusionar matrices
        System.out.println("\n=== Fusionando la matriz original consigo misma ===");
        matriz.combinar(clon);
        matriz.mostrarMatriz();

        // Calcular promedio considerando un umbral
        System.out.print("\nIngrese el umbral para calcular el promedio: ");
        int umbral = dato.nextInt();
        double promedio = matriz.calcularPromedioUmbral(umbral);
        System.out.printf("El promedio global para proyectos con desempeño mayor a %d es %.2f%n", umbral, promedio);

        // Obtener el proyecto con mejor desempeño
        int mejorProyecto = matriz.obtenerProyectoConMayorDesempeno();
        System.out.printf("El proyecto con mejor desempeño es el número %d.%n", mejorProyecto);
    }
}
