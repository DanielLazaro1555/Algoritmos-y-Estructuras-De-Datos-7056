package model;

/**
 *
 * @author daniel
 */
/**
 * Clase que representa un Árbol Binario de Búsqueda (ABB) para gestionar
 * usuarios. Permite insertar, buscar, eliminar y recorrer usuarios en orden
 * ascendente.
 */
public class ABB {

    private Nodo raiz; // Nodo raíz del ABB

    public ABB() {
        this.raiz = null;
    }

    public void insertar(Usuario usuario) {
        raiz = insertarRecursivo(raiz, usuario);
    }

    private Nodo insertarRecursivo(Nodo actual, Usuario usuario) {
        if (actual == null) {
            return new Nodo(usuario);
        }
        if (usuario.getId() < actual.getUsuario().getId()) {
            actual.setIzquierdo(insertarRecursivo(actual.getIzquierdo(), usuario));
        } else if (usuario.getId() > actual.getUsuario().getId()) {
            actual.setDerecho(insertarRecursivo(actual.getDerecho(), usuario));
        } else {
            System.out.println("⚠️ El usuario con ID " + usuario.getId() + " ya existe.");
        }
        return actual;
    }

    public Usuario buscar(int id) {
        Nodo resultado = buscarRecursivo(raiz, id);
        return (resultado != null) ? resultado.getUsuario() : null;
    }

    private Nodo buscarRecursivo(Nodo actual, int id) {
        if (actual == null || actual.getUsuario().getId() == id) {
            return actual;
        }
        if (id < actual.getUsuario().getId()) {
            return buscarRecursivo(actual.getIzquierdo(), id);
        }
        return buscarRecursivo(actual.getDerecho(), id);
    }

    public void eliminar(int id) {
        raiz = eliminarRecursivo(raiz, id);
    }

    private Nodo eliminarRecursivo(Nodo actual, int id) {
        if (actual == null) {
            return null;
        }
        if (id < actual.getUsuario().getId()) {
            actual.setIzquierdo(eliminarRecursivo(actual.getIzquierdo(), id));
        } else if (id > actual.getUsuario().getId()) {
            actual.setDerecho(eliminarRecursivo(actual.getDerecho(), id));
        } else {
            if (actual.getIzquierdo() == null && actual.getDerecho() == null) {
                return null;
            }
            if (actual.getIzquierdo() == null) {
                return actual.getDerecho();
            } else if (actual.getDerecho() == null) {
                return actual.getIzquierdo();
            }
            Nodo sucesor = encontrarMinimo(actual.getDerecho());
            actual.setUsuario(sucesor.getUsuario());
            actual.setDerecho(eliminarRecursivo(actual.getDerecho(), sucesor.getUsuario().getId()));
        }
        return actual;
    }

    private Nodo encontrarMinimo(Nodo nodo) {
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }
        return nodo;
    }

    public void mostrarInorden() {
        inordenRecursivo(raiz);
    }

    private void inordenRecursivo(Nodo actual) {
        if (actual != null) {
            inordenRecursivo(actual.getIzquierdo());
            System.out.println(actual.getUsuario());
            inordenRecursivo(actual.getDerecho());
        }
    }

    /**
     * Método para obtener la raíz del ABB.
     *
     * @return Nodo raíz del árbol.
     */
    public Nodo getRaiz() {
        return raiz;
    }
}
