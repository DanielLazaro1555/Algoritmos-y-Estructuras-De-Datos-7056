package clases;

/**
 *
 * @author daniel
 */
public class NodoArbol {

    private Producto producto;
    private NodoArbol izquierdo;
    private NodoArbol derecho;

    /**
     * Constructor del nodo del árbol.
     *
     * @param producto Producto que almacena este nodo.
     */
    public NodoArbol(Producto producto) {
        this.producto = producto;
        this.izquierdo = null;
        this.derecho = null;
    }

    // Getters y Setters
    public Producto getProducto() {
        return producto;
    }

    public NodoArbol getIzquierdo() {
        return izquierdo;
    }

    public NodoArbol getDerecho() {
        return derecho;
    }

    public void setIzquierdo(NodoArbol izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setDerecho(NodoArbol derecho) {
        this.derecho = derecho;
    }
}
