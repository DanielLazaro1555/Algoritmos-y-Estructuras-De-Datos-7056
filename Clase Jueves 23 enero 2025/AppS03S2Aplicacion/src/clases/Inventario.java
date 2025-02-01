package clases;

import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class Inventario {

    private ArrayList<Producto> productos;

    // Constructor
    public Inventario() {
        productos = new ArrayList<>();
    }

    // Método para agregar un producto
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        System.out.println("Producto agregado exitosamente.");
    }

    // Método para eliminar un producto por ID
    public void eliminarProducto(int id) {
        productos.removeIf(p -> p.getId() == id);
        System.out.println("Producto eliminado exitosamente si existía.");
    }

    // Método para buscar un producto por ID
    public Producto buscarProducto(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // Método para listar todos los productos
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
}
