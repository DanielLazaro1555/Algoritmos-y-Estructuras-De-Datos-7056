package controller;

import model.PilaProductos;
import model.Producto;

/**
 *
 * @author daniel
 */
public class InventarioController {

    private PilaProductos pilaProductos;

    /**
     * Constructor que inicializa el inventario con una capacidad inicial.
     *
     * @param capacidadInicial Capacidad máxima inicial de la pila.
     */
    public InventarioController(int capacidadInicial) {
        this.pilaProductos = new PilaProductos(capacidadInicial);
    }

    /**
     * Agrega un nuevo producto al inventario.
     *
     * @param nombre Nombre del producto.
     * @param precio Precio del producto.
     * @param cantidad Cantidad en stock.
     */
    public void agregarProducto(String nombre, double precio, int cantidad) {
        if (precio < 0 || cantidad < 0) {
            System.out.println("⚠ Error: El precio y la cantidad no pueden ser negativos.");
            return;
        }
        Producto nuevoProducto = new Producto(nombre, precio, cantidad);
        pilaProductos.push(nuevoProducto);
    }

    /**
     * Elimina el último producto agregado del inventario.
     */
    public void eliminarProducto() {
        pilaProductos.pop();
    }

    /**
     * Consulta el último producto agregado sin eliminarlo.
     */
    public void consultarUltimoProducto() {
        Producto producto = pilaProductos.peek();
        if (producto != null) {
            System.out.println("📌 Último producto agregado: " + producto);
        }
    }

    /**
     * Muestra todos los productos del inventario.
     */
    public void mostrarInventario() {
        pilaProductos.mostrarInventario();
    }

    /**
     * Copia y muestra el inventario sin modificar la pila original.
     */
    public void copiarInventario() {
        PilaProductos copia = pilaProductos.copiarInventario();
        System.out.println("\n📋 Copia del inventario:");
        copia.mostrarInventario();
    }

    /**
     * Busca un producto por su nombre en la pila sin modificarla.
     *
     * @param nombre Nombre del producto a buscar.
     */
    public void buscarProducto(String nombre) {
        boolean encontrado = false;
        System.out.println("\n🔍 Buscando producto: " + nombre);
        PilaProductos copia = pilaProductos.copiarInventario();

        while (!copia.isEmpty()) {
            Producto producto = copia.pop();
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("✔ Producto encontrado: " + producto);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("❌ Producto no encontrado en el inventario.");
        }
    }

    /**
     * Ordena el inventario por precio de menor a mayor sin perder la estructura
     * de la pila.
     */
    public void ordenarPorPrecio() {
        if (pilaProductos.isEmpty()) {
            System.out.println("⚠ No hay productos en el inventario para ordenar.");
            return;
        }

        // Algoritmo de ordenamiento: ordenar la pila sin modificar su estructura
        Producto[] productos = new Producto[pilaProductos.getTamaño()];
        for (int i = pilaProductos.getTamaño() - 1; i >= 0; i--) {
            productos[i] = pilaProductos.pop();
        }

        // Ordenar por precio (Método de selección)
        for (int i = 0; i < productos.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < productos.length; j++) {
                if (productos[j].getPrecio() < productos[minIndex].getPrecio()) {
                    minIndex = j;
                }
            }
            Producto temp = productos[i];
            productos[i] = productos[minIndex];
            productos[minIndex] = temp;
        }

        // Volver a apilar los productos ordenados
        for (Producto producto : productos) {
            pilaProductos.push(producto);
        }

        System.out.println("\n📊 Inventario ordenado por precio de menor a mayor:");
        pilaProductos.mostrarInventario();
    }
}
