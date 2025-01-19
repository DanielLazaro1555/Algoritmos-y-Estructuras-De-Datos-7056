package clases;

import java.util.Arrays;
/**
 *
 * @author daniel
 */
/**
 * Clase que gestiona el inventario de productos.
 */
public class Inventario {
    private Producto[] productos;
    private int totalProductos;

    public Inventario() {
        this.productos = new Producto[10]; // Capacidad inicial de 10 productos
        this.totalProductos = 0;
    }

    // Agregar un producto al inventario
    public boolean agregarProducto(Producto producto) {
        if (totalProductos < productos.length) {
            productos[totalProductos++] = producto;
            return true;
        }
        return false; // Inventario lleno
    }

    // Actualizar un producto existente
    public boolean actualizarProducto(int indice, Producto producto) {
        if (indice >= 0 && indice < totalProductos) {
            productos[indice] = producto;
            return true;
        }
        return false; // Índice inválido
    }

    // Eliminar un producto
    public boolean eliminarProducto(int indice) {
        if (indice >= 0 && indice < totalProductos) {
            for (int i = indice; i < totalProductos - 1; i++) {
                productos[i] = productos[i + 1];
            }
            productos[--totalProductos] = null; // Limpiar el último elemento
            return true;
        }
        return false; // Índice inválido
    }

    // Mostrar el inventario actual
    public void mostrarInventario() {
        System.out.println("Inventario actual:");
        for (int i = 0; i < totalProductos; i++) {
            System.out.println(productos[i]);
        }
    }

    // Copiar el inventario
    public void copiarInventario() {
        Producto[] copia = Arrays.copyOf(productos, totalProductos);
        System.out.println("Copia del inventario:");
        for (Producto producto : copia) {
            System.out.println(producto);
        }
    }

    // Buscar un producto por nombre
    public Producto buscarProducto(String nombre) {
        for (int i = 0; i < totalProductos; i++) {
            if (productos[i].getNombre().equalsIgnoreCase(nombre)) {
                return productos[i];
            }
        }
        return null; // No encontrado
    }

    // Ordenar productos por precio
    public void ordenarPorPrecio() {
        Arrays.sort(productos, 0, totalProductos, (p1, p2) -> Double.compare(p1.getPrecio(), p2.getPrecio()));
    }
}