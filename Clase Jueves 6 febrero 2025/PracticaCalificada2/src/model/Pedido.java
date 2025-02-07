package model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa un pedido en la cafetería. Cada pedido tiene un código
 * único, nombre del cliente, hora de ingreso y prioridad (Normal/VIP).
 *
 * @author Daniel
 */
public class Pedido {

    private static int contador = 1;
    private int codigoPedido;
    private String nombreCliente;
    private String horaIngreso;
    private String prioridad;

    public Pedido(String nombreCliente, String prioridad) {
        this.codigoPedido = contador++;
        this.nombreCliente = nombreCliente;
        this.horaIngreso = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss a")); // ✅ Ahora con AM/PM
        this.prioridad = prioridad;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getHoraIngreso() {  // ✅ Cambiado para devolver un String
        return horaIngreso;
    }

    public String getPrioridad() {
        return prioridad;
    }

    @Override
    public String toString() {
        return "Pedido [Código=" + codigoPedido + ", Cliente=" + nombreCliente
                + ", Hora=" + horaIngreso + ", Prioridad=" + prioridad + "]";
    }
}
