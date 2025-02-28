package model;

/**
 *
 * @author daniel
 */
public class Nodo {

    int dato;
    Nodo izquierda, derecha;

    public Nodo(int dato) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
    }
    
}
