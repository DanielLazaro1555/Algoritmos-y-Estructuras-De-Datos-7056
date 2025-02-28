package model;

/**
 *
 * @author daniel
 */
public class Producto {

    private int codigo;  // Código único del producto
    private String nombre;  // Nombre del producto
    private int stock;  // Stock disponible

    /**
     * Constructor para inicializar un producto con código, nombre y stock.
     *
     * @param codigo Código único del producto.
     * @param nombre Nombre del producto.
     * @param stock Cantidad disponible en el inventario.
     */
    public Producto(int codigo, String nombre, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
    }

    // Getters y Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Método para representar el producto como una cadena de texto.
     *
     * @return String con información del producto.
     */
    @Override
    public String toString() {
        return "Producto{"
                + "codigo=" + codigo
                + ", nombre='" + nombre + '\''
                + ", stock=" + stock
                + '}';
    }
}
