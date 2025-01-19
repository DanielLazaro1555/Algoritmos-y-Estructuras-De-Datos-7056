/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.Arrays;

/**
 *
 * @author daniel
 */
/**
 * Clase ComparadorSecciones
 * Realiza operaciones para comparar listas de estudiantes.
 * 1. Una institución educativa cuenta con dos secciones para un mismo curso, y necesita verificar si ambas
tienen exactamente los mismos estudiantes inscritos. Diseña un programa que permita al usuario ingresar
los nombres de los estudiantes de ambas secciones. El programa debe:
• Comparar ambas listas y determinar si son iguales, independientemente del orden en que se ingresaron
los nombres.
• Mostrar un mensaje indicando si las secciones tienen los mismos estudiantes o si existen diferencias.
• Implementar una clase auxiliar que realice la comparación de arreglos de forma ordenada.
Nota: El programa debe utilizar métodos predefinidos para ordenar y comparar los arreglos.
 */
public class ComparadorSecciones {

    /**
     * Compara dos listas de estudiantes y verifica si son iguales.
     * 
     * @param seccion1 Arreglo de nombres de estudiantes de la sección 1.
     * @param seccion2 Arreglo de nombres de estudiantes de la sección 2.
     * @return true si ambas listas son iguales (independientemente del orden), false de lo contrario.
     */
    public boolean sonListasIguales(String[] seccion1, String[] seccion2) {
        if (seccion1.length != seccion2.length) {
            return false; // Si los tamaños son diferentes, no pueden ser iguales.
        }

        // Ordenar ambas listas para facilitar la comparación
        Arrays.sort(seccion1);
        Arrays.sort(seccion2);

        // Comparar las listas ordenadas
        return Arrays.equals(seccion1, seccion2);
    }
}
