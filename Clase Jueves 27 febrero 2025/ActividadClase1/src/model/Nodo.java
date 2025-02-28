package model;

/**
 *
 * @author daniel
 */
public class Nodo {

    private Producto producto;  // Producto almacenado en el nodo
    private Nodo izquierdo;  // Referencia al hijo izquierdo
    private Nodo derecho;  // Referencia al hijo derecho
    private int altura;  // Altura del nodo (usada en AVL)

    /**
     * Constructor para inicializar un nodo con un producto.
     *
     * @param producto Producto a almacenar en el nodo.
     */
    public Nodo(Producto producto) {
        this.producto = producto;
        this.izquierdo = null;
        this.derecho = null;
        this.altura = 1; // Altura inicial para AVL
    }

    // Getters y Setters
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
