package controller;

import model.ABB;
import model.AVL;
import model.Producto;

/**
 *
 * @author daniel
 */
/**
 * Clase controladora que gestiona las operaciones en los árboles ABB y AVL. Se
 * encarga de insertar, buscar, eliminar y mostrar productos en ambos árboles.
 */
public class GestorArboles {

    private ABB abb;  // Árbol Binario de Búsqueda
    private AVL avl;  // Árbol AVL

    /**
     * Constructor que inicializa los árboles ABB y AVL.
     */
    public GestorArboles() {
        this.abb = new ABB();
        this.avl = new AVL();
    }

    /**
     * Método para insertar un producto en ambos árboles.
     *
     * @param codigo Código único del producto.
     * @param nombre Nombre del producto.
     * @param stock Cantidad disponible en el inventario.
     */
    public void insertarProducto(int codigo, String nombre, int stock) {
        Producto nuevoProducto = new Producto(codigo, nombre, stock);
        abb.insertar(nuevoProducto);
        avl.insertar(nuevoProducto);
        System.out.println("Producto insertado correctamente en ABB y AVL.");
    }

    /**
     * Método para buscar un producto en ambos árboles.
     *
     * @param codigo Código del producto a buscar.
     */
    public void buscarProducto(int codigo) {
        Producto productoABB = abb.buscar(codigo);
        Producto productoAVL = avl.buscar(codigo);

        if (productoABB != null) {
            System.out.println("Producto encontrado en ABB: " + productoABB);
        } else {
            System.out.println("Producto no encontrado en ABB.");
        }

        if (productoAVL != null) {
            System.out.println("Producto encontrado en AVL: " + productoAVL);
        } else {
            System.out.println("Producto no encontrado en AVL.");
        }
    }

    /**
     * Método para eliminar un producto en ambos árboles.
     *
     * @param codigo Código del producto a eliminar.
     */
    public void eliminarProducto(int codigo) {
        abb.eliminar(codigo);
        avl.eliminar(codigo);
        System.out.println("Producto eliminado correctamente en ABB y AVL.");
    }

    /**
     * Método para mostrar los productos en orden ascendente.
     */
    public void mostrarProductos() {
        System.out.println("📌 Productos en ABB (Orden ascendente por código):");
        abb.mostrarInorden();

        System.out.println("\n📌 Productos en AVL (Orden ascendente por código):");
        avl.mostrarInorden();
    }
}
