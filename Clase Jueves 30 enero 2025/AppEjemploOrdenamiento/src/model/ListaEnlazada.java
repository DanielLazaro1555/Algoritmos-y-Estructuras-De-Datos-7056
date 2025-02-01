package model;

/**
 * Clase que representa una lista enlazada simple.
 * Permite agregar, imprimir y buscar elementos en la lista.
 * 
 * @author daniel
 */
public class ListaEnlazada {
    private Nodo cabeza;

    // Constructor para inicializar la lista vacía
    public ListaEnlazada() {
        this.cabeza = null;
    }

    // Getter para obtener la cabeza de la lista
    public Nodo getCabeza() {
        return cabeza;
    }

    // Setter para establecer la cabeza de la lista
    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    // Método para agregar un nuevo elemento al final de la lista
    public void agregar(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo; // Conexión del último nodo con el nuevo nodo
        }
    }

    // Método para imprimir la lista enlazada
    public void imprimirLista() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("Null");
    }

    // Método para buscar un valor en la lista enlazada
    public void buscar(int valor) {
        Nodo actual = cabeza;
        int posicion = 0;
        while (actual != null) {
            if (actual.dato == valor) {
                System.out.println("Elemento encontrado en la posición: " + posicion);
                return;
            }
            actual = actual.siguiente;
            posicion++;
        }
        System.out.println("Elemento no encontrado en la lista");
    }
}
