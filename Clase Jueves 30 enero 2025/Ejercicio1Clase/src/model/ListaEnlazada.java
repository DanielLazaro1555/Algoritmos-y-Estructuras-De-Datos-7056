package model;

import controller.OrdenarLista;
/**
 *
 * @author daniel
 */
public class ListaEnlazada {
    private Nodo cabeza;

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    public void agregar(Estudiante estudiante) {
        Nodo nuevo = new Nodo(estudiante);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    /**
     * Ordena la lista de estudiantes por promedio utilizando el algoritmo especificado.
     * 
     * @param metodo 1: Burbuja, 2: Selección, 3: Inserción
     */
    public void ordenarPorPromedio(int metodo) {
        switch (metodo) {
            case 1:
                OrdenarLista.ordenarBurbuja(this);
                break;
            case 2:
                OrdenarLista.ordenarSeleccion(this);
                break;
            case 3:
                OrdenarLista.ordenarInsercion(this);
                break;
            default:
                System.out.println("Método de ordenamiento no válido.");
        }
    }

    /**
     * Elimina un estudiante por su nombre.
     * 
     * @param nombre Nombre del estudiante a eliminar.
     * @return true si se eliminó correctamente, false si no se encontró.
     */
    public boolean eliminarEstudiante(String nombre) {
        Nodo actual = cabeza;
        Nodo anterior = null;

        while (actual != null) {
            if (actual.estudiante.getNombre().equalsIgnoreCase(nombre)) {
                if (anterior == null) {
                    cabeza = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                return true;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        return false;
    }
}