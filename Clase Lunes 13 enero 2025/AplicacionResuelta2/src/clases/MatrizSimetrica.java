/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.Arrays;
/**
 *
 * @author daniel
 */
/**
 * Clase MatrizSimetrica
 * Representa una matriz simétrica y contiene las operaciones relacionadas.
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
public class MatrizSimetrica {
    private double[][] matriz;
    private int n; // Número de departamentos

    public MatrizSimetrica(int n) {
        this.n = n;
        matriz = new double[n][n];
    }

    // Establecer un valor en la posición [i][j] y [j][i]
    public void setValor(int i, int j, double valor) {
        if (i >= 0 && i < n && j >= 0 && j < n) {
            matriz[i][j] = valor;
            matriz[j][i] = valor; // Asegurar la simetría
        } else {
            throw new IllegalArgumentException("Índices fuera de rango.");
        }
    }

    // Obtener un valor de la posición [i][j]
    public double getValor(int i, int j) {
        if (i >= 0 && i < n && j >= 0 && j < n) {
            return matriz[i][j];
        } else {
            throw new IllegalArgumentException("Índices fuera de rango.");
        }
    }

    // Mostrar la matriz
    public void mostrarMatriz() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Validar que la matriz sea simétrica
    public boolean esSimetrica() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matriz[i][j] != matriz[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Calcular el presupuesto total
    public double calcularPresupuestoTotal() {
        double suma = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                suma += matriz[i][j];
            }
        }
        return suma;
    }

    // Clonar la matriz
    public MatrizSimetrica clonar() {
        MatrizSimetrica clon = new MatrizSimetrica(n);
        for (int i = 0; i < n; i++) {
            clon.matriz[i] = Arrays.copyOf(this.matriz[i], this.matriz[i].length);
        }
        return clon;
    }

    // Comparar dos matrices
    public boolean comparar(MatrizSimetrica otra) {
        if (this.n != otra.n) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (!Arrays.equals(this.matriz[i], otra.matriz[i])) {
                return false;
            }
        }
        return true;
    }

    // Fusionar dos matrices
    public void fusionar(MatrizSimetrica otra) {
        if (this.n != otra.n) {
            throw new IllegalArgumentException("Las matrices deben tener el mismo tamaño.");
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.matriz[i][j] += otra.matriz[i][j];
            }
        }
    }

    // Identificar el departamento con el mayor presupuesto interno
    public int obtenerMayorPresupuestoInterno() {
        int indice = 0;
        double max = matriz[0][0];
        for (int i = 1; i < n; i++) {
            if (matriz[i][i] > max) {
                max = matriz[i][i];
                indice = i;
            }
        }
        return indice + 1; // Retornar índice como departamento 1-based
    }

    // Identificar departamentos cuyo presupuesto interno supere un porcentaje del total
    public void mostrarDepartamentosConPresupuestoSuperior(double porcentaje) {
        double presupuestoTotal = calcularPresupuestoTotal();
        for (int i = 0; i < n; i++) {
            if (matriz[i][i] > (porcentaje / 100) * presupuestoTotal) {
                System.out.printf("Departamento %d supera el %.2f%% del presupuesto total%n", i + 1, porcentaje);
            }
        }
    }
}
