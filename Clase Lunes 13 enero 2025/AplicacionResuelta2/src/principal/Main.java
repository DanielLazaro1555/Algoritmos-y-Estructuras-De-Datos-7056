/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;

import clases.MatrizSimetrica;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
/**
 * Clase principal Main
 * Permite interactuar con la matriz de presupuesto.
 * 2. Una empresa gestiona su presupuesto de manera colaborativa entre departamentos, registrando el
presupuesto compartido en una matriz simétrica. Cada celda [i][j] indica el presupuesto compartido entre los
departamentos 𝑖 y 𝑗. La diagonal principal [i][i] refleja el presupuesto interno de cada departamento.
El programa debe permitir:
• Ingresar por teclado los valores de la matriz de presupuesto.
• Validar que los datos ingresados mantengan la simetría de la matriz. Si no es simétrica, solicitar las
correcciones necesarias.
• Verificar que el presupuesto total (suma de todos los valores de la matriz) no exceda un límite especificado
por el usuario. Si se supera, mostrar una advertencia.
• Implementar las siguientes operaciones:
• Clonación: Crear una copia de la matriz para respaldo antes de realizar modificaciones.
• Comparación: Comprobar si dos matrices de presupuesto son iguales.
• Fusión: Combinar dos matrices sumando sus valores correspondientes.
• Identificar y mostrar:
• El departamento con el mayor presupuesto compartido con los demás.
• Los departamentos cuyo presupuesto interno es mayor a un porcentaje especificado del presupuesto total.
 */
public class Main {

    public static void main(String[] args) {
        Scanner dato = new Scanner(System.in);

        System.out.print("Ingrese el número de departamentos: ");
        int n = dato.nextInt();
        MatrizSimetrica matriz = new MatrizSimetrica(n);

        // Ingreso de datos
        System.out.println("Ingrese los valores de la matriz de presupuesto:");
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                System.out.printf("Ingrese el presupuesto compartido entre departamento %d y %d: ", i + 1, j + 1);
                double valor = dato.nextDouble();
                matriz.setValor(i, j, valor);
            }
        }

        // Validar simetría
        if (!matriz.esSimetrica()) {
            System.out.println("La matriz no es simétrica. Corrija los valores.");
            return;
        }

        // Mostrar matriz
        System.out.println("\n=== Matriz de Presupuesto ===");
        matriz.mostrarMatriz();

        // Calcular presupuesto total
        double total = matriz.calcularPresupuestoTotal();
        System.out.printf("\nPresupuesto total: %.2f%n", total);

        // Verificar límite de presupuesto
        System.out.print("Ingrese el límite de presupuesto: ");
        double limite = dato.nextDouble();
        if (total > limite) {
            System.out.println("Advertencia: El presupuesto total supera el límite especificado.");
        }

        // Clonar matriz
        MatrizSimetrica clon = matriz.clonar();
        System.out.println("\n=== Clonación de la Matriz ===");
        clon.mostrarMatriz();

        // Comparar matrices
        System.out.println("\n¿La matriz original y el clon son iguales? " + (matriz.comparar(clon) ? "Sí" : "No"));

        // Identificar el mayor presupuesto interno
        int mejorDepartamento = matriz.obtenerMayorPresupuestoInterno();
        System.out.printf("El departamento con mayor presupuesto interno es el %d.%n", mejorDepartamento);

        // Identificar departamentos con presupuesto interno superior a un porcentaje
        System.out.print("Ingrese el porcentaje del presupuesto total para filtrar departamentos: ");
        double porcentaje = dato.nextDouble();
        matriz.mostrarDepartamentosConPresupuestoSuperior(porcentaje);
    }
}
