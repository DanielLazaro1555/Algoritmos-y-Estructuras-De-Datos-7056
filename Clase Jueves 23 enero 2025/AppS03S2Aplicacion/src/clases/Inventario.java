package clases;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author daniel
 */
public class Inventario {

    private ArrayList<Producto> productos;
    private int capacidad;

    public Inventario() {
        capacidad = 10; // Capacidad inicial
        productos = new ArrayList<>(capacidad);
    }

    public void agregarProducto(Producto producto) {
        if (productos.size() >= capacidad) {
            capacidad *= 2; // Duplicar la capacidad
            System.out.println("Capacidad duplicada a: " + capacidad);
        }
        productos.add(producto);
        System.out.println("Producto agregado exitosamente.");
    }

    public void actualizarProducto(int id, String nombre, double precio, int cantidad) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                p.setNombre(nombre);
                p.setPrecio(precio);
                p.setCantidad(cantidad);
                System.out.println("Producto actualizado exitosamente.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public void eliminarProducto(int id) {
        productos.removeIf(p -> p.getId() == id);
        System.out.println("Producto eliminado exitosamente si existía.");
    }

    public Producto buscarProductoPorNombre(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public Producto buscarProductoPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
        } else {
            System.out.println("=== LISTA DE PRODUCTOS ===");
            for (Producto p : productos) {
                System.out.println(p);
            }
        }
    }

    public void ordenarPorPrecio() {
        productos.sort(Comparator.comparingDouble(Producto::getPrecio));
        System.out.println("Productos ordenados por precio.");
    }

    public Inventario copiarInventario() {
        Inventario copia = new Inventario();
        copia.productos = new ArrayList<>(productos);
        System.out.println("Inventario copiado exitosamente.");
        return copia;
    }
}
