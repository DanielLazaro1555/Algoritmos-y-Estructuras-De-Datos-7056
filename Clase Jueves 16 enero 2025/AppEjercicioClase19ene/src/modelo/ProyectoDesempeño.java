/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author daniel
 */

/**
 * Clase ProyectoDesempeño
 * Representa una matriz simétrica para gestionar presupuestos entre departamentos.
 */
public class ProyectoDesempeño {
    private double[][] matriz; // Matriz simétrica de presupuestos
    private int numDepartamentos;

    // Constructor
    public ProyectoDesempeño(int numDepartamentos) {
        this.numDepartamentos = numDepartamentos;
        this.matriz = new double[numDepartamentos][numDepartamentos];
    }

    public int getNumDepartamentos() {
        return numDepartamentos;
    }

    // Ingresar un valor en la matriz
    public void ingresarDato(int fila, int columna, double valor) {
        if (fila >= 0 && fila < numDepartamentos && columna >= 0 && columna < numDepartamentos) {
            matriz[fila][columna] = valor;
            matriz[columna][fila] = valor; // Garantizar simetría
        }
    }

    // Obtener un valor de la matriz
    public double obtenerDato(int fila, int columna) {
        if (fila >= 0 && fila < numDepartamentos && columna >= 0 && columna < numDepartamentos) {
            return matriz[fila][columna];
        }
        return -1; // Retorno por defecto si hay un error
    }

    // Calcular el presupuesto total
    public double calcularPresupuestoTotal() {
        double total = 0;
        for (int i = 0; i < numDepartamentos; i++) {
            for (int j = 0; j < numDepartamentos; j++) {
                total += matriz[i][j];
            }
        }
        return total;
    }

    // Identificar el departamento con mayor presupuesto interno
    public int obtenerDepartamentoMayorPresupuesto() {
        int indiceMayor = -1;
        double maxPresupuesto = -1;

        for (int i = 0; i < numDepartamentos; i++) {
            if (matriz[i][i] > maxPresupuesto) {
                maxPresupuesto = matriz[i][i];
                indiceMayor = i + 1; // Índice +1 para mostrar al usuario
            }
        }
        return indiceMayor;
    }

    // Clonar la matriz
    public ProyectoDesempeño clonar() {
        ProyectoDesempeño copia = new ProyectoDesempeño(numDepartamentos);
        for (int i = 0; i < numDepartamentos; i++) {
            System.arraycopy(this.matriz[i], 0, copia.matriz[i], 0, numDepartamentos);
        }
        return copia;
    }

    // Comparar matrices
    public boolean comparar(ProyectoDesempeño otraMatriz) {
        if (this.numDepartamentos != otraMatriz.numDepartamentos) {
            return false;
        }
        for (int i = 0; i < numDepartamentos; i++) {
            for (int j = 0; j < numDepartamentos; j++) {
                if (this.matriz[i][j] != otraMatriz.matriz[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Mostrar la matriz
    public void mostrarMatriz() {
        for (int i = 0; i < numDepartamentos; i++) {
            for (int j = 0; j < numDepartamentos; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
