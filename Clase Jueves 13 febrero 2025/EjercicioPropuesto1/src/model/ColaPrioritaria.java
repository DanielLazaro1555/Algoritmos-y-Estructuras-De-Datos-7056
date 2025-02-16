package model;

/**
 *
 * @author daniel
 */
public class ColaPrioritaria {

    private Nodo inicioVIP, finVIP;
    private Nodo inicioRegular, finRegular;
    private int tamaño;

    public ColaPrioritaria() {
        this.inicioVIP = this.finVIP = null;
        this.inicioRegular = this.finRegular = null;
        this.tamaño = 0;
    }

    public void encolar(Cliente cliente) {
        Nodo nuevo = new Nodo(cliente);
        if (cliente.esVIP()) {
            if (inicioVIP == null) {
                inicioVIP = finVIP = nuevo;
            } else {
                finVIP.siguiente = nuevo;
                finVIP = nuevo;
            }
        } else {
            if (inicioRegular == null) {
                inicioRegular = finRegular = nuevo;
            } else {
                finRegular.siguiente = nuevo;
                finRegular = nuevo;
            }
        }
        tamaño++;
    }

    public Cliente desencolar() {
        if (inicioVIP != null) {
            Cliente cliente = inicioVIP.cliente;
            inicioVIP = inicioVIP.siguiente;
            if (inicioVIP == null) {
                finVIP = null;
            }
            tamaño--;
            return cliente;
        } else if (inicioRegular != null) {
            Cliente cliente = inicioRegular.cliente;
            inicioRegular = inicioRegular.siguiente;
            if (inicioRegular == null) {
                finRegular = null;
            }
            tamaño--;
            return cliente;
        }
        return null;
    }

    public Cliente verSiguiente() {
        return (inicioVIP != null) ? inicioVIP.cliente : (inicioRegular != null) ? inicioRegular.cliente : null;
    }

    public void mostrarCola() {
        System.out.println("Clientes en espera:");
        Nodo actual = inicioVIP;
        while (actual != null) {
            System.out.println(actual.cliente);
            actual = actual.siguiente;
        }
        actual = inicioRegular;
        while (actual != null) {
            System.out.println(actual.cliente);
            actual = actual.siguiente;
        }
    }

    public int contarClientes() {
        return tamaño;
    }

    public void vaciarCola() {
        inicioVIP = finVIP = null;
        inicioRegular = finRegular = null;
        tamaño = 0;
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }
}
