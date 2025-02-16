package model;

/**
 *
 * @author daniel
 */
public class PilaInventario {

    private NodoPila tope;
    private int tamaño;

    public PilaInventario() {
        this.tope = null;
        this.tamaño = 0;
    }

    public void push(Producto producto) {
        NodoPila nuevo = new NodoPila(producto);
        nuevo.siguiente = tope;
        tope = nuevo;
        tamaño++;
    }

    public Producto pop() {
        if (tope == null) {
            return null;
        }
        Producto eliminado = tope.producto;
        tope = tope.siguiente;
        tamaño--;
        return eliminado;
    }

    public Producto peek() {
        return (tope != null) ? tope.producto : null;
    }

    public void mostrarInventario() {
        NodoPila actual = tope;
        System.out.println("=== Inventario ===");
        while (actual != null) {
            System.out.println(actual.producto);
            actual = actual.siguiente;
        }
    }

    public int contarProductos() {
        return tamaño;
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }
}
