package model;

import clases.Solicitud;

/**
 *
 * @author daniel
 */
public class ColaSolicitudes {

    private Nodo frente; // Nodo que está al inicio de la cola
    private Nodo finalCola; // Nodo que está al final de la cola

    /**
     * Constructor de la cola de solicitudes. Inicialmente la cola está vacía.
     */
    public ColaSolicitudes() {
        this.frente = null;
        this.finalCola = null;
    }

    /**
     * Método para agregar una nueva solicitud a la cola.
     *
     * @param solicitud La solicitud que se agregará a la cola.
     */
    public void enqueue(Solicitud solicitud) {
        Nodo nuevoNodo = new Nodo(solicitud);
        if (isEmpty()) {
            frente = nuevoNodo;
            finalCola = nuevoNodo;
        } else {
            finalCola.setSiguiente(nuevoNodo);
            finalCola = nuevoNodo;
        }
        System.out.println("✅ Solicitud agregada a la cola: " + solicitud);
    }

    /**
     * Método para atender la solicitud en el frente de la cola.
     *
     * @return La solicitud atendida o null si la cola está vacía.
     */
    public Solicitud dequeue() {
        if (isEmpty()) {
            System.out.println("⚠ No hay solicitudes en la cola.");
            return null;
        }
        Solicitud solicitud = frente.getSolicitud();
        frente = frente.getSiguiente();
        if (frente == null) {
            finalCola = null; // Si la cola queda vacía, finalCola también debe ser null
        }
        System.out.println("📤 Solicitud atendida: " + solicitud);
        return solicitud;
    }

    /**
     * Método para verificar si la cola está vacía.
     *
     * @return true si la cola está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return frente == null;
    }

    /**
     * Método para mostrar todas las solicitudes en la cola.
     */
    public void mostrarCola() {
        if (isEmpty()) {
            System.out.println("📭 La cola está vacía.");
            return;
        }
        System.out.println("📌 Solicitudes en la cola:");
        Nodo actual = frente;
        while (actual != null) {
            System.out.println("   🔹 " + actual.getSolicitud());
            actual = actual.getSiguiente();
        }
    }
}
