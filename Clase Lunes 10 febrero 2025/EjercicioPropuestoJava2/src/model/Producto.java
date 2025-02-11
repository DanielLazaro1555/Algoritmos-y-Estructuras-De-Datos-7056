package model;

/**
 *
 * @author daniel
 */
public class Producto {

    private String nombre;
    private double precio;
    private int cantidad;

    /**
     * Constructor de la clase Producto.
     *
     * @param nombre Nombre del producto.
     * @param precio Precio del producto.
     * @param cantidad Cantidad en stock.
     */
    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return Nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre Nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return Precio del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio Precio del producto.
     */
    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        } else {
            System.out.println("⚠ El precio no puede ser negativo.");
        }
    }

    /**
     * Obtiene la cantidad en stock del producto.
     *
     * @return Cantidad en stock.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad en stock del producto.
     *
     * @param cantidad Cantidad en stock.
     */
    public void setCantidad(int cantidad) {
        if (cantidad >= 0) {
            this.cantidad = cantidad;
        } else {
            System.out.println("⚠ La cantidad no puede ser negativa.");
        }
    }

    /**
     * Representación en texto del producto.
     *
     * @return Información del producto en formato legible.
     */
    @Override
    public String toString() {
        return "📦 Producto: " + nombre + " | 💲 Precio: S./" + precio + " | 📦 Stock: " + cantidad;
    }
}
