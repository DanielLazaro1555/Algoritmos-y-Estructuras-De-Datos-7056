package model;

/**
 *
 * @author daniel
 */
public class NodoPila {

    Producto producto;
    NodoPila siguiente;

    public NodoPila(Producto producto) {
        this.producto = producto;
        this.siguiente = null;
    }
}
