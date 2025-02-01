package clases;

/**
 *
 * @author daniel
 */
public class Empleado {
    private String nombre;
    private String puesto;
    
    public Empleado(String nombre, String puesto){
        this.nombre = nombre;
        this.puesto = puesto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", puesto=" + puesto + '}';
    }
    
}
