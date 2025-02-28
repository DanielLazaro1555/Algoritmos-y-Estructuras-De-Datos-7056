package model;

/**
 *
 * @author daniel
 */
/**
 * Clase que representa un Árbol Binario de Búsqueda (ABB) para gestionar
 * productos. Permite insertar, buscar, eliminar y recorrer los productos en
 * orden ascendente.
 */
public class ABB {

    private Nodo raiz; // Nodo raíz del ABB

    /**
     * Constructor que inicializa el ABB vacío.
     */
    public ABB() {
        this.raiz = null;
    }

    /**
     * Método para insertar un producto en el ABB.
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
        }
        return actual;
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
     * Método para eliminar un producto del ABB por su código.
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
        return actual;
    }

    private Nodo encontrarMinimo(Nodo nodo) {
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }
        return nodo;
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
}
