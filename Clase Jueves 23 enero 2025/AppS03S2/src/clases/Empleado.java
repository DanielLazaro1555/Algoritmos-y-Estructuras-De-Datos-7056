package clases;

/**
 *
 * @author daniel
 */
public class Empleado {

    private String nombre;
    private int id;
    private double salario;

    public Empleado(String nombre, int id, double salario) {
        this.nombre = nombre;
        this.id = id;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public double getSalario() {
        return salario;
    }

    public String toString() {
        return "Empleado { nombre = '" + nombre + "', id=" + id + ", salario=" + salario + " }";
    }

}
