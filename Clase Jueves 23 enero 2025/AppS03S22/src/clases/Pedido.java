package clases;

/**
 *
 * @author daniel
 */
public class Pedido {

    private int id;
    private String cliente;
    private String tipoPizza;
    private int cantidad;
    private double precioTotal;

    public Pedido(int id, String cliente, String tipoPizza, int cantidad, double precioTotal) {
        this.id = id;
        this.cliente = cliente;
        this.tipoPizza = tipoPizza;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
    }

    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public String getTipoPizza() {
        return tipoPizza;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void calcularPrecioTotal(double precioUnitario) {
        this.precioTotal = this.cantidad * precioUnitario;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", cliente=" + cliente + ", tipoPizza=" + tipoPizza + ", cantidad=" + cantidad + ", precioTotal=" + precioTotal + '}';
    }

}