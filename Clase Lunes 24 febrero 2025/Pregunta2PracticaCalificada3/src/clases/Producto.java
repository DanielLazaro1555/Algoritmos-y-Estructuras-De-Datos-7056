package clases;

/**
 *
 * @author daniel
 */
public class Producto {

    private int codigo;
    private String nombre;
    private int cantidad;

    /**
     * Constructor de la clase Producto.
     *
     * @param codigo Código único del producto.
     * @param nombre Nombre del producto.
     * @param cantidad Cantidad disponible en inventario.
     */
    public Producto(int codigo, String nombre, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    // Getters
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Método para representar el producto como cadena de texto.
     *
     * @return Información del producto.
     */
    @Override
    public String toString() {
        return "📦 Producto [Código: " + codigo + ", Nombre: " + nombre + ", Cantidad: " + cantidad + "]";
    }
}
