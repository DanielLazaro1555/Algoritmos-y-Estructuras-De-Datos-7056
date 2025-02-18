package model;

/**
 *
 * @author Daniel
 */
class Nodo {
    int dato;
    Nodo izquierdo, derecho;

    public Nodo(int item) {
        dato = item;
        izquierdo = derecho = null;
    }
}

public class ArbolBinario {
    private Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public void insertar(int dato) {
        raiz = insertarRec(raiz, dato);
    }

    private Nodo insertarRec(Nodo raiz, int dato) {
        if (raiz == null) {
            return new Nodo(dato);
        }
        if (dato < raiz.dato) {
            raiz.izquierdo = insertarRec(raiz.izquierdo, dato);
        } else {
            raiz.derecho = insertarRec(raiz.derecho, dato);
        }
        return raiz;
    }

    public boolean buscar(int dato) {
        return buscarRec(raiz, dato);
    }

    private boolean buscarRec(Nodo raiz, int dato) {
        if (raiz == null) return false;
        if (raiz.dato == dato) return true;
        return dato < raiz.dato ? buscarRec(raiz.izquierdo, dato) : buscarRec(raiz.derecho, dato);
    }

    public void preorden() {
        preordenRec(raiz);
        System.out.println();
    }

    private void preordenRec(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato + " ");
            preordenRec(nodo.izquierdo);
            preordenRec(nodo.derecho);
        }
    }

    public void inorden() {
        inordenRec(raiz);
        System.out.println();
    }

    private void inordenRec(Nodo nodo) {
        if (nodo != null) {
            inordenRec(nodo.izquierdo);
            System.out.print(nodo.dato + " "); // Agregado espacio para separar números
            inordenRec(nodo.derecho);
        }
    }

    public void postorden() {
        postordenRec(raiz);
        System.out.println();
    }

    private void postordenRec(Nodo nodo) {
        if (nodo != null) {
            postordenRec(nodo.izquierdo);
            postordenRec(nodo.derecho);
            System.out.print(nodo.dato + " "); // Agregado espacio para separar números
        }
    }

    public void eliminar(int dato) {
        raiz = eliminarRec(raiz, dato);
    }

    private Nodo eliminarRec(Nodo raiz, int dato) {
        if (raiz == null) return null;
        if (dato < raiz.dato) {
            raiz.izquierdo = eliminarRec(raiz.izquierdo, dato);
        } else if (dato > raiz.dato) {
            raiz.derecho = eliminarRec(raiz.derecho, dato);
        } else {
            if (raiz.izquierdo == null) return raiz.derecho;
            else if (raiz.derecho == null) return raiz.izquierdo;
            raiz.dato = minValor(raiz.derecho);
            raiz.derecho = eliminarRec(raiz.derecho, raiz.dato);
        }
        return raiz;
    }

    private int minValor(Nodo nodo) {
        int min = nodo.dato;
        while (nodo.izquierdo != null) {
            min = nodo.izquierdo.dato;
            nodo = nodo.izquierdo;
        }
        return min;
    }
}
