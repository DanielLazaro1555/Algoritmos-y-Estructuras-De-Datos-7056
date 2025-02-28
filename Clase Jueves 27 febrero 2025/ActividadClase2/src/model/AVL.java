package model;

/**
 *
 * @author daniel
 */
/**
 * Clase que representa un Árbol AVL para gestionar usuarios. Mantiene
 * balanceado el árbol aplicando rotaciones cuando es necesario.
 */
public class AVL {

    private Nodo raiz; // Nodo raíz del AVL

    /**
     * Constructor que inicializa el AVL vacío.
     */
    public AVL() {
        this.raiz = null;
    }

    /**
     * Método para insertar un usuario en el AVL.
     *
     * @param usuario Usuario a insertar.
     */
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
            return actual;
        }

        // Actualizar altura y balancear el árbol
        actualizarAltura(actual);
        return balancear(actual);
    }

    /**
     * Método para eliminar un usuario del AVL por su ID.
     *
     * @param id ID del usuario a eliminar.
     */
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
            // Caso 1: Nodo sin hijos
            if (actual.getIzquierdo() == null && actual.getDerecho() == null) {
                return null;
            }
            // Caso 2: Nodo con un solo hijo
            if (actual.getIzquierdo() == null) {
                return actual.getDerecho();
            } else if (actual.getDerecho() == null) {
                return actual.getIzquierdo();
            }
            // Caso 3: Nodo con dos hijos
            Nodo sucesor = encontrarMinimo(actual.getDerecho());
            actual.setUsuario(sucesor.getUsuario());
            actual.setDerecho(eliminarRecursivo(actual.getDerecho(), sucesor.getUsuario().getId()));
        }

        // Actualizar altura y balancear el árbol
        actualizarAltura(actual);
        return balancear(actual);
    }

    private Nodo encontrarMinimo(Nodo nodo) {
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }
        return nodo;
    }

    /**
     * Método para buscar un usuario por su ID.
     *
     * @param id ID del usuario a buscar.
     * @return Usuario si se encuentra, null si no existe.
     */
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

    /**
     * Método para mostrar los usuarios en orden ascendente (recorrido inorden).
     */
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

    // ================= MÉTODOS PARA MANTENER BALANCE =================
    private void actualizarAltura(Nodo nodo) {
        if (nodo != null) {
            nodo.setAltura(1 + Math.max(obtenerAltura(nodo.getIzquierdo()), obtenerAltura(nodo.getDerecho())));
        }
    }

    private int obtenerAltura(Nodo nodo) {
        return (nodo == null) ? 0 : nodo.getAltura();
    }

    private int obtenerBalance(Nodo nodo) {
        return (nodo == null) ? 0 : obtenerAltura(nodo.getIzquierdo()) - obtenerAltura(nodo.getDerecho());
    }

    private Nodo balancear(Nodo nodo) {
        int balance = obtenerBalance(nodo);

        // Caso Izquierda-Izquierda (Rotación simple a la derecha)
        if (balance > 1 && obtenerBalance(nodo.getIzquierdo()) >= 0) {
            return rotacionDerecha(nodo);
        }

        // Caso Izquierda-Derecha (Rotación doble izquierda-derecha)
        if (balance > 1 && obtenerBalance(nodo.getIzquierdo()) < 0) {
            nodo.setIzquierdo(rotacionIzquierda(nodo.getIzquierdo()));
            return rotacionDerecha(nodo);
        }

        // Caso Derecha-Derecha (Rotación simple a la izquierda)
        if (balance < -1 && obtenerBalance(nodo.getDerecho()) <= 0) {
            return rotacionIzquierda(nodo);
        }

        // Caso Derecha-Izquierda (Rotación doble derecha-izquierda)
        if (balance < -1 && obtenerBalance(nodo.getDerecho()) > 0) {
            nodo.setDerecho(rotacionDerecha(nodo.getDerecho()));
            return rotacionIzquierda(nodo);
        }

        return nodo; // Si el nodo ya está balanceado
    }

    private Nodo rotacionDerecha(Nodo y) {
        Nodo x = y.getIzquierdo();
        Nodo temp = x.getDerecho();

        x.setDerecho(y);
        y.setIzquierdo(temp);

        actualizarAltura(y);
        actualizarAltura(x);

        return x;
    }

    private Nodo rotacionIzquierda(Nodo x) {
        Nodo y = x.getDerecho();
        Nodo temp = y.getIzquierdo();

        y.setIzquierdo(x);
        x.setDerecho(temp);

        actualizarAltura(x);
        actualizarAltura(y);

        return y;
    }
}
