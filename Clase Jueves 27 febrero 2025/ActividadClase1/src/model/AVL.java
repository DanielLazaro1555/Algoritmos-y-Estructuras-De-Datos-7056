package model;

/**
 *
 * @author daniel
 */
/**
 * Clase que representa un Árbol AVL para gestionar productos. Mantiene
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
     * Método para insertar un producto en el AVL.
     *
     * @param producto Producto a insertar.
     */
    public void insertar(Producto producto) {
        raiz = insertarRecursivo(raiz, producto);
    }

    private Nodo insertarRecursivo(Nodo actual, Producto producto) {
        if (actual == null) {
            return new Nodo(producto);
        }

        if (producto.getCodigo() < actual.getProducto().getCodigo()) {
            actual.setIzquierdo(insertarRecursivo(actual.getIzquierdo(), producto));
        } else if (producto.getCodigo() > actual.getProducto().getCodigo()) {
            actual.setDerecho(insertarRecursivo(actual.getDerecho(), producto));
        } else {
            System.out.println("El producto con código " + producto.getCodigo() + " ya existe.");
            return actual;
        }

        // Actualizar altura y balancear el árbol
        actualizarAltura(actual);
        return balancear(actual);
    }

    /**
     * Método para eliminar un producto del AVL por su código.
     *
     * @param codigo Código del producto a eliminar.
     */
    public void eliminar(int codigo) {
        raiz = eliminarRecursivo(raiz, codigo);
    }

    private Nodo eliminarRecursivo(Nodo actual, int codigo) {
        if (actual == null) {
            return null;
        }

        if (codigo < actual.getProducto().getCodigo()) {
            actual.setIzquierdo(eliminarRecursivo(actual.getIzquierdo(), codigo));
        } else if (codigo > actual.getProducto().getCodigo()) {
            actual.setDerecho(eliminarRecursivo(actual.getDerecho(), codigo));
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
            actual.setProducto(sucesor.getProducto());
            actual.setDerecho(eliminarRecursivo(actual.getDerecho(), sucesor.getProducto().getCodigo()));
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
     * Método para buscar un producto por su código.
     *
     * @param codigo Código del producto a buscar.
     * @return Producto si se encuentra, null si no existe.
     */
    public Producto buscar(int codigo) {
        Nodo resultado = buscarRecursivo(raiz, codigo);
        return (resultado != null) ? resultado.getProducto() : null;
    }

    private Nodo buscarRecursivo(Nodo actual, int codigo) {
        if (actual == null || actual.getProducto().getCodigo() == codigo) {
            return actual;
        }
        if (codigo < actual.getProducto().getCodigo()) {
            return buscarRecursivo(actual.getIzquierdo(), codigo);
        }
        return buscarRecursivo(actual.getDerecho(), codigo);
    }

    /**
     * Método para mostrar los productos en orden ascendente (recorrido
     * inorden).
     */
    public void mostrarInorden() {
        inordenRecursivo(raiz);
    }

    private void inordenRecursivo(Nodo actual) {
        if (actual != null) {
            inordenRecursivo(actual.getIzquierdo());
            System.out.println(actual.getProducto());
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
