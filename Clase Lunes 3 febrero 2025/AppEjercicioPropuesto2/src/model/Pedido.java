package model;

/**
 * Clase que representa un pedido en el restaurante. Cada pedido tiene un ID
 * único, nombre del cliente, número de mesa, plato y estado.
 *
 * Estados posibles: "Pendiente", "En preparación", "Listo para servir"
 *
 * @author Daniel
 */
public class Pedido {

    private int idPedido;
    private String nombreCliente;
    private int mesa;
    private String plato;
    private String estado;  // "Pendiente", "En preparación", "Listo para servir"

    /**
     * Constructor para crear un nuevo pedido.
     *
     * @param idPedido ID único del pedido
     * @param nombreCliente Nombre del cliente
     * @param mesa Número de mesa (1-20)
     * @param plato Plato solicitado
     */
    public Pedido(int idPedido, String nombreCliente, int mesa, String plato) {
        this.idPedido = idPedido;
        this.nombreCliente = nombreCliente;
        this.mesa = mesa;
        this.plato = plato;
        this.estado = "Pendiente";  // Estado inicial por defecto
    }

    // ✅ Getters
    public int getIdPedido() {
        return idPedido;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public int getMesa() {
        return mesa;
    }

    public String getPlato() {
        return plato;
    }

    public String getEstado() {
        return estado;
    }

    // ✅ Setters
    public void setMesa(int mesa) {
        if (mesa >= 1 && mesa <= 20) {
            this.mesa = mesa;
        } else {
            System.out.println("⚠️  Error: La mesa debe estar entre 1 y 20.");
        }
    }

    public void setNombreCliente(String nombreCliente) {
        if (nombreCliente != null && !nombreCliente.trim().isEmpty()) {
            this.nombreCliente = nombreCliente;
        } else {
            System.out.println("⚠️  Error: El nombre del cliente no puede estar vacío.");
        }
    }

    public void setEstado(String estado) {
        if (estado.equals("Pendiente") || estado.equals("En preparación") || estado.equals("Listo para servir")) {
            this.estado = estado;
        } else {
            System.out.println("⚠️  Error: Estado inválido. Los estados permitidos son: 'Pendiente', 'En preparación', 'Listo para servir'.");
        }
    }
}
