package model;

/**
 *
 * @author daniel
 */
public class NodoCola {

    Producto producto;
    NodoCola siguiente;

    public NodoCola(Producto producto) {
        this.producto = producto;
        this.siguiente = null;
    }
}
