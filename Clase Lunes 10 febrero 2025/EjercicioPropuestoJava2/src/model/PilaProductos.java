package model;

import java.util.Arrays;

/**
 *
 * @author daniel
 */
public class PilaProductos {

    private Producto[] pila;
    private int tope;
    private int capacidad;

    /**
     * Constructor que inicializa la pila con una capacidad inicial.
     *
     * @param capacidadInicial Capacidad máxima inicial de la pila.
     */
    public PilaProductos(int capacidadInicial) {
        this.capacidad = capacidadInicial;
        this.pila = new Producto[capacidad];
        this.tope = -1; // Indica que la pila está vacía
    }

    /**
     * Agrega un nuevo producto a la pila (PUSH). Si la pila está llena, duplica
     * la capacidad antes de insertar el producto.
     *
     * @param producto Producto a agregar.
     */
    public void push(Producto producto) {
        if (tope + 1 == capacidad) {
            expandirCapacidad(); // Duplica la capacidad si está llena
        }
        pila[++tope] = producto;
        System.out.println("✔ Producto agregado: " + producto.getNombre());
    }
    
    
    public int getTamaño() {
        return tope + 1; // Devuelve el número de elementos en la pila
    }

    /**
     * Elimina el último producto agregado a la pila (POP).
     *
     * @return El producto eliminado o null si la pila está vacía.
     */
    public Producto pop() {
        if (isEmpty()) {
            System.out.println("⚠ No hay productos en el inventario.");
            return null;
        }
        Producto eliminado = pila[tope--];
        System.out.println("❌ Producto eliminado: " + eliminado.getNombre());
        return eliminado;
    }

    /**
     * Muestra el producto en la cima de la pila sin eliminarlo (PEEK).
     *
     * @return El producto en la cima o null si la pila está vacía.
     */
    public Producto peek() {
        if (isEmpty()) {
            System.out.println("⚠ No hay productos en el inventario.");
            return null;
        }
        return pila[tope];
    }

    /**
     * Muestra todos los productos en la pila en orden LIFO (último agregado,
     * primero mostrado).
     */
    public void mostrarInventario() {
        if (isEmpty()) {
            System.out.println("⚠ El inventario está vacío.");
            return;
        }
        System.out.println("\n=== 📦 Inventario de Productos ===");
        for (int i = tope; i >= 0; i--) {
            System.out.println(pila[i]);
        }
        System.out.println("===============================");
    }

    /**
     * Crea una copia de la pila actual sin modificar la original.
     *
     * @return Una nueva pila con los mismos productos.
     */
    public PilaProductos copiarInventario() {
        PilaProductos copia = new PilaProductos(this.capacidad);
        copia.tope = this.tope;
        copia.pila = Arrays.copyOf(this.pila, this.pila.length);
        return copia;
    }

    /**
     * Expande la capacidad del arreglo de la pila cuando se llena.
     */
    private void expandirCapacidad() {
        int nuevaCapacidad = capacidad * 2;
        pila = Arrays.copyOf(pila, nuevaCapacidad);
        capacidad = nuevaCapacidad;
        System.out.println("🔄 Capacidad de la pila duplicada a: " + capacidad);
    }

    /**
     * Verifica si la pila está vacía.
     *
     * @return true si la pila está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return tope == -1;
    }
}
