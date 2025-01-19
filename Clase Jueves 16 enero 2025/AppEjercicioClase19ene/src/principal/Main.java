/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;

import logica.GestorProyectos;
import modelo.ProyectoDesempeño;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
/**
 * Clase principal Main
 * Permite al usuario interactuar con la matriz de presupuesto.
 */
public class Main {

    public static void main(String[] args) {
        Scanner dato = new Scanner(System.in);

        // Solicitar número de departamentos
        System.out.print("Ingrese el número de departamentos: ");
        int numDepartamentos = dato.nextInt();

        ProyectoDesempeño matriz = new ProyectoDesempeño(numDepartamentos);
        GestorProyectos gestor = new GestorProyectos();

        // Llenar la matriz
        gestor.llenarMatriz(matriz);

        // Mostrar la matriz
        System.out.println("\nMatriz de presupuesto:");
        matriz.mostrarMatriz();

        // Validar presupuesto total
        System.out.print("Ingrese el límite del presupuesto total: ");
        double limite = dato.nextDouble();
        gestor.validarPresupuestoTotal(matriz, limite);

        // Identificar departamento con mayor presupuesto interno
        int mayorPresupuesto = matriz.obtenerDepartamentoMayorPresupuesto();
        System.out.printf("El departamento con mayor presupuesto interno es el número %d.%n", mayorPresupuesto);

        // Clonar y comparar matrices
        ProyectoDesempeño clon = matriz.clonar();
        System.out.println("¿Las matrices original y clonada son iguales? " + (matriz.comparar(clon) ? "Sí" : "No"));
    }
}
