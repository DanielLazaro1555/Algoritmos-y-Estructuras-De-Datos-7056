package clases;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Clase GestionProductos
 * Esta clase se encarga de combinar y ordenar listas de productos de dos turnos distintos.
 * Utiliza un conjunto (Set) para garantizar que los productos sean únicos
 * y los ordena automáticamente al utilizarlos con TreeSet.
 * 
 * @author daniel
 */
public class GestionProductos {
    
    /**
     * Combina y ordena dos listas de productos.
     * Los productos de ambas listas se fusionan en un conjunto, eliminando duplicados.
     * Posteriormente, se convierten en un arreglo ordenado alfabéticamente.
     * 
     * @param turnoMañana Lista de productos del turno de la mañana.
     * @param turnoTarde Lista de productos del turno de la tarde.
     * @return Un arreglo con los productos combinados y ordenados alfabéticamente.
     */
    public String[] combinarYOrdenar(String[] turnoMañana, String[] turnoTarde) {
        // Crear un conjunto (TreeSet) para almacenar los productos de manera única y ordenada.
        Set<String> productosUnicos = new TreeSet<>();
        
        // Agregar todos los productos del turno de la mañana al conjunto.
        productosUnicos.addAll(Arrays.asList(turnoMañana));
        
        // Agregar todos los productos del turno de la tarde al conjunto.
        productosUnicos.addAll(Arrays.asList(turnoTarde));
        
        // Convertir el conjunto ordenado en un arreglo y retornarlo.
        return productosUnicos.toArray(new String[0]);
    }
}
