package controller;

import model.ListaEnlazada;
import model.Nodo;

/**
 * Clase que proporciona diferentes algoritmos de ordenamiento para listas enlazadas.
 * Incluye métodos para ordenar usando Burbuja, Selección, Inserción y Merge Sort.
 * 
 * @author daniel
 */
public class OrdenarLista {

    // Método de ordenamiento por burbuja
    public static void OrdenarBurbuja(ListaEnlazada lista) {
        if (lista.getCabeza() == null) {
            return;
        }
        boolean cambiado;
        do {
            cambiado = false;
            Nodo actual = lista.getCabeza();
            Nodo previo = null;
            Nodo siguiente = actual.siguiente;

            while (siguiente != null) {
                if (actual.dato > siguiente.dato) {
                    cambiado = true;
                    if (previo != null) {
                        previo.siguiente = siguiente;
                    } else {
                        lista.setCabeza(siguiente);
                    }
                    actual.siguiente = siguiente.siguiente;
                    siguiente.siguiente = actual;

                    previo = siguiente;
                    siguiente = actual.siguiente;
                } else {
                    previo = actual;
                    actual = siguiente;
                    siguiente = siguiente.siguiente;
                }
            }
        } while (cambiado);
    }

    // Método de ordenamiento por selección
    public static void OrdenarSeleccion(ListaEnlazada lista) {
        Nodo actual = lista.getCabeza();
        while (actual != null) {
            Nodo min = actual;
            Nodo temp = actual.siguiente;

            while (temp != null) {
                if (temp.dato < min.dato) {
                    min = temp;
                }
                temp = temp.siguiente;
            }

            int aux = actual.dato;
            actual.dato = min.dato;
            min.dato = aux;

            actual = actual.siguiente;
        }
    }

    // Método de ordenamiento por inserción
    public static void OrdenarInsercion(ListaEnlazada lista) {
        if (lista.getCabeza() == null || lista.getCabeza().siguiente == null) {
            return;
        }
        Nodo ordenado = null;
        Nodo actual = lista.getCabeza();

        while (actual != null) {
            Nodo siguiente = actual.siguiente;
            ordenado = insertarOrdenado(ordenado, actual);
            actual = siguiente;
        }
        lista.setCabeza(ordenado);
    }

    private static Nodo insertarOrdenado(Nodo cabeza, Nodo nuevo) {
        if (cabeza == null || nuevo.dato < cabeza.dato) {
            nuevo.siguiente = cabeza;
            return nuevo;
        }
        Nodo actual = cabeza;
        while (actual.siguiente != null && actual.siguiente.dato < nuevo.dato) {
            actual = actual.siguiente;
        }

        nuevo.siguiente = actual.siguiente;
        actual.siguiente = nuevo;

        return cabeza;
    }

    // Método de ordenamiento por Merge Sort
    public static void OrdenarMerge(ListaEnlazada lista) {
        lista.setCabeza(mergeSort(lista.getCabeza()));
    }

    private static Nodo mergeSort(Nodo cabeza) {
        if (cabeza == null || cabeza.siguiente == null) {
            return cabeza;
        }
        Nodo medio = obtenerMedio(cabeza);
        Nodo siguienteDelMedio = medio.siguiente;
        medio.siguiente = null;

        Nodo izquierda = mergeSort(cabeza);
        Nodo derecha = mergeSort(siguienteDelMedio);

        return merge(izquierda, derecha);
    }

    private static Nodo obtenerMedio(Nodo cabeza) {
        if (cabeza == null) {
            return null;
        }
        Nodo lento = cabeza, rapido = cabeza;

        while (rapido.siguiente != null && rapido.siguiente.siguiente != null) {
            lento = lento.siguiente;
            rapido = rapido.siguiente.siguiente;
        }
        return lento;
    }

    private static Nodo merge(Nodo izquierda, Nodo derecha) {
        if (izquierda == null) {
            return derecha;
        }
        if (derecha == null) {
            return izquierda;
        }
        if (izquierda.dato < derecha.dato) {
            izquierda.siguiente = merge(izquierda.siguiente, derecha);
            return izquierda;
        } else {
            derecha.siguiente = merge(izquierda, derecha.siguiente);
            return derecha;
        }
    }
}
