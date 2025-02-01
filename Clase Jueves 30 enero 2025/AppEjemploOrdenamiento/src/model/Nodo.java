package model;

/**
 * Clase que representa un nodo en una lista enlazada simple.
 * Cada nodo contiene un dato y una referencia al siguiente nodo.
 * 
 * @author daniel
 */
public class Nodo {
    public int dato;       // Valor almacenado en el nodo
    public Nodo siguiente; // Referencia al siguiente nodo en la lista

    /**
     * Constructor para crear un nuevo nodo con un dato específico.
     * Inicializa la referencia al siguiente nodo como null.
     * 
     * @param dato el valor que se almacenará en el nodo
     */
    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
