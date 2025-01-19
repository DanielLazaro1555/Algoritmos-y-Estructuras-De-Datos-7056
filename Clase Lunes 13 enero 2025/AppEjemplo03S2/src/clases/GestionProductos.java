package clases;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Clase GestionProductos
 * Esta clase es responsable de fusionar y ordenar dos listas de productos.
 * Se utiliza un TreeSet para garantizar que los elementos sean únicos y estén ordenados.
 * 
 * @author daniel
 */
public class GestionProductos {

    /**
     * Combina y ordena dos listas de productos en un único arreglo.
     * 
     * @param turnoMañana Arreglo de productos del turno de la mañana.
     * @param turnoTarde Arreglo de productos del turno de la tarde.
     * @return Un arreglo único con los productos combinados y ordenados alfabéticamente.
     */
    public String[] combinarYOrdenar(String[] turnoMañana, String[] turnoTarde) {
        // Crear un TreeSet para almacenar los productos únicos de forma ordenada.
        Set<String> productosUnicos = new TreeSet<>();

        // Agregar productos del turno de la mañana al conjunto.
        productosUnicos.addAll(Arrays.asList(turnoMañana));

        // Agregar productos del turno de la tarde al conjunto.
        productosUnicos.addAll(Arrays.asList(turnoTarde));

        // Convertir el conjunto ordenado a un arreglo y devolverlo.
        return productosUnicos.toArray(new String[0]);
    }
}
