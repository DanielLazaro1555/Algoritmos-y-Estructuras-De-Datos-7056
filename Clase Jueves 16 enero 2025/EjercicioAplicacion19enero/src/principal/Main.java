/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;
import clases.MatrizTriangularInferior;
import clases.MatrizTriangularSuperior;
import clases.MatrizTridiagonal;
import clases.MatrizSimetrica;
import java.util.Scanner;
/**
 *
 * @author daniel
 */
/**
 * Clase Main
 * Prueba las funcionalidades de las matrices desde el paquete "clases".
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
                System.out.println("=== Matriz Triangular Inferior ===");
                System.out.print("Ingrese el tamaño de la matriz: ");
                int n = dato.nextInt();
                MatrizTriangularInferior inferior = new MatrizTriangularInferior(n);

                // Llenar la matriz triangular inferior
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j <= i; j++) {
                        System.out.printf("Ingrese el valor para la posición (%d, %d): ", i, j);
                        int valor = dato.nextInt();
                        inferior.setValor(i, j, valor);
                    }
                }

                System.out.println("Matriz Triangular Inferior:");
                inferior.mostrarMatriz();
            }
            case 2 -> {
                System.out.println("=== Matriz Triangular Superior ===");
                System.out.print("Ingrese el tamaño de la matriz: ");
                int n = dato.nextInt();
                MatrizTriangularSuperior superior = new MatrizTriangularSuperior(n);

                // Llenar la matriz triangular superior
                for (int i = 0; i < n; i++) {
                    for (int j = i; j < n; j++) {
                        System.out.printf("Ingrese el valor para la posición (%d, %d): ", i, j);
                        double valor = dato.nextDouble();
                        superior.setValor(i, j, valor);
                    }
                }

                System.out.println("Matriz Triangular Superior:");
                superior.mostrarMatriz();
            }
            case 3 -> {
                System.out.println("=== Matriz Tridiagonal ===");
                System.out.print("Ingrese el tamaño de la matriz: ");
                int n = dato.nextInt();
                MatrizTridiagonal tridiagonal = new MatrizTridiagonal(n);

                // Llenar la matriz tridiagonal
                for (int i = 0; i < n; i++) {
                    for (int d = -1; d <= 1; d++) {
                        if ((i + d >= 0) && (i + d < n)) {
                            System.out.printf("Ingrese el valor para la posición (%d, %d): ", i, i + d);
                            double valor = dato.nextDouble();
                            tridiagonal.setValor(i, d, valor);
                        }
                    }
                }

                System.out.println("Matriz Tridiagonal:");
                tridiagonal.mostrarMatriz();
            }
            case 4 -> {
                System.out.println("=== Matriz Simétrica ===");
                System.out.print("Ingrese el tamaño de la matriz: ");
                int n = dato.nextInt();
                MatrizSimetrica simetrica = new MatrizSimetrica(n);

                // Llenar la matriz simétrica
                for (int i = 0; i < n; i++) {
                    for (int j = i; j < n; j++) {
                        System.out.printf("Ingrese el valor para la posición (%d, %d): ", i, j);
                        double valor = dato.nextDouble();
                        simetrica.setValor(i, j, valor);
                    }
                }

                System.out.println("Matriz Simétrica:");
                simetrica.mostrarMatriz();
            }
            default -> System.out.println("Opción inválida.");
        }
    }
}
