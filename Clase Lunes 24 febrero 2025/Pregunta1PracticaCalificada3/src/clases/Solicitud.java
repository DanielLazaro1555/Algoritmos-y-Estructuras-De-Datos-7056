package clases;

/**
 *
 * @author daniel
 */
public class Solicitud {

    private static int contadorId = 1; // Generador automático de IDs
    private int id;
    private String nombreCliente;
    private String descripcion;

    /**
     * Constructor de la clase Solicitud.
     *
     * @param nombreCliente Nombre del cliente que realiza la solicitud.
     * @param descripcion Descripción de la solicitud.
     */
    public Solicitud(String nombreCliente, String descripcion) {
        this.id = contadorId++;
        this.nombreCliente = nombreCliente;
        this.descripcion = descripcion;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // Setters
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método para representar la solicitud como una cadena de texto.
     *
     * @return Información de la solicitud en formato String.
     */
    @Override
    public String toString() {
        return "Solicitud ID: " + id + " | Cliente: " + nombreCliente + " | Descripción: " + descripcion;
    }
}
