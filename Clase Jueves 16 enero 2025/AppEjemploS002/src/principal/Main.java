package principal;

import logica.GestorProyectos;
import modelo.ProyectoDesempeño;
import java.util.Scanner;

/**
 * Clase principal Main
 * Este programa gestiona proyectos, calcula promedios de desempeño,
 * identifica el mejor proyecto, y realiza operaciones de clonación y comparación.
 * 
 * @author daniel
 */
public class Main {

    public static void main(String[] args) {
        Scanner dato = new Scanner(System.in);

        // Validación para ingresar el número de proyectos
        int numProyectos = 0;
        do {
            System.out.print("Ingrese el número de proyectos (mayor a 0): ");
            while (!dato.hasNextInt()) {
                System.out.println("Error: Debe ingresar un número entero válido.");
                System.out.print("Ingrese el número de proyectos (mayor a 0): ");
                dato.next(); // Consumir entrada inválida
            }
            numProyectos = dato.nextInt();
            if (numProyectos <= 0) {
                System.out.println("El número de proyectos debe ser mayor a 0. Inténtelo nuevamente.");
            }
        } while (numProyectos <= 0);

        // Crear el objeto ProyectoDesempeño y el GestorProyectos
        ProyectoDesempeño matriz = new ProyectoDesempeño(numProyectos);
        GestorProyectos gestor = new GestorProyectos();

        // Llenar la matriz de desempeño
        gestor.llenarMatriz(matriz);

        // Mostrar la matriz de desempeño
        System.out.println("\nMatriz de Desempeño:");
        matriz.mostrarMatriz();

        // Validación para ingresar el umbral
        int umbral = 0;
        do {
            System.out.print("Ingrese el umbral para cálculo de promedio (0 o mayor): ");
            while (!dato.hasNextInt()) {
                System.out.println("Error: Debe ingresar un número entero válido.");
                System.out.print("Ingrese el umbral para cálculo de promedio (0 o mayor): ");
                dato.next(); // Consumir entrada inválida
            }
            umbral = dato.nextInt();
            if (umbral < 0) {
                System.out.println("El umbral debe ser 0 o mayor. Inténtelo nuevamente.");
            }
        } while (umbral < 0);

        // Calcular el promedio global para proyectos con desempeño mayor al umbral
        double promedio = matriz.calcularPromedioUmbral(umbral);
        System.out.printf("El promedio global para proyectos con desempeño mayor a %d es %.2f%n", umbral, promedio);

        // Determinar el proyecto con mejor desempeño
        int mejorProyecto = matriz.obtenerProyectoMD();
        if (mejorProyecto != -1) {
            System.out.printf("El proyecto con mejor desempeño es el número %d.%n", mejorProyecto);
        } else {
            System.out.println("No hay datos suficientes para determinar el mejor proyecto.");
        }

        // Clonar la matriz de desempeño
        ProyectoDesempeño clon = matriz.clonar();

        // Mostrar la matriz clonada
        System.out.println("\nMatriz Clonada:");
        clon.mostrarMatriz();

        // Comparar la matriz original con la clonada
        boolean sonIguales = matriz.comparar(clon);
        System.out.println("¿Son iguales la matriz original y la clonada? " + (sonIguales ? "Sí" : "No"));
    }
}
