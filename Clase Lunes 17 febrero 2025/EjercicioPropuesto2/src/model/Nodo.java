package model;

/**
 *
 * @author daniel
 */
public class Nodo {
    Empleado empleado;
    Nodo izquierdo; // Subordinado izquierdo
    Nodo derecho; // Subordinado derecho

    public Nodo(Empleado empleado) {
        this.empleado = empleado;
        this.izquierdo = null;
        this.derecho = null;
    }
}
