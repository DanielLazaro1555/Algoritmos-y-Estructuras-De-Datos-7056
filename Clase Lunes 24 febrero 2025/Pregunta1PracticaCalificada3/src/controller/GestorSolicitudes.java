package controller;

import model.PilaSolicitudes;
import model.ColaSolicitudes;
import clases.Solicitud;
/**
 *
 * @author daniel
 */
/**
 * Clase que gestiona las operaciones de la pila y la cola.
 */
public class GestorSolicitudes {
    private PilaSolicitudes pila;
    private ColaSolicitudes cola;

    /**
     * Constructor del gestor de solicitudes.
     * Inicializa la pila y la cola.
     */
    public GestorSolicitudes() {
        this.pila = new PilaSolicitudes();
        this.cola = new ColaSolicitudes();
    }

    /**
     * Agrega una nueva solicitud a la pila.
     * @param nombreCliente Nombre del cliente.
     * @param descripcion Descripción de la solicitud.
     */
    public void agregarSolicitud(String nombreCliente, String descripcion) {
        Solicitud nuevaSolicitud = new Solicitud(nombreCliente, descripcion);
        pila.push(nuevaSolicitud);
    }

    /**
     * Transfiere la solicitud en la cima de la pila a la cola para su atención.
     */
    public void transferirSolicitud() {
        if (pila.isEmpty()) {
            System.out.println("⚠ No hay solicitudes en la pila para transferir.");
            return;
        }
        Solicitud solicitudTransferida = pila.pop();
        cola.enqueue(solicitudTransferida);
    }

    /**
     * Atiende la solicitud en el frente de la cola.
     */
    public void atenderSolicitud() {
        if (cola.isEmpty()) {
            System.out.println("⚠ No hay solicitudes en espera para atender.");
            return;
        }
        Solicitud solicitudAtendida = cola.dequeue();
        System.out.println("✅ Solicitud atendida con éxito: " + solicitudAtendida);
    }

    /**
     * Muestra el estado actual de la pila y la cola.
     */
    public void mostrarEstado() {
        System.out.println("\n📌 Estado actual de las solicitudes:");
        System.out.println("📥 Pila (Solicitudes registradas):");
        pila.mostrarPila();
        System.out.println("\n📤 Cola (Solicitudes en atención):");
        cola.mostrarCola();
        System.out.println();
    }
}