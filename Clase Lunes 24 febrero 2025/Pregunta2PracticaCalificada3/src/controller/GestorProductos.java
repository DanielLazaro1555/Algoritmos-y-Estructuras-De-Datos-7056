package controller;

import clases.Producto;
import model.ArbolProductos;

/**
 *
 * @author daniel
 */
/**
 * Clase que gestiona las operaciones sobre el Árbol de Productos.
 */
public class GestorProductos {

    private ArbolProductos arbol;

    /**
     * Constructor del Gestor de Productos. Inicializa el árbol de productos.
     */
    public GestorProductos() {
        this.arbol = new ArbolProductos();
    }

    /**
     * Agrega un nuevo producto al árbol.
     *
     * @param codigo Código único del producto.
     * @param nombre Nombre del producto.
     * @param cantidad Cantidad en inventario.
     */
    public void agregarProducto(int codigo, String nombre, int cantidad) {
        Producto nuevoProducto = new Producto(codigo, nombre, cantidad);
        arbol.insertar(nuevoProducto);
        System.out.println("✅ Producto agregado: " + nuevoProducto);
    }

    /**
     * Busca un producto por su código y lo muestra en consola.
     *
     * @param codigo Código del producto a buscar.
     */
    public void buscarProducto(int codigo) {
        Producto encontrado = arbol.buscar(codigo);
        if (encontrado != null) {
            System.out.println("🔍 Producto encontrado: " + encontrado);
        } else {
            System.out.println("❌ Producto con código " + codigo + " no encontrado.");
        }
    }

    /**
     * Muestra todos los productos en orden ascendente (in-order).
     */
    public void listarProductos() {
        System.out.println("\n📋 Listado de productos en inventario:");
        arbol.recorrerInOrder();
    }

    /**
     * Elimina un producto por su código.
     *
     * @param codigo Código del producto a eliminar.
     */
    public void eliminarProducto(int codigo) {
        arbol.eliminar(codigo);
        System.out.println("🗑 Producto con código " + codigo + " eliminado.");
    }
}
