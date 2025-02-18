package model;

/**
 *
 * @author daniel
 */
public class ArbolBinario {

    private Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    /**
     * Inserta un nuevo empleado en la organización respetando la jerarquía.
     */
    public boolean insertar(Empleado empleado) {
        if (raiz == null) {
            raiz = new Nodo(empleado);
            return true;
        }
        return insertarRec(raiz, empleado);
    }

    private boolean insertarRec(Nodo actual, Empleado empleado) {
        if (empleado.getId() < actual.empleado.getId()) {
            if (actual.izquierdo == null) {
                actual.izquierdo = new Nodo(empleado);
                return true;
            } else {
                return insertarRec(actual.izquierdo, empleado);
            }
        } else if (empleado.getId() > actual.empleado.getId()) {
            if (actual.derecho == null) {
                actual.derecho = new Nodo(empleado);
                return true;
            } else {
                return insertarRec(actual.derecho, empleado);
            }
        } else {
            return false; // No permite empleados con el mismo ID
        }
    }

    /**
     * Recorre el árbol en Inorden (orden jerárquico).
     */
    public void inorden() {
        inordenRec(raiz);
        System.out.println();
    }

    private void inordenRec(Nodo nodo) {
        if (nodo != null) {
            inordenRec(nodo.izquierdo);
            System.out.println(nodo.empleado);
            inordenRec(nodo.derecho);
        }
    }
}
