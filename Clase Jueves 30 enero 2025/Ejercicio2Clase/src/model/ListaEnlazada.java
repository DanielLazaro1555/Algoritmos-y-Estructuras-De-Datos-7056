package model;

/**
 *
 * @author daniel
 */
public class ListaEnlazada {

    private Nodo cabeza;

    public Nodo getCabeza() {
        return cabeza;
    }

    public void agregar(Producto producto) {
        Nodo nuevo = new Nodo(producto);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    public boolean eliminar(String nombre) {
        Nodo actual = cabeza;
        Nodo anterior = null;

        while (actual != null) {
            if (actual.producto.getNombre().equalsIgnoreCase(nombre)) {
                if (anterior == null) {
                    cabeza = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                return true;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        return false;
    }

    public Producto buscar(String nombre) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.producto.getNombre().equalsIgnoreCase(nombre)) {
                return actual.producto;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public void ordenarPorPrecio() {
        if (cabeza == null || cabeza.siguiente == null) {
            return;
        }

        Nodo actual = cabeza;
        while (actual != null) {
            Nodo min = actual;
            Nodo temp = actual.siguiente;
            while (temp != null) {
                if (temp.producto.getPrecio() < min.producto.getPrecio()) {
                    min = temp;
                }
                temp = temp.siguiente;
            }
            Producto aux = actual.producto;
            actual.producto = min.producto;
            min.producto = aux;

            actual = actual.siguiente;
        }
    }

    public void mostrarInventario() {
        Nodo actual = cabeza;
        if (actual == null) {
            System.out.println("No hay productos en el inventario.");
            return;
        }

        System.out.println("=== Inventario ===");
        while (actual != null) {
            Producto p = actual.producto;
            System.out.println("Nombre: " + p.getNombre() + ", Precio: $" + p.getPrecio() + ", Cantidad: " + p.getCantidad());
            actual = actual.siguiente;
        }
    }
}
