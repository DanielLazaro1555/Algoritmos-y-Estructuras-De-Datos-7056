package logica;

import modelo.ProyectoDesempeño;
import java.util.Scanner;

/**
 * Clase GestorProyectos
 * Permite gestionar y llenar una matriz de desempeño de proyectos.
 * 
 * @author daniel
 */
public class GestorProyectos {
    
    private Scanner dato;
    
    // Constructor
    public GestorProyectos() {
        this.dato = new Scanner(System.in);
    }
    
    /**
     * Método para llenar la matriz de puntajes de desempeño de los proyectos.
     * 
     * @param matriz Objeto ProyectoDesempeño que contiene la matriz a llenar.
     */
    public void llenarMatriz(ProyectoDesempeño matriz) {
        for (int i = 0; i < matriz.getNumProyectos(); i++) { // Se corrigió el uso de "matriz"
            for (int j = 0; j <= i; j++) {
                int valor;
                do {
                    System.out.printf("Ingrese puntaje para el proyecto %d, Indicador %d (0-100): ", i + 1, j + 1);
                    
                    // Validar entrada para evitar errores si el usuario ingresa un dato no numérico
                    while (!dato.hasNextInt()) {
                        System.out.println("Error: Debe ingresar un número entre 0 y 100.");
                        System.out.printf("Ingrese puntaje para el proyecto %d, Indicador %d (0-100): ", i + 1, j + 1);
                        dato.next(); // Consumir el valor no válido
                    }
                    
                    valor = dato.nextInt();
                    
                    if (valor < 0 || valor > 100) {
                        System.out.println("Error: El puntaje debe estar entre 0 y 100. Inténtelo nuevamente.");
                    }
                } while (valor < 0 || valor > 100);
                
                // Se corrigió el uso de matriz para llamar a ingresarDatos
                matriz.ingresarDatos(i, j, valor);
            }
        }
    }
}
