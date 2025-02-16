package model;

/**
 *
 * @author daniel
 */
public class Producto {

    private String nombre;
    private int id;
    private double precio;

    public Producto(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto{"
                + "ID=" + id
                + ", Nombre='" + nombre + '\''
                + ", Precio=" + precio
                + '}';
    }
}
