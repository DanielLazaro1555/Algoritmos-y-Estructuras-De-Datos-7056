package controller;

import model.ListaDobleCircular;
import model.Pedido;

/**
 *
 * @author daniel
 */
public class GestorPedidos {

    private ListaDobleCircular listaPedidos;

    public GestorPedidos() {
        this.listaPedidos = new ListaDobleCircular();
    }

    public void agregarPedido(String nombre, String prioridad) {
        Pedido nuevoPedido = new Pedido(nombre, prioridad);
        listaPedidos.agregarPedido(nuevoPedido);
        System.out.println("Pedido agregado: " + nuevoPedido);
    }

    public void entregarPedido() {
        listaPedidos.eliminarPedidoAntiguo();
    }

    public void buscarPedido(int codigo) {
        Pedido pedido = listaPedidos.buscarPedido(codigo);
        if (pedido != null) {
            System.out.println("Pedido encontrado: " + pedido);
        } else {
            System.out.println("Pedido no encontrado.");
        }
    }

    public void mostrarPedidos(boolean reverso) {
        System.out.println(reverso ? "Pedidos en orden inverso:" : "Pedidos en orden normal:");
        listaPedidos.mostrarPedidos(reverso);
    }
}
