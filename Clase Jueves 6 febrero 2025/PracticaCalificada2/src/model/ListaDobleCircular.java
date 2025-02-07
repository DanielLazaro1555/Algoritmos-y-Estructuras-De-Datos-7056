package model;

/**
 *
 * @author daniel
 */
public class ListaDobleCircular {

    private Nodo head;
    private int size;

    private class Nodo {

        Pedido pedido;
        Nodo siguiente;
        Nodo anterior;

        Nodo(Pedido pedido) {
            this.pedido = pedido;
        }
    }

    public ListaDobleCircular() {
        this.head = null;
        this.size = 0;
    }

    public void agregarPedido(Pedido pedido) {
        Nodo nuevo = new Nodo(pedido);

        if (head == null) { // Lista vacía
            head = nuevo;
            head.siguiente = head;
            head.anterior = head;
        } else if (pedido.getPrioridad().equals("VIP")) {
            // Insertar VIP al inicio
            Nodo ultimo = head.anterior;
            nuevo.siguiente = head;
            nuevo.anterior = ultimo;
            head.anterior = nuevo;
            ultimo.siguiente = nuevo;
            head = nuevo;
        } else {
            // Insertar al final
            Nodo ultimo = head.anterior;
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            nuevo.siguiente = head;
            head.anterior = nuevo;
        }

        size++;

        if (size > 10) {
            eliminarPedidoAntiguo();
        }
    }

    public void eliminarPedidoAntiguo() {
        if (head == null) {
            return;
        }
        System.out.println("Eliminando pedido más antiguo: " + head.pedido);

        if (head.siguiente == head) {
            head = null;
        } else {
            Nodo ultimo = head.anterior;
            head = head.siguiente;
            head.anterior = ultimo;
            ultimo.siguiente = head;
        }
        size--;
    }

    public Pedido buscarPedido(int codigo) {
        if (head == null) {
            return null;
        }
        Nodo actual = head;
        do {
            if (actual.pedido.getCodigoPedido() == codigo) {
                return actual.pedido;
            }
            actual = actual.siguiente;
        } while (actual != head);
        return null;
    }

    public void mostrarPedidos(boolean reverso) {
        if (head == null) {
            System.out.println("No hay pedidos.");
            return;
        }
        Nodo actual = reverso ? head.anterior : head; // 🔹 Reverso usa el último nodo, normal usa el primero
        do {
            System.out.println(actual.pedido);
            actual = reverso ? actual.anterior : actual.siguiente; // 🔹 Normal usa siguiente, inverso usa anterior
        } while (actual != (reverso ? head.anterior : head)); // 🔹 Verifica que el ciclo sea correcto
    }

}
