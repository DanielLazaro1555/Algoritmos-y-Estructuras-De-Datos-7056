package model;

/**
 * Clase que representa una Tarea en el Sistema de Gestión de Tareas Pendientes.
 * Cada tarea tiene una descripción y un nivel de prioridad (Alta, Media, Baja).
 *
 * @author daniel
 */
public class Tarea {

    private String descripcion; // Descripción de la tarea
    private String prioridad;   // Prioridad de la tarea: Alta, Media, Baja

    /**
     * Constructor para crear una nueva tarea con una descripción y prioridad.
     *
     * @param descripcion Descripción de la tarea.
     * @param prioridad Nivel de prioridad de la tarea (Alta, Media, Baja).
     */
    public Tarea(String descripcion, String prioridad) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    /**
     * Obtiene la descripción de la tarea.
     *
     * @return La descripción de la tarea.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene el nivel de prioridad de la tarea.
     *
     * @return La prioridad de la tarea (Alta, Media, Baja).
     */
    public String getPrioridad() {
        return prioridad;
    }

    /**
     * Establece una nueva descripción para la tarea.
     *
     * @param descripcion La nueva descripción de la tarea.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Establece un nuevo nivel de prioridad para la tarea.
     *
     * @param prioridad La nueva prioridad de la tarea (Alta, Media, Baja).
     */
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
}
