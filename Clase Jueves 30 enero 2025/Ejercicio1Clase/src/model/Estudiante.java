package model;

/**
 *
 * @author daniel
 */
public class Estudiante {

    private String nombre;
    private int[] calificaciones;
    private double promedio;

    public Estudiante(String nombre, int[] calificaciones) {
        this.nombre = nombre;
        this.calificaciones = calificaciones;
        this.promedio = calcularPromedio();
    }

    private double calcularPromedio() {
        int suma = 0;
        for (int nota : calificaciones) {
            suma += nota;
        }
        return (double) suma / calificaciones.length;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPromedio() {
        return promedio;
    }

    public int[] getCalificaciones() {
        return calificaciones;
    }
}
