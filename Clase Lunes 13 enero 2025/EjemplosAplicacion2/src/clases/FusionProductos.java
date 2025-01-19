/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
/**
 *
 * @author daniel
 */
/**
 * Clase FusionProductos
 * Combina y ordena listas de productos, eliminando duplicados.
 * 2. Un supermercado registra los productos vendidos durante el turno de la mañana y el turno de la tarde. Se
requiere generar un listado único de productos vendidos durante todo el día, ordenado alfabéticamente.
Diseña un programa que permita al usuario:
• Ingresar los nombres de los productos vendidos en cada turno.
• Combinar ambas listas en un solo arreglo.
• Ordenar el arreglo combinado y mostrar el listado final de productos en pantalla.
• Implementar una clase auxiliar que realice la fusión y ordenamiento de los arreglos.
Nota: El programa debe ser modular, empleando buenas prácticas de programación para facilitar su
reutilización.
 */
public class FusionProductos {

    /**
     * Combina y ordena dos listas de productos de forma alfabética y sin duplicados.
     * 
     * @param turnoMañana Arreglo con los productos vendidos en el turno de la mañana.
     * @param turnoTarde Arreglo con los productos vendidos en el turno de la tarde.
     * @return Un arreglo único con los productos combinados, ordenados alfabéticamente.
     */
    public String[] combinarYOrdenar(String[] turnoMañana, String[] turnoTarde) {
        // Usar un TreeSet para combinar, eliminar duplicados y ordenar automáticamente
        Set<String> productosUnicos = new TreeSet<>();
        productosUnicos.addAll(Arrays.asList(turnoMañana));
        productosUnicos.addAll(Arrays.asList(turnoTarde));

        // Convertir el TreeSet a un arreglo y devolverlo
        return productosUnicos.toArray(new String[0]);
    }
}
