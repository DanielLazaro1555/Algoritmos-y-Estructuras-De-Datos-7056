package model;

/**
 *
 * @author daniel
 */
/**
 * Clase que representa un nodo en los árboles ABB y AVL. Contiene un usuario y
 * referencias a los nodos izquierdo y derecho.
 */
public class Nodo {

    private Usuario usuario; // Usuario almacenado en el nodo
    private Nodo izquierdo; // Referencia al hijo izquierdo
    private Nodo derecho; // Referencia al hijo derecho
    private int altura; // Altura del nodo (usada en AVL)

    /**
     * Constructor para inicializar un nodo con un usuario.
     *
     * @param usuario Usuario a almacenar en el nodo.
     */
    public Nodo(Usuario usuario) {
        this.usuario = usuario;
        this.izquierdo = null;
        this.derecho = null;
        this.altura = 1; // Altura inicial para AVL
    }

    // Getters y Setters
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
