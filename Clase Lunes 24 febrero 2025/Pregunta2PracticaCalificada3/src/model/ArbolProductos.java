package model;

import clases.NodoArbol;
import clases.Producto;

/**
 *
 * @author daniel
 */
public class ArbolProductos {

    private NodoArbol raiz;

    /**
     * Constructor del árbol de productos. Inicialmente el árbol está vacío.
     */
    public ArbolProductos() {
        this.raiz = null;
    }

    /**
     * Método para insertar un producto en el árbol.
     *
     * @param producto Producto a agregar.
     */
    public void insertar(Producto producto) {
        raiz = insertarRecursivo(raiz, producto);
    }

    private NodoArbol insertarRecursivo(NodoArbol nodo, Producto producto) {
        if (nodo == null) {
            return new NodoArbol(producto);
        }
        if (producto.getCodigo() < nodo.getProducto().getCodigo()) {
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), producto));
        } else if (producto.getCodigo() > nodo.getProducto().getCodigo()) {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), producto));
        }
        return nodo;
    }

    /**
     * Método para buscar un producto por su código.
     *
     * @param codigo Código del producto a buscar.
     * @return El producto encontrado o null si no existe.
     */
    public Producto buscar(int codigo) {
        return buscarRecursivo(raiz, codigo);
    }

    private Producto buscarRecursivo(NodoArbol nodo, int codigo) {
        if (nodo == null) {
            return null;
        }
        if (codigo == nodo.getProducto().getCodigo()) {
            return nodo.getProducto();
        }
        return (codigo < nodo.getProducto().getCodigo())
                ? buscarRecursivo(nodo.getIzquierdo(), codigo)
                : buscarRecursivo(nodo.getDerecho(), codigo);
    }

    /**
     * Método para recorrer el árbol en orden (in-order).
     */
    public void recorrerInOrder() {
        recorrerInOrderRecursivo(raiz);
    }

    private void recorrerInOrderRecursivo(NodoArbol nodo) {
        if (nodo != null) {
            recorrerInOrderRecursivo(nodo.getIzquierdo());
            System.out.println(nodo.getProducto());
            recorrerInOrderRecursivo(nodo.getDerecho());
        }
    }

    /**
     * Método para eliminar un producto por su código.
     *
     * @param codigo Código del producto a eliminar.
     */
    public void eliminar(int codigo) {
        raiz = eliminarRecursivo(raiz, codigo);
    }

    private NodoArbol eliminarRecursivo(NodoArbol nodo, int codigo) {
        if (nodo == null) {
            return null;
        }
        if (codigo < nodo.getProducto().getCodigo()) {
            nodo.setIzquierdo(eliminarRecursivo(nodo.getIzquierdo(), codigo));
        } else if (codigo > nodo.getProducto().getCodigo()) {
            nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), codigo));
        } else {
            if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            } else if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            }
            NodoArbol sucesor = encontrarMinimo(nodo.getDerecho());
            nodo.getProducto().setNombre(sucesor.getProducto().getNombre());
            nodo.getProducto().setCantidad(sucesor.getProducto().getCantidad());
            nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), sucesor.getProducto().getCodigo()));
        }
        return nodo;
    }

    private NodoArbol encontrarMinimo(NodoArbol nodo) {
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }
        return nodo;
    }
}
