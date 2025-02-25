package model;

import clases.Solicitud;

/**
 *
 * @author daniel
 */
public class PilaSolicitudes {

    private Nodo top; // Última solicitud ingresada en la pila

    /**
     * Constructor de la pila de solicitudes. Inicialmente la pila está vacía.
     */
    public PilaSolicitudes() {
        this.top = null;
    }

    /**
     * Método para agregar una nueva solicitud a la pila.
     *
     * @param solicitud La solicitud que se agregará.
     */
    public void push(Solicitud solicitud) {
        Nodo nuevoNodo = new Nodo(solicitud);
        nuevoNodo.setSiguiente(top); // El nuevo nodo apunta al nodo que estaba en la cima
        top = nuevoNodo; // Se actualiza la cima de la pila
        System.out.println("✅ Solicitud agregada a la pila: " + solicitud);
    }

    /**
     * Método para extraer la solicitud en la cima de la pila.
     *
     * @return La solicitud eliminada o null si la pila está vacía.
     */
    public Solicitud pop() {
        if (isEmpty()) {
            System.out.println("⚠ No hay solicitudes en la pila.");
            return null;
        }
        Solicitud solicitud = top.getSolicitud(); // Obtener la solicitud de la cima
        top = top.getSiguiente(); // Mover la cima al siguiente nodo
        System.out.println("📤 Solicitud transferida: " + solicitud);
        return solicitud;
    }

    /**
     * Método para verificar si la pila está vacía.
     *
     * @return true si la pila está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Método para mostrar todas las solicitudes en la pila.
     */
    public void mostrarPila() {
        if (isEmpty()) {
            System.out.println("📭 La pila está vacía.");
            return;
        }
        System.out.println("📌 Solicitudes en la pila:");
        Nodo actual = top;
        while (actual != null) {
            System.out.println("   🔹 " + actual.getSolicitud());
            actual = actual.getSiguiente();
        }
    }
}
