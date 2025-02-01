package model;

/**
 *
 * @author daniel
 */
public class Nodo {
    public Producto producto;
    public Nodo siguiente;

    public Nodo(Producto producto) {
        this.producto = producto;
        this.siguiente = null;
    }
}