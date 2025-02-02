package model;

/**
 * Clase que representa un Nodo en una lista enlazada para el Sistema de Gestión
 * de Tareas Pendientes. Cada nodo contiene una tarea y una referencia al
 * siguiente nodo en la lista.
 *
 * @author daniel
 */
public class Nodo {

    public Tarea tarea;    // La tarea almacenada en este nodo
    public Nodo siguiente; // Referencia al siguiente nodo en la lista enlazada

    /**
     * Constructor que inicializa el nodo con una tarea. La referencia al
     * siguiente nodo se establece como null por defecto.
     *
     * @param tarea La tarea que se va a almacenar en el nodo.
     */
    public Nodo(Tarea tarea) {
        this.tarea = tarea;
        this.siguiente = null;
    }
}
