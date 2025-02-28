package model;

/**
 *
 * @author daniel
 */
public class ABB {

    protected Nodo raiz;

    public ABB() {
        this.raiz = null;
    }

    public void insertar(int dato) {
        raiz = insertarRec(raiz, dato);
    }

    protected Nodo insertarRec(Nodo nodo, int dato) {
        if (nodo == null) {
            return new Nodo(dato);
        }
        if (dato < nodo.dato) {
            nodo.izquierda = insertarRec(nodo.izquierda, dato);
        } else if (dato > nodo.dato) {
            nodo.derecha = insertarRec(nodo.derecha, dato);
        }
        return nodo;
    }

    public boolean buscar(int dato) {
        return buscarRec(raiz, dato);
    }

    private boolean buscarRec(Nodo nodo, int dato) {
        if (nodo == null) {
            return false;
        }
        if (dato == nodo.dato) {
            return true;
        }
        return dato < nodo.dato ? buscarRec(nodo.izquierda, dato) : buscarRec(nodo.derecha, dato);
    }

    public void eliminar(int dato) {
        raiz = eliminarRec(raiz, dato);
    }

    private Nodo eliminarRec(Nodo nodo, int dato) {
        if (nodo == null) {
            return null;
        }
        if (dato < nodo.dato) {
            nodo.izquierda = eliminarRec(nodo.izquierda, dato);
        } else if (dato > nodo.dato) {
            nodo.derecha = eliminarRec(nodo.derecha, dato);
        } else {
            if (nodo.izquierda == null) {
                return nodo.derecha;
            }
            if (nodo.derecha == null) {
                return nodo.izquierda;
            }
            Nodo sucesor = obtenerMinimo(nodo.derecha);
            nodo.dato = sucesor.dato;
            nodo.derecha = eliminarRec(nodo.derecha, sucesor.dato);
        }
        return nodo;
    }

    private Nodo obtenerMinimo(Nodo nodo) {
        while (nodo.izquierda != null) {
            nodo = nodo.izquierda;
        }
        return nodo;
    }
}
