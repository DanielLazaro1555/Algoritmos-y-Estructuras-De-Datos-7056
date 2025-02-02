package model;

/**
 *
 * @author daniel
 */
public class ListaEnlazada {

    private Nodo cabeza;

    public Nodo getCabeza() {
        return cabeza;
    }

    public void agregar(Tarea tarea) {
        Nodo nuevo = new Nodo(tarea);
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

    public boolean eliminarTarea(String descripcion) {
        Nodo actual = cabeza;
        Nodo anterior = null;

        while (actual != null) {
            if (actual.tarea.getDescripcion().equalsIgnoreCase(descripcion)) {
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

    public void listarTareas() {
        Nodo actual = cabeza;
        if (actual == null) {
            System.out.println("No hay tareas pendientes.");
            return;
        }

        System.out.println("=== Tareas Pendientes ===");
        while (actual != null) {
            System.out.println("Tarea: " + actual.tarea.getDescripcion() + " | Prioridad: " + actual.tarea.getPrioridad());
            actual = actual.siguiente;
        }
    }

    public Tarea buscarTarea(String descripcion) {
        Nodo actual = cabeza;
        while (actual != null) {
            // Búsqueda flexible: comparación parcial y sin distinción de mayúsculas/minúsculas
            if (actual.tarea.getDescripcion().toLowerCase().contains(descripcion.toLowerCase())) {
                return actual.tarea;
            }
            actual = actual.siguiente;
        }
        return null;
    }

}
