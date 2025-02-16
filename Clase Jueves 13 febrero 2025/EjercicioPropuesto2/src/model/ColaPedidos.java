package model;

/**
 *
 * @author daniel
 */
public class ColaPedidos {

    private NodoCola frente, fin;
    private int tamaño;

    public ColaPedidos() {
        this.frente = this.fin = null;
        this.tamaño = 0;
    }

    public void encolar(Producto producto) {
        NodoCola nuevo = new NodoCola(producto);
        if (fin == null) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
        tamaño++;
    }

    public Producto desencolar() {
        if (frente == null) {
            return null;
        }
        Producto atendido = frente.producto;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        tamaño--;
        return atendido;
    }

    public void mostrarCola() {
        NodoCola actual = frente;
        System.out.println("=== Pedidos Pendientes ===");
        while (actual != null) {
            System.out.println(actual.producto);
            actual = actual.siguiente;
        }
    }

    public int contarPedidos() {
        return tamaño;
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }
}
