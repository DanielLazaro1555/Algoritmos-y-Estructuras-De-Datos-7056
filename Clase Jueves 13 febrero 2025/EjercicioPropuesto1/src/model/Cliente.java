package model;

/**
 *
 * @author daniel
 */
public class Cliente {

    private String nombre;
    private int ticket;
    private boolean esVIP;

    public Cliente(String nombre, int ticket, boolean esVIP) {
        this.nombre = nombre;
        this.ticket = ticket;
        this.esVIP = esVIP;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTicket() {
        return ticket;
    }

    public boolean esVIP() {
        return esVIP;
    }

    @Override
    public String toString() {
        return "Cliente{"
                + "nombre='" + nombre + '\''
                + ", ticket=" + ticket
                + ", tipo=" + (esVIP ? "VIP" : "Regular")
                + '}';
    }
}
