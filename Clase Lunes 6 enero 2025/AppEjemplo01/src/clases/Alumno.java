package clases;

/**
 * Clase Alumno
 * Representa a un alumno con su nombre, nota y calificación.
 * Calcula automáticamente la calificación basada en la nota ingresada.
 * 
 * @author daniel
 */
public class Alumno {
    
    // Atributos privados del alumno
    private String nombre;        // Nombre del alumno
    private double nota;          // Nota del alumno
    private String calificacion;  // Calificación obtenida en base a la nota

    /**
     * Constructor de la clase Alumno.
     * Inicializa el nombre, la nota y calcula automáticamente la calificación.
     * 
     * @param nombre Nombre del alumno
     * @param nota Nota del alumno
     */
    public Alumno(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
        this.calificacion = obtenerCalificacion(nota); // Calcula la calificación basada en la nota
    }

    /**
     * Método para obtener el nombre del alumno.
     * 
     * @return Nombre del alumno.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para obtener la nota del alumno.
     * 
     * @return Nota del alumno.
     */
    public double getNota() {
        return nota;
    }

    /**
     * Método para obtener la calificación del alumno.
     * 
     * @return Calificación del alumno (Sobresaliente, Notable, Bien, Suspenso).
     */
    public String getCalificacion() {
        return calificacion;
    }

    /**
     * Método privado para calcular la calificación en base a la nota.
     * 
     * @param nota Nota del alumno.
     * @return Calificación según el rango de la nota.
     */
    private String obtenerCalificacion(double nota) {
        // Validar el rango de la nota y asignar la calificación correspondiente
        if (nota >= 18 && nota <= 20) {
            return "Sobresaliente";
        } else if (nota >= 15 && nota < 18) {
            return "Notable";
        } else if (nota >= 11 && nota < 15) {
            return "Bien";
        } else if (nota >= 0 && nota < 11) { // Agregamos validación para notas negativas
            return "Suspenso";
        } else {
            return "Nota inválida"; // Manejo de caso para notas fuera de rango
        }
    }
}
