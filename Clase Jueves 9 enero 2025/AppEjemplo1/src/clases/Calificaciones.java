package clases;

import java.util.Arrays; // Importamos la clase Arrays para trabajar con arrays fácilmente

/**
 * Clase para gestionar un conjunto de calificaciones.
 * Proporciona métodos para agregar, actualizar, eliminar, mostrar calificaciones
 * y calcular estadísticas básicas como promedio, máximo y mínimo.
 * 
 * @author daniel
 */
public class Calificaciones {
    private final int[] calificaciones; // Array para almacenar las calificaciones
    private int totalCalificaciones; // Contador para rastrear cuántas calificaciones han sido ingresadas
    
    /**
     * Constructor que inicializa el array con una capacidad fija.
     * 
     * @param capacidad Número máximo de calificaciones que se pueden almacenar.
     */
    public Calificaciones(int capacidad) {
        this.calificaciones = new int[capacidad]; // Inicializamos el array con la capacidad indicada
        this.totalCalificaciones = 0; // Inicializamos el contador de calificaciones en 0
    }
    
    /**
     * Agrega una calificación al array si hay espacio disponible.
     * 
     * @param calificacion La calificación a agregar.
     * @return true si se pudo agregar, false si no hay espacio.
     */
    public boolean agregar(int calificacion) {
        if (totalCalificaciones < calificaciones.length) { // Verificamos si hay espacio
            calificaciones[totalCalificaciones++] = calificacion; // Agregamos la calificación y aumentamos el contador
            return true;
        }
        return false; // Retornamos false si no hay espacio disponible
    }
    
    /**
     * Actualiza una calificación en un índice específico.
     * 
     * @param indice Índice de la calificación a actualizar.
     * @param nuevoValor Nuevo valor de la calificación.
     * @return true si se pudo actualizar, false si el índice no es válido.
     */
    public boolean actualizar(int indice, int nuevoValor) {
        if (indice >= 0 && indice < totalCalificaciones) { // Verificamos si el índice es válido
            calificaciones[indice] = nuevoValor; // Actualizamos la calificación
            return true;
        }
        return false; // Retornamos false si el índice no es válido
    }
    
    /**
     * Elimina una calificación en un índice específico y reorganiza el array.
     * 
     * @param indice Índice de la calificación a eliminar.
     * @return true si se pudo eliminar, false si el índice no es válido.
     */
    public boolean eliminar(int indice) {
        if (indice >= 0 && indice < totalCalificaciones) { // Verificamos si el índice es válido
            // Desplazamos las calificaciones hacia la izquierda para llenar el hueco
            for (int i = indice; i < totalCalificaciones - 1; i++) {
                calificaciones[i] = calificaciones[i + 1];
            }
            calificaciones[--totalCalificaciones] = 0; // Reducimos el contador y limpiamos el último elemento
            return true;
        }
        return false; // Retornamos false si el índice no es válido
    }
    
    /**
     * Muestra todas las calificaciones almacenadas actualmente.
     */
    public void mostrar() {
        System.out.println("Calificaciones Actuales:");
        for (int i = 0; i < totalCalificaciones; i++) {
            System.out.println("Índice: " + i + ": " + calificaciones[i]); // Mostramos índice y calificación
        }
    }
    
    /**
     * Calcula y muestra estadísticas básicas: promedio, máximo y mínimo.
     */
    public void mostrarEstadisticas() {
        if (totalCalificaciones == 0) { // Verificamos si hay calificaciones registradas
            System.out.println("No hay calificaciones registradas");
            return;
        }
        // Calculamos la suma, el máximo y el mínimo usando streams
        int suma = Arrays.stream(calificaciones, 0, totalCalificaciones).sum();
        int max = Arrays.stream(calificaciones, 0, totalCalificaciones).max().orElse(Integer.MIN_VALUE);
        int min = Arrays.stream(calificaciones, 0, totalCalificaciones).min().orElse(Integer.MAX_VALUE);
        
        // Calculamos el promedio
        double promedio = (double) suma / totalCalificaciones;
        
        // Mostramos las estadísticas
        System.out.println("Estadísticas:");
        System.out.println("Promedio: " + promedio);
        System.out.println("Calificación Máxima: " + max);
        System.out.println("Calificación Mínima: " + min);
    }
}
