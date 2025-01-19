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
public class MatrizSimetrica {
    private double[][] matriz;
    private int n;

    public MatrizSimetrica(int n) {
        this.n = n;
        matriz = new double[n][n];
    }

    public void setValor(int fila, int columna, double valor) {
        if (fila >= 0 && fila < n && columna >= 0 && columna < n) {
            matriz[fila][columna] = valor;
            matriz[columna][fila] = valor; // Asegurar simetría
        }
    }

    public double getValor(int fila, int columna) {
        return matriz[fila][columna];
    }

    public void mostrarMatriz() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
