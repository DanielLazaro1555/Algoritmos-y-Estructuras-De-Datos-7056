package model;

/**
 *
 * @author daniel
 */
/**
 * Clase que representa a un usuario dentro del sistema de gestión. Cada usuario
 * tiene un ID único, nombre, correo electrónico y nivel de acceso.
 */
public class Usuario {

    private int id; // ID único del usuario
    private String nombre; // Nombre del usuario
    private String correo; // Correo electrónico del usuario
    private int nivelAcceso; // Nivel de acceso (1 = Básico, 2 = Intermedio, 3 = Avanzado)

    /**
     * Constructor para inicializar un usuario con sus atributos.
     *
     * @param id ID único del usuario.
     * @param nombre Nombre del usuario.
     * @param correo Correo electrónico del usuario.
     * @param nivelAcceso Nivel de acceso (1 = Básico, 2 = Intermedio, 3 =
     * Avanzado).
     */
    public Usuario(int id, String nombre, String correo, int nivelAcceso) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.nivelAcceso = nivelAcceso;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(int nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

    /**
     * Método para representar un usuario como cadena de texto.
     *
     * @return String con la información del usuario.
     */
    @Override
    public String toString() {
        return "Usuario{"
                + "ID=" + id
                + ", Nombre='" + nombre + '\''
                + ", Correo='" + correo + '\''
                + ", Nivel de acceso=" + nivelAcceso
                + '}';
    }
}
