package clases;

/**
 * Clase que define constantes para los niveles de prioridad de las tareas y
 * proporciona un método para obtener un valor numérico asociado a cada
 * prioridad. Esto facilita el ordenamiento de las tareas según su nivel de
 * prioridad.
 *
 * @author daniel
 */
public class Prioridad {

    // Constantes que representan los niveles de prioridad permitidos
    public static final String ALTA = "Alta";
    public static final String MEDIA = "Media";
    public static final String BAJA = "Baja";

    /**
     * Asigna un valor numérico a la prioridad para facilitar el ordenamiento.
     * Las prioridades más altas tienen valores numéricos menores.
     *
     * @param prioridad La prioridad de la tarea (Alta, Media, Baja).
     * @return Un número que representa la prioridad (1 para Alta, 2 para Media,
     * 3 para Baja). Devuelve Integer.MAX_VALUE si la prioridad no coincide con
     * ninguna de las opciones.
     */
    public static int obtenerValorPrioridad(String prioridad) {
        return switch (prioridad.toLowerCase()) {
            case "alta" ->
                1;   // Mayor prioridad
            case "media" ->
                2;  // Prioridad intermedia
            case "baja" ->
                3;   // Menor prioridad
            default ->
                Integer.MAX_VALUE; // Valor alto si no coincide (para ordenar al final)
        };
    }
}
