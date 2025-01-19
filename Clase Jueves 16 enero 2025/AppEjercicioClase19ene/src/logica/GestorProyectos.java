/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import modelo.ProyectoDesempeño;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
/**
 * Clase GestorProyectos
 * Se encarga de gestionar y validar las operaciones sobre la matriz de presupuesto.
 */
public class GestorProyectos {
    private Scanner dato;

    public GestorProyectos() {
        this.dato = new Scanner(System.in);
    }

    // Llenar la matriz garantizando la simetría
    public void llenarMatriz(ProyectoDesempeño matriz) {
        for (int i = 0; i < matriz.getNumDepartamentos(); i++) {
            for (int j = i; j < matriz.getNumDepartamentos(); j++) {
                System.out.printf("Ingrese presupuesto entre departamento %d y %d: ", i + 1, j + 1);
                double valor = dato.nextDouble();
                matriz.ingresarDato(i, j, valor);
            }
        }
    }

    // Validar si el presupuesto total supera el límite
    public void validarPresupuestoTotal(ProyectoDesempeño matriz, double limite) {
        double total = matriz.calcularPresupuestoTotal();
        if (total > limite) {
            System.out.printf("Advertencia: El presupuesto total %.2f supera el límite %.2f%n", total, limite);
        } else {
            System.out.printf("El presupuesto total es %.2f y está dentro del límite %.2f%n", total, limite);
        }
    }
}
