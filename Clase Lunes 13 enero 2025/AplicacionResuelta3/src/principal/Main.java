/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;

import clases.*;
import java.util.Scanner;
/**
 *
 * @author daniel
 */
/**
 * Clase principal Main
 * Prueba las funcionalidades de las matrices.
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
public class Main {

    public static void main(String[] args) {
        Scanner dato = new Scanner(System.in);

        System.out.println("=== Seleccione el tipo de matriz para probar ===");
        System.out.println("1. Matriz Triangular Inferior");
        System.out.println("2. Matriz Triangular Superior");
        System.out.println("3. Matriz Tridiagonal");
        System.out.println("4. Matriz Simétrica");
        System.out.print("Ingrese una opción: ");
        int opcion = dato.nextInt();

        switch (opcion) {
            case 1 -> {
                MatrizTriangularInferior inferior = new MatrizTriangularInferior(4);
                inferior.setValor(3, 2, 5);
                inferior.mostrarMatriz();
            }
            case 2 -> {
                MatrizTriangularSuperior superior = new MatrizTriangularSuperior(4);
                superior.setValor(1, 3, 7.5);
                superior.mostrarMatriz();
            }
            case 3 -> {
                MatrizTridiagonal tridiagonal = new MatrizTridiagonal(4);
                tridiagonal.setValor(2, 0, 4);
                tridiagonal.mostrarMatriz();
            }
            case 4 -> {
                MatrizSimetrica simetrica = new MatrizSimetrica(3);
                simetrica.setValor(1, 2, 8);
                simetrica.mostrarMatriz();
            }
            default -> System.out.println("Opción inválida.");
        }
    }
}
