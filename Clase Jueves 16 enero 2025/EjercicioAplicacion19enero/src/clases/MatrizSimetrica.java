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
 * Clase MatrizSimetrica
 * Representa una matriz simétrica para comparar inventarios.
 */
public class MatrizSimetrica {
    private double[][] matriz;
    private int n;

    public MatrizSimetrica(int n) {
        this.n = n;
        matriz = new double[n][n];
    }

    // Agregar un valor a la matriz
    public void setValor(int fila, int columna, double valor) {
        if (fila >= 0 && fila < n && columna >= 0 && columna < n) {
            matriz[fila][columna] = valor;
            matriz[columna][fila] = valor; // Asegurar simetría
        }
    }

    // Obtener un valor de la matriz
    public double getValor(int fila, int columna) {
        if (fila >= 0 && fila < n && columna >= 0 && columna < n) {
            return matriz[fila][columna];
        }
        return 0;
    }

    // Mostrar la matriz simétrica
    public void mostrarMatriz() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
