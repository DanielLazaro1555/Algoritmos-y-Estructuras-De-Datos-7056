package model;

/**
 *
 * @author daniel
 */
import java.util.ArrayList;
import java.util.List;

public class Alumno {

    private String nombre;
    private int edad;
    private List<Double> calificaciones;

    public Alumno(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.calificaciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public List<Double> getCalificaciones() {
        return calificaciones;
    }

    public void agregarCalificacion(double calificacion) {
        calificaciones.add(calificacion);
    }

    public double calcularPromedio() {
        if (calificaciones.isEmpty()) {
            return 0;
        }
        double suma = 0;
        for (double cal : calificaciones) {
            suma += cal;
        }
        return suma / calificaciones.size();
    }
}
