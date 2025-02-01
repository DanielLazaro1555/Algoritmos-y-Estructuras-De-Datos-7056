package clases;

import java.util.HashSet;

/**
 *
 * @author daniel
 */
public class ListaEnlazada {

    private Nodo head; // Nodo principal (cabeza de la lista)
    private int size;  // Tamaño actual de la lista
    private static final int MAX_SIZE = 50; // Tamaño máximo de la lista
    private HashSet<String> nombresExistentes; // Conjunto para evitar empleados duplicados por nombre

    // Constructor
    public ListaEnlazada() {
        this.head = null;
        this.size = 0;
        this.nombresExistentes = new HashSet<>();
    }

    // Verifica si la lista está vacía
    public boolean estaVacia() {
        return head == null;
    }

    // Retorna el tamaño de la lista
    public int getTamaño() {
        return size;
    }

    // Inserta un empleado al inicio de la lista
    public void insertarAlInicio(Empleado empleado) {
        validarEmpleado(empleado);

        Nodo nuevoNodo = new Nodo(empleado);
        nuevoNodo.setSiguiente(head);
        head = nuevoNodo;

        nombresExistentes.add(empleado.getNombre());
        size++;
    }

    // Inserta un empleado al final de la lista
    public void insertarAlFinal(Empleado empleado) {
        validarEmpleado(empleado);

        Nodo nuevoNodo = new Nodo(empleado);
        if (head == null) {
            head = nuevoNodo;
        } else {
            Nodo actual = head;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        nombresExistentes.add(empleado.getNombre());
        size++;
    }

    // Inserta un empleado en una posición específica
    public void insertarEnPosicion(Empleado empleado, int posicion) {
        validarEmpleado(empleado);

        if (posicion < 0 || posicion > size) {
            throw new IllegalArgumentException("Posición fuera de rango");
        }

        if (posicion == 0) {
            insertarAlInicio(empleado);
        } else {
            Nodo actual = head;
            for (int i = 0; i < posicion - 1; i++) {
                actual = actual.getSiguiente();
            }
            Nodo nuevoNodo = new Nodo(empleado);
            nuevoNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);

            nombresExistentes.add(empleado.getNombre());
            size++;
        }
    }

    // Elimina el primer nodo de la lista
    public void eliminarPrimero() {
        if (estaVacia()) {
            throw new IllegalStateException("La lista está vacía");
        }
        nombresExistentes.remove(head.getEmpleado().getNombre());
        head = head.getSiguiente();
        size--;
    }

    // Elimina el último nodo de la lista
    public void eliminarUltimo() {
        if (estaVacia()) {
            throw new IllegalStateException("La lista está vacía");
        }
        if (head.getSiguiente() == null) {
            nombresExistentes.remove(head.getEmpleado().getNombre());
            head = null;
        } else {
            Nodo actual = head;
            while (actual.getSiguiente().getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            nombresExistentes.remove(actual.getSiguiente().getEmpleado().getNombre());
            actual.setSiguiente(null);
        }
        size--;
    }

    // Elimina un nodo en una posición específica
    public void eliminarEnPosicion(int posicion) {
        if (estaVacia()) {
            throw new IllegalStateException("La lista está vacía");
        }
        if (posicion < 0 || posicion >= size) {
            throw new IllegalArgumentException("Posición fuera de rango");
        }
        if (posicion == 0) {
            eliminarPrimero();
        } else {
            Nodo actual = head;
            for (int i = 0; i < posicion - 1; i++) {
                actual = actual.getSiguiente();
            }
            nombresExistentes.remove(actual.getSiguiente().getEmpleado().getNombre());
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
            size--;
        }
    }

    // Muestra todos los empleados en la lista
    public void mostrarLista() {
        if (estaVacia()) {
            System.out.println("La lista está vacía");
            return;
        }

        Nodo actual = head;
        while (actual != null) {
            System.out.println(actual.getEmpleado());
            actual = actual.getSiguiente();
        }
    }

    // Valida que el empleado cumpla con ciertas condiciones antes de agregarlo
    public void validarEmpleado(Empleado empleado) {
        if (empleado.getNombre() == null || empleado.getNombre().length() < 3) {
            throw new IllegalArgumentException("El nombre debe tener al menos 3 caracteres");
        }
        if (empleado.getPuesto() == null || empleado.getPuesto().isEmpty()) {
            throw new IllegalArgumentException("El puesto del empleado no debe estar vacío");
        }
        if (nombresExistentes.contains(empleado.getNombre())) {
            throw new IllegalArgumentException("Ya existe un empleado con este nombre");
        }
        if (size >= MAX_SIZE) {
            throw new IllegalStateException("La lista no puede tener más de " + MAX_SIZE + " empleados");
        }
    }
}
