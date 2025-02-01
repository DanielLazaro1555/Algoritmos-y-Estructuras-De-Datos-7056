package clases;

/**
 *
 * @author daniel
 */
public class Nodo {

    private Empleado empleado;
    private Nodo siguiente;

    public Nodo(Empleado empleado) {
        this.empleado = empleado;
        this.siguiente = null;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
