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
 * Clase MatrizDesempeño
 Representa una matriz triangular inferior para almacenar indicadores de desempeño.
 * 1. En una organización, cada equipo de trabajo es evaluado en función de varios indicadores de desempeño en
diferentes proyectos. Esta información se organiza en una matriz triangular inferior, donde cada fila representa
un proyecto y las columnas corresponden a los indicadores evaluados.
El programa debe permitir:
• Ingresar por teclado los puntajes de desempeño para cada proyecto. Los valores deben estar en el rango de
0 a 100.
• Validar que cada valor ingresado esté dentro del rango especificado. Si no lo está, solicitar nuevamente el
ingreso del dato.
• Crear una copia de la matriz para realizar simulaciones sin alterar los datos originales.
• Verificar si dos matrices de desempeño son iguales.
• Combinar los datos de dos matrices de desempeño sumando los valores correspondientes.
• Calcular y mostrar el promedio global del desempeño, pero únicamente considerando los proyectos cuyo
desempeño total (suma de sus valores) supere un umbral especificado por el usuario.
• Identificar y mostrar el proyecto con el mayor desempeño total.
• Validar que todos los datos ingresados estén completos antes de realizar cualquier operación adicional.
 */
public class MatrizDesempeño {
    private int[][] matriz;
    private int numProyectos;

    public MatrizDesempeño(int numProyectos) {
        this.numProyectos = numProyectos;
        matriz = new int[numProyectos][];
        for (int i = 0; i < numProyectos; i++) {
            matriz[i] = new int[i + 1]; // Cada fila tiene i+1 columnas
        }
    }

    public int getNumProyectos() {
        return numProyectos;
    }

    public void ingresarDato(int fila, int columna, int valor) {
        if (valor < 0 || valor > 100) {
            throw new IllegalArgumentException("El valor debe estar entre 0 y 100.");
        }
        matriz[fila][columna] = valor;
    }

    public int obtenerDato(int fila, int columna) {
        return matriz[fila][columna];
    }

    public void mostrarMatriz() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public MatrizDesempeño clonar() {
        MatrizDesempeño clon = new MatrizDesempeño(numProyectos);
        for (int i = 0; i < numProyectos; i++) {
            clon.matriz[i] = Arrays.copyOf(matriz[i], matriz[i].length);
        }
        return clon;
    }

    public boolean comparar(MatrizDesempeño otraMatriz) {
        if (this.numProyectos != otraMatriz.numProyectos) {
            return false;
        }
        for (int i = 0; i < numProyectos; i++) {
            if (!Arrays.equals(this.matriz[i], otraMatriz.matriz[i])) {
                return false;
            }
        }
        return true;
    }

    public void combinar(MatrizDesempeño otraMatriz) {
        if (this.numProyectos != otraMatriz.numProyectos) {
            throw new IllegalArgumentException("Las matrices deben tener el mismo tamaño.");
        }
        for (int i = 0; i < numProyectos; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                this.matriz[i][j] += otraMatriz.matriz[i][j];
            }
        }
    }

    public double calcularPromedioUmbral(int umbral) {
        double suma = 0;
        int proyectosValidos = 0;

        for (int i = 0; i < numProyectos; i++) {
            int sumaProyecto = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                sumaProyecto += matriz[i][j];
            }
            if (sumaProyecto > umbral) {
                suma += sumaProyecto;
                proyectosValidos++;
            }
        }

        return proyectosValidos > 0 ? suma / proyectosValidos : 0;
    }

    public int obtenerProyectoConMayorDesempeno() {
        int indiceMejor = -1;
        int mejorSuma = -1;

        for (int i = 0; i < numProyectos; i++) {
            int sumaProyecto = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                sumaProyecto += matriz[i][j];
            }
            if (sumaProyecto > mejorSuma) {
                mejorSuma = sumaProyecto;
                indiceMejor = i;
            }
        }

        return indiceMejor + 1; // Se retorna el índice +1 para mostrar al usuario
    }
}
