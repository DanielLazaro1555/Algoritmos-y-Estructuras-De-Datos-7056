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
 * Representa una matriz triangular superior para almacenar precios de productos.
 * Como parte de la ampliación de la funcionalidad del sistema, se incorporarán operaciones con arreglos
bidimensionales para representar de manera eficiente ciertos aspectos del inventario. Se utilizarán matrices
para realizar operaciones matemáticas y simulaciones que optimicen la organización de los datos.
• Una matriz triangular inferior puede ser utilizada para representar un inventario en el que solo se almacenan
productos hasta un cierto punto. Esta matriz se llena de tal manera que solo se consideran los productos que
tienen una cantidad de stock relevante (por ejemplo, productos con stock bajo podrían almacenarse en la
parte inferior de la matriz).
• Por otro lado, una matriz triangular superior puede usarse para representar los precios de los productos. Los
elementos fuera de la diagonal se dejan vacíos, lo que optimiza el uso de la memoria y facilita el análisis de
los precios, especialmente cuando solo se trabaja con ciertos productos de la lista.
• La matriz tridiagonal será utilizada para almacenar tres características clave de los productos: nombre, precio
y cantidad en stock. Este tipo de matriz se optimiza para almacenar datos relacionados de manera
secuencial, permitiendo una organización eficiente de la información.
• Por último, una matriz simétrica se usará para comparar dos inventarios distintos. Este tipo de matriz permite
evaluar la relación entre los productos de un inventario y otro, facilitando la comparación de precios,
cantidades y otras características relevantes entre los inventarios.
 */
public class MatrizTriangularSuperior {
    private double[][] matriz;
    private int n;

    public MatrizTriangularSuperior(int n) {
        this.n = n;
        matriz = new double[n][];
        for (int i = 0; i < n; i++) {
            matriz[i] = new double[n - i]; // Solo almacenar desde la diagonal en adelante
        }
    }

    public void setValor(int fila, int columna, double valor) {
        if (fila >= 0 && fila < n && columna >= fila && columna < n) {
            matriz[fila][columna - fila] = valor; // Ajustar índice para almacenamiento
        } else {
            throw new IllegalArgumentException("Posición fuera de la matriz triangular superior.");
        }
    }

    public double getValor(int fila, int columna) {
        if (fila >= 0 && fila < n && columna >= fila && columna < n) {
            return matriz[fila][columna - fila];
        }
        return 0; // Elementos fuera de la matriz triangular superior son 0
    }

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
