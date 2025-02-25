package model;

import clases.Solicitud;

/**
 *
 * @author daniel
 */
public class Nodo {

    private Solicitud solicitud;
    private Nodo siguiente;

    /**
     * Constructor de la clase Nodo.
     *
     * @param solicitud Objeto de tipo Solicitud que almacena la información.
     */
    public Nodo(Solicitud solicitud) {
        this.solicitud = solicitud;
        this.siguiente = null; // Inicialmente no apunta a ningún nodo
    }

    // Getters y Setters
    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
