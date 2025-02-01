package controller;

import model.ListaEnlazada;
import model.Nodo;
import model.Estudiante;

/**
 *
 * @author daniel
 */
public class OrdenarLista {

    // Método de ordenamiento por burbuja
    public static void ordenarBurbuja(ListaEnlazada lista) {
        Nodo actual;
        boolean cambiado;

        do {
            cambiado = false;
            actual = lista.getCabeza();

            while (actual != null && actual.siguiente != null) {
                if (actual.estudiante.getPromedio() > actual.siguiente.estudiante.getPromedio()) {
                    Estudiante temp = actual.estudiante;
                    actual.estudiante = actual.siguiente.estudiante;
                    actual.siguiente.estudiante = temp;
                    cambiado = true;
                }
                actual = actual.siguiente;
            }
        } while (cambiado);
    }

    // Método de ordenamiento por selección
    public static void ordenarSeleccion(ListaEnlazada lista) {
        Nodo actual = lista.getCabeza();
        while (actual != null) {
            Nodo min = actual;
            Nodo temp = actual.siguiente;

            while (temp != null) {
                if (temp.estudiante.getPromedio() < min.estudiante.getPromedio()) {
                    min = temp;
                }
                temp = temp.siguiente;
            }

            Estudiante aux = actual.estudiante;
            actual.estudiante = min.estudiante;
            min.estudiante = aux;

            actual = actual.siguiente;
        }
    }

    // Método de ordenamiento por inserción
    public static void ordenarInsercion(ListaEnlazada lista) {
        Nodo actual = lista.getCabeza();
        Nodo ordenado = null;

        while (actual != null) {
            Nodo siguiente = actual.siguiente;
            ordenado = insertarOrdenado(ordenado, actual);
            actual = siguiente;
        }
        lista.setCabeza(ordenado);
    }

    // Inserta un nodo de forma ordenada en la lista ordenada
    private static Nodo insertarOrdenado(Nodo cabeza, Nodo nuevo) {
        if (cabeza == null || nuevo.estudiante.getPromedio() < cabeza.estudiante.getPromedio()) {
            nuevo.siguiente = cabeza;
            return nuevo;
        }

        Nodo actual = cabeza;
        while (actual.siguiente != null && actual.siguiente.estudiante.getPromedio() < nuevo.estudiante.getPromedio()) {
            actual = actual.siguiente;
        }

        nuevo.siguiente = actual.siguiente;
        actual.siguiente = nuevo;

        return cabeza;
    }
}
