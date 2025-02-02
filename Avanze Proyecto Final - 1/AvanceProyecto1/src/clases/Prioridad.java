package clases;

/**
 *
 * @author daniel
 */
public class Prioridad {

    public static final String ALTA = "Alta";
    public static final String MEDIA = "Media";
    public static final String BAJA = "Baja";

    // Asigna un valor numérico a la prioridad para facilitar el ordenamiento si es necesario
    public static int obtenerValorPrioridad(String prioridad) {
        return switch (prioridad.toLowerCase()) {
            case "alta" ->
                1;
            case "media" ->
                2;
            case "baja" ->
                3;
            default ->
                Integer.MAX_VALUE; // Valor alto si no coincide
        };
    }
}
