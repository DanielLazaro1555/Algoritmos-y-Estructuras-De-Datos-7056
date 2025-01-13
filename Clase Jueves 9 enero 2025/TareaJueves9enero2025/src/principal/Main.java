package principal;

import clases.GestorCalificaciones;
import java.util.Scanner;

/**
 * Clase principal que inicia el programa.
 */
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese la cantidad máxima de calificaciones: ");
        int capacidad = entrada.nextInt(); // Leer capacidad dinámica del usuario

        GestorCalificaciones gestor = new GestorCalificaciones(capacidad); // Pasar capacidad al gestor
        gestor.iniciar();
    }
}
