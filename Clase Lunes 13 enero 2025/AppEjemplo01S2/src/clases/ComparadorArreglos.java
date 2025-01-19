package clases;

import java.util.Arrays;

/**
 * Clase ComparadorArreglos
 * 
 * Esta clase contiene un método para comparar si dos arreglos de cadenas
 * son iguales sin importar el orden de sus elementos.
 * 
 * @author Daniel
 */
public class ComparadorArreglos {

    /**
     * Método para verificar si dos listas de cadenas son iguales, independientemente del orden.
     *
     * @param lista1 El primer arreglo de cadenas.
     * @param lista2 El segundo arreglo de cadenas.
     * @return true si ambos arreglos tienen los mismos elementos (sin importar el orden), false en caso contrario.
     */
    public boolean sonlistasiguales(String[] lista1, String[] lista2) {
        // Verificar si los arreglos tienen diferente longitud; si es así, no pueden ser iguales.
        if (lista1.length != lista2.length) {
            return false;
        }

        // Crear copias de los arreglos originales para evitar modificar sus datos.
        String[] copiaLista1 = lista1.clone();
        String[] copiaLista2 = lista2.clone();

        // Ordenar ambas copias de los arreglos en orden alfabético.
        Arrays.sort(copiaLista1);
        Arrays.sort(copiaLista2);

        // Comparar los arreglos ordenados. Si son iguales, retornar true; de lo contrario, false.
        return Arrays.equals(copiaLista1, copiaLista2);
    }
}