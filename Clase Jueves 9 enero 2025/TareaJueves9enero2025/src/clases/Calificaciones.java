package clases;

import java.util.Arrays;

/**
 * Clase para gestionar un conjunto de calificaciones.
 */
public class Calificaciones {
    private final int[] calificaciones; // Array para almacenar las calificaciones
    private int totalCalificaciones; // Número de calificaciones registradas

    // Constructor para inicializar con capacidad dinámica
    public Calificaciones(int capacidad) {
        this.calificaciones = new int[capacidad];
        this.totalCalificaciones = 0;
    }

    // Método para agregar una calificación
    public boolean agregar(int calificacion) {
        if (totalCalificaciones < calificaciones.length) {
            calificaciones[totalCalificaciones++] = calificacion;
            return true;
        }
        return false;
    }

    // Método para buscar una calificación y devolver su índice
    public int buscarCalificacion(int calificacion) {
        for (int i = 0; i < totalCalificaciones; i++) {
            if (calificaciones[i] == calificacion) {
                return i; // Devolver índice si se encuentra
            }
        }
        return -1; // Si no se encuentra, devolver -1
    }

    // Método para ordenar las calificaciones en orden ascendente
    public void ordenarCalificaciones() {
        Arrays.sort(calificaciones, 0, totalCalificaciones); // Ordenar solo los elementos válidos
    }

    // Método para mostrar las calificaciones ordenadas
    public void mostrarOrdenadas() {
        ordenarCalificaciones(); // Ordenamos antes de mostrar
        System.out.println("Calificaciones Ordenadas:");
        for (int i = 0; i < totalCalificaciones; i++) {
            System.out.println("Índice: " + i + " - Calificación: " + calificaciones[i]);
        }
    }

    // Método para actualizar una calificación
    public boolean actualizar(int indice, int nuevoValor) {
        if (indice >= 0 && indice < totalCalificaciones) {
            calificaciones[indice] = nuevoValor;
            return true;
        }
        return false;
    }

    // Método para eliminar una calificación
    public boolean eliminar(int indice) {
        if (indice >= 0 && indice < totalCalificaciones) {
            // Desplazamos las calificaciones a la izquierda para llenar el hueco
            for (int i = indice; i < totalCalificaciones - 1; i++) {
                calificaciones[i] = calificaciones[i + 1];
            }
            totalCalificaciones--; // Reducimos el contador de calificaciones
            return true;
        }
        return false;
    }

    // Método para mostrar las estadísticas básicas
    public void mostrarEstadisticas() {
        if (totalCalificaciones == 0) {
            System.out.println("No hay calificaciones registradas.");
            return;
        }

        // Cálculo de estadísticas
        int suma = Arrays.stream(calificaciones, 0, totalCalificaciones).sum();
        int max = Arrays.stream(calificaciones, 0, totalCalificaciones).max().orElse(Integer.MIN_VALUE);
        int min = Arrays.stream(calificaciones, 0, totalCalificaciones).min().orElse(Integer.MAX_VALUE);
        double promedio = (double) suma / totalCalificaciones;

        // Mostrar estadísticas
        System.out.println("Estadísticas:");
        System.out.println("Promedio: " + promedio);
        System.out.println("Calificación Máxima: " + max);
        System.out.println("Calificación Mínima: " + min);
    }

    // Método para mostrar las calificaciones actuales
    public void mostrar() {
        System.out.println("Calificaciones actuales:");
        for (int i = 0; i < totalCalificaciones; i++) {
            System.out.println("Índice: " + i + " - Calificación: " + calificaciones[i]);
        }
    }
}
