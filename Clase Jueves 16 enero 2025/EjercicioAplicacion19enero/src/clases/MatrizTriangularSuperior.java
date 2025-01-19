/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author daniel
 */
/**
 * Clase MatrizTriangularSuperior
 * Representa precios de productos en una matriz triangular superior.
 */
public class MatrizTriangularSuperior {
    private double[][] matriz;
    private int n;

    public MatrizTriangularSuperior(int n) {
        this.n = n;
        matriz = new double[n][];
        for (int i = 0; i < n; i++) {
            matriz[i] = new double[n - i]; // Solo almacenar elementos desde la diagonal hasta el final
        }
    }

    // Agregar un valor a la matriz
    public void setValor(int fila, int columna, double valor) {
        if (fila >= 0 && fila < n && columna >= fila && columna < n) {
            matriz[fila][columna - fila] = valor; // Ajustar índice para la triangular superior
        } else {
            System.out.println("Posición inválida en la matriz triangular superior.");
        }
    }

    // Obtener un valor de la matriz
    public double getValor(int fila, int columna) {
        if (fila >= 0 && fila < n && columna >= fila && columna < n) {
            return matriz[fila][columna - fila];
        }
        return 0; // Valores fuera de la matriz triangular superior son considerados 0
    }

    // Mostrar la matriz triangular superior
    public void mostrarMatriz() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j >= i) {
                    System.out.print(getValor(i, j) + "\t");
                } else {
                    System.out.print("0\t");
                }
            }
            System.out.println();
        }
    }
}
