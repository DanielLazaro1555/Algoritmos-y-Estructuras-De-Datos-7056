package clases;

/**
 * Clase que proporciona métodos de validación para las tareas.
 * Se encarga de verificar que los datos ingresados cumplan con los requisitos establecidos.
 * 
 * @author daniel
 */
public class ValidadorTareas {

    /**
     * Valida que la prioridad ingresada sea una de las permitidas: Alta, Media o Baja.
     * 
     * @param prioridad La prioridad de la tarea a validar.
     * @return true si la prioridad es válida, false en caso contrario.
     */
    public static boolean validarPrioridad(String prioridad) {
        return prioridad.equalsIgnoreCase("Alta")
                || prioridad.equalsIgnoreCase("Media")
                || prioridad.equalsIgnoreCase("Baja");
    }

    /**
     * Valida que la descripción de la tarea no esté vacía ni sea nula.
     * 
     * @param descripcion La descripción de la tarea a validar.
     * @return true si la descripción es válida, false si está vacía o es nula.
     */
    public static boolean validarDescripcion(String descripcion) {
        return descripcion != null && !descripcion.trim().isEmpty();
    }
}
