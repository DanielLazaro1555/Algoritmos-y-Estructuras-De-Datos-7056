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
 * Clase MatrizTridiagonal
 * Representa productos con nombre, precio y cantidad en una estructura tridiagonal.
 */
public class MatrizTridiagonal {
    private double[][] matriz;
    private int n;

    public MatrizTridiagonal(int n) {
        this.n = n;
        matriz = new double[n][3]; // Solo se almacenan los elementos de las tres diagonales
    }

    // Agregar un valor a la matriz
    public void setValor(int fila, int diagonal, double valor) {
        if (fila >= 0 && fila < n && diagonal >= -1 && diagonal <= 1) {
            matriz[fila][diagonal + 1] = valor; // -1 se almacena en la columna 0, 0 en la 1, y +1 en la 2
        } else {
            System.out.println("Posición inválida en la matriz tridiagonal.");
        }
    }

    // Obtener un valor de la matriz
    public double getValor(int fila, int diagonal) {
        if (fila >= 0 && fila < n && diagonal >= -1 && diagonal <= 1) {
            return matriz[fila][diagonal + 1];
        }
        return 0; // Valores fuera de la tridiagonal son considerados 0
    }

    // Mostrar la matriz tridiagonal
    public void mostrarMatriz() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(i - j) <= 1) {
                    System.out.print(getValor(i, j - i) + "\t");
                } else {
                    System.out.print("0\t");
                }
            }
            System.out.println();
        }
    }
}
