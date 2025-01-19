package clases;

/**
 *
 * @author daniel
 */
/**
 * Clase que representa un producto en el inventario.
 */
public class Producto {

    private String nombre;
    private double precio;
    private int cantidadStock;

    public Producto(String nombre, double precio, int cantidadStock) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    @Override
    public String toString() {
        return "Producto{"
                + "nombre='" + nombre + '\''
                + ", precio=S/ " + String.format("%.2f", precio)
                + // Agregar el símbolo de soles
                ", cantidadStock=" + cantidadStock
                + '}';
    }
}
