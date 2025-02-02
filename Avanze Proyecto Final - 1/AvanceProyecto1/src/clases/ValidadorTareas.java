package clases;

/**
 *
 * @author daniel
 */
public class ValidadorTareas {

    // Valida que la prioridad sea Alta, Media o Baja
    public static boolean validarPrioridad(String prioridad) {
        return prioridad.equalsIgnoreCase("Alta")
                || prioridad.equalsIgnoreCase("Media")
                || prioridad.equalsIgnoreCase("Baja");
    }

    // Valida que la descripción de la tarea no esté vacía
    public static boolean validarDescripcion(String descripcion) {
        return descripcion != null && !descripcion.trim().isEmpty();
    }
}
