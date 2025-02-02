package model;

/**
 *
 * @author daniel
 */
public class Nodo {

    public Tarea tarea;
    public Nodo siguiente;

    public Nodo(Tarea tarea) {
        this.tarea = tarea;
        this.siguiente = null;
    }
}
