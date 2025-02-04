package model;

import java.util.LinkedList;

/**
 * Clase ListaCircularModel que simula el comportamiento de una lista circular
 * utilizando la clase LinkedList de Java.
 *
 * @author daniel
 */
public class ListaCircularModel {

    // Declaración de la lista enlazada que almacenará los datos enteros
    private LinkedList<Integer> lista;

    /**
     * Constructor de la clase que inicializa la lista enlazada vacía.
     */
    public ListaCircularModel() {
        lista = new LinkedList<>();
    }

    /**
     * Inserta un nuevo elemento al inicio de la lista.
     *
     * @param dato El valor entero que se desea insertar.
     */
    public void insertarInicio(int dato) {
        lista.addFirst(dato); // Agrega el dato al inicio de la lista
    }

    /**
     * Inserta un nuevo elemento al final de la lista.
     *
     * @param dato El valor entero que se desea insertar.
     */
    public void insertarFinal(int dato) {
        lista.addLast(dato); // Agrega el dato al final de la lista
    }

    /**
     * Elimina el primer elemento de la lista, si la lista no está vacía.
     */
    public void eliminarInicio() {
        if (!lista.isEmpty()) { // Verifica que la lista no esté vacía
            lista.removeFirst(); // Elimina el primer elemento de la lista
        }
    }

    /**
     * Elimina el último elemento de la lista, si la lista no está vacía.
     */
    public void eliminarFinal() {
        if (!lista.isEmpty()) { // Verifica que la lista no esté vacía
            lista.removeLast(); // Elimina el último elemento de la lista
        }
    }

    /**
     * Recorre la lista y devuelve una cadena con todos los elementos
     * concatenados.
     *
     * @return Una cadena de texto con los valores de la lista.
     */
    public String recorrer() {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < lista.size(); i++) {
            resultado.append(lista.get(i));
            if (i < lista.size() - 1) {
                resultado.append(" | "); // Cambia aquí por ", " si prefieres comas
            }
        }
        return resultado.toString();
    }
}
