package model;

/**
 *
 * @author daniel
 */
public class AVL extends ABB {

    private int altura(Nodo nodo) {
        return (nodo == null) ? 0 : 1 + Math.max(altura(nodo.izquierda), altura(nodo.derecha));
    }

    private int balance(Nodo nodo) {
        return (nodo == null) ? 0 : altura(nodo.izquierda) - altura(nodo.derecha);
    }

    private Nodo rotacionDerecha(Nodo y) {
        Nodo x = y.izquierda;
        y.izquierda = x.derecha;
        x.derecha = y;
        return x;
    }

    private Nodo rotacionIzquierda(Nodo x) {
        Nodo y = x.derecha;
        x.derecha = y.izquierda;
        y.izquierda = x;
        return y;
    }

    protected Nodo inserterRec(Nodo nodo, int dato) {
        nodo = super.insertarRec(nodo, dato);
        int balance = balance(nodo);

        if (balance > 1 && dato < nodo.izquierda.dato) {
            return rotacionDerecha(nodo);
        }
        if (balance < -1 && dato > nodo.derecha.dato) {
            return rotacionIzquierda(nodo);
        }
        if (balance > 1 && dato > nodo.izquierda.dato) {
            nodo.izquierda = rotacionIzquierda(nodo.izquierda);
            return rotacionDerecha(nodo);
        }
        if (balance < -1 && dato < nodo.derecha.dato) {
            nodo.derecha = rotacionDerecha(nodo.derecha);
            return rotacionIzquierda(nodo);
        }
        return nodo;
    }

}
