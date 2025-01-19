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
 * Clase MatrizTriangularInferior
 * Representa productos con cantidades de stock relevantes.
 */
public class MatrizTriangularInferior {
    private int[][] matriz;
    private int n;

    public MatrizTriangularInferior(int n) {
        this.n = n;
        matriz = new int[n][];
        for (int i = 0; i < n; i++) {
            matriz[i] = new int[i + 1]; // Solo almacenar elementos hasta la diagonal
        }
    }

    // Agregar un valor a la matriz
    public void setValor(int fila, int columna, int valor) {
        if (fila >= 0 && fila < n && columna >= 0 && columna <= fila) {
            matriz[fila][columna] = valor;
        } else {
            System.out.println("Posición inválida en la matriz triangular inferior.");
        }
    }

    // Obtener un valor de la matriz
    public int getValor(int fila, int columna) {
        if (fila >= 0 && fila < n && columna >= 0 && columna <= fila) {
            return matriz[fila][columna];
        }
        return 0; // Valores fuera de la matriz triangular inferior son considerados 0
    }

    // Mostrar la matriz triangular inferior
    public void mostrarMatriz() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
