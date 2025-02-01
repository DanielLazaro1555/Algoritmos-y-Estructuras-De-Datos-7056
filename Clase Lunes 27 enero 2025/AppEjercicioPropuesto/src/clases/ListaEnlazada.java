package clases;

import java.util.HashSet;

/**
 *
 * @author daniel
 */
public class ListaEnlazada {

    private Nodo cabeza;
    private int size;
    private static final int MAX_PRODUCTOS = 50;
    private HashSet<String> nombresExistentes;

    public ListaEnlazada() {
        this.cabeza = null;
        this.size = 0;
        this.nombresExistentes = new HashSet<>();
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int getTamaño() {
        return size;
    }

    public void agregarProducto(Producto producto) {
        validarProducto(producto);

        Nodo nuevoNodo = new Nodo(producto);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        nombresExistentes.add(producto.getNombre());
        size++;
    }

    public void eliminarProducto(String nombre) {
        if (estaVacia()) {
            throw new IllegalStateException("La lista está vacía.");
        }

        if (cabeza.getProducto().getNombre().equalsIgnoreCase(nombre)) {
            cabeza = cabeza.getSiguiente();
            nombresExistentes.remove(nombre);
            size--;
            return;
        }

        Nodo actual = cabeza;
        while (actual.getSiguiente() != null
                && !actual.getSiguiente().getProducto().getNombre().equalsIgnoreCase(nombre)) {
            actual = actual.getSiguiente();
        }

        if (actual.getSiguiente() == null) {
            throw new IllegalArgumentException("Producto no encontrado.");
        }

        actual.setSiguiente(actual.getSiguiente().getSiguiente());
        nombresExistentes.remove(nombre);
        size--;
    }

    public void mostrarInventario() {
        if (estaVacia()) {
            System.out.println("El inventario está vacío.");
            return;
        }
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.println(actual.getProducto());
            actual = actual.getSiguiente();
        }
    }

    public Producto buscarProducto(String nombre) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.getProducto().getNombre().equalsIgnoreCase(nombre)) {
                return actual.getProducto();
            }
            actual = actual.getSiguiente();
        }
        throw new IllegalArgumentException("Producto no encontrado.");
    }

    public void ordenarPorPrecio() {
        if (estaVacia() || cabeza.getSiguiente() == null) {
            return;
        }

        for (Nodo i = cabeza; i.getSiguiente() != null; i = i.getSiguiente()) {
            for (Nodo j = i.getSiguiente(); j != null; j = j.getSiguiente()) {
                if (i.getProducto().getPrecio() > j.getProducto().getPrecio()) {
                    Producto temp = i.getProducto();
                    i.setSiguiente(j.getSiguiente());
                    j.setSiguiente(new Nodo(temp));
                }
            }
        }
    }

    private void validarProducto(Producto producto) {
        if (producto.getNombre() == null || producto.getNombre().length() < 3) {
            throw new IllegalArgumentException("El nombre debe tener al menos 3 caracteres.");
        }
        if (producto.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que 0.");
        }
        if (producto.getCantidad() < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        }
        if (nombresExistentes.contains(producto.getNombre())) {
            throw new IllegalArgumentException("Ya existe un producto con este nombre.");
        }
        if (size >= MAX_PRODUCTOS) {
            throw new IllegalStateException("No se pueden agregar más de " + MAX_PRODUCTOS + " productos.");
        }
    }
}
