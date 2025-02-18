package model;

/**
 *
 * @author daniel
 */
public class Nodo {
    public int dato;
    public Nodo izquierdo,derecho;
    
    public Nodo(int dato){
        this.dato = dato;
        this.izquierdo = this.derecho = null;
    }
    
}
