package controller;

import model.ListaEnlazada;
import model.Producto;

/**
 *
 * @author daniel
 */
public class GestorInventario {

    private ListaEnlazada lista;

    public GestorInventario() {
        lista = new ListaEnlazada();
    }

    public void agregarProducto(String nombre, double precio, int cantidad) {
        if (precio <= 0 || cantidad < 0) {
            System.out.println("Datos inválidos. El precio debe ser mayor que 0 y la cantidad no negativa.");
            return;
        }
        lista.agregar(new Producto(nombre, precio, cantidad));
        System.out.println("Producto agregado exitosamente.");
    }

    public void actualizarProducto(String nombre, double nuevoPrecio, int nuevaCantidad) {
        Producto producto = lista.buscar(nombre);
        if (producto != null) {
            if (nuevoPrecio > 0) {
                producto.setPrecio(nuevoPrecio);
            }
            if (nuevaCantidad >= 0) {
                producto.setCantidad(nuevaCantidad);
            }
            System.out.println("Producto actualizado exitosamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void eliminarProducto(String nombre) {
        if (lista.eliminar(nombre)) {
            System.out.println("Producto eliminado exitosamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void mostrarInventario() {
        lista.mostrarInventario();
    }

    public void buscarProducto(String nombre) {
        Producto producto = lista.buscar(nombre);
        if (producto != null) {
            System.out.println("Producto encontrado: Nombre: " + producto.getNombre() + ", Precio: S/." + producto.getPrecio() + ", Cantidad: " + producto.getCantidad());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void ordenarInventarioPorPrecio() {
        lista.ordenarPorPrecio();
        System.out.println("Inventario ordenado por precio.");
    }
}
