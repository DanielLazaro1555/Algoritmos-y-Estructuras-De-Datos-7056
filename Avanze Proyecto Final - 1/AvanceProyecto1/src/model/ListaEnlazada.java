package model;

/**
 * Clase que representa una Lista Enlazada para gestionar tareas pendientes en
 * el sistema. Cada nodo de la lista contiene una tarea y una referencia al
 * siguiente nodo.
 *
 * @author daniel
 */
public class ListaEnlazada {

    private Nodo cabeza; // Referencia al primer nodo de la lista enlazada

    /**
     * Obtiene la cabeza de la lista enlazada.
     *
     * @return El primer nodo de la lista.
     */
    public Nodo getCabeza() {
        return cabeza;
    }

    /**
     * Agrega una nueva tarea al final de la lista enlazada.
     *
     * @param tarea La tarea que se va a agregar.
     */
    public void agregar(Tarea tarea) {
        Nodo nuevo = new Nodo(tarea);
        if (cabeza == null) {
            cabeza = nuevo; // Si la lista está vacía, el nuevo nodo se convierte en la cabeza
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente; // Avanza hasta el último nodo
            }
            actual.siguiente = nuevo; // Enlaza el nuevo nodo al final de la lista
        }
    }

    /**
     * Elimina una tarea de la lista basada en su descripción.
     *
     * @param descripcion La descripción de la tarea a eliminar.
     * @return true si la tarea fue eliminada, false si no se encontró.
     */
    public boolean eliminarTarea(String descripcion) {
        Nodo actual = cabeza;
        Nodo anterior = null;

        while (actual != null) {
            if (actual.tarea.getDescripcion().equalsIgnoreCase(descripcion)) {
                if (anterior == null) {
                    cabeza = actual.siguiente; // Elimina la cabeza si es la tarea buscada
                } else {
                    anterior.siguiente = actual.siguiente; // Reenlaza para eliminar el nodo
                }
                return true; // Tarea encontrada y eliminada
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        return false; // Tarea no encontrada
    }

    /**
     * Lista todas las tareas pendientes en la consola.
     */
    public void listarTareas() {
        Nodo actual = cabeza;
        if (actual == null) {
            System.out.println("No hay tareas pendientes.");
            return;
        }

        System.out.println("=== Tareas Pendientes ===");
        while (actual != null) {
            System.out.println("Tarea: " + actual.tarea.getDescripcion() + " | Prioridad: " + actual.tarea.getPrioridad());
            actual = actual.siguiente; // Avanza al siguiente nodo
        }
    }

    /**
     * Busca una tarea en la lista por una coincidencia parcial de la
     * descripción.
     *
     * @param descripcion La descripción (o parte de ella) de la tarea a buscar.
     * @return La tarea encontrada o null si no se encuentra.
     */
    public Tarea buscarTarea(String descripcion) {
        Nodo actual = cabeza;
        while (actual != null) {
            // Búsqueda flexible: comparación parcial y sin distinción de mayúsculas/minúsculas
            if (actual.tarea.getDescripcion().toLowerCase().contains(descripcion.toLowerCase())) {
                return actual.tarea;
            }
            actual = actual.siguiente;
        }
        return null; // Tarea no encontrada
    }
}
