package model;

/**
 * Clase que representa una Tarea en el Sistema de Gestión de Tareas Pendientes.
 * Cada tarea tiene una descripción, un nivel de prioridad y un estado.
 *
 * Estados posibles: "Pendiente", "En Progreso", "Completada".
 *
 * @author daniel
 */
public class Tarea {

    private String descripcion; // Descripción de la tarea
    private String prioridad;   // Prioridad de la tarea: Alta, Media, Baja
    private String estado;      // Estado de la tarea: Pendiente, En Progreso, Completada

    /**
     * Constructor para crear una nueva tarea con una descripción y prioridad.
     * La tarea inicia con estado "Pendiente".
     *
     * @param descripcion Descripción de la tarea.
     * @param prioridad Nivel de prioridad de la tarea (Alta, Media, Baja).
     */
    public Tarea(String descripcion, String prioridad) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = "Pendiente"; // Todas las tareas inician como Pendiente
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
     * Obtiene el estado actual de la tarea.
     *
     * @return El estado de la tarea (Pendiente, En Progreso, Completada).
     */
    public String getEstado() {
        return estado;
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

    /**
     * Establece un nuevo estado para la tarea.
     *
     * @param estado El nuevo estado de la tarea (Pendiente, En Progreso,
     * Completada).
     */
    public void setEstado(String estado) {
        if (estado.equals("Pendiente") || estado.equals("En Progreso") || estado.equals("Completada")) {
            this.estado = estado;
        } else {
            System.out.println("⚠️  Estado inválido. Debe ser Pendiente, En Progreso o Completada.");
        }
    }
}
