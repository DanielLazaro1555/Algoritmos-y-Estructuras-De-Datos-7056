package controller;

import model.Estudiante;
import model.ListaEnlazada;
import model.Nodo;

/**
 *
 * @author daniel
 */
public class GestorEstudiantes {
    private ListaEnlazada lista;

    public GestorEstudiantes() {
        lista = new ListaEnlazada();
    }

    // Agrega un nuevo estudiante a la lista
    public void agregarEstudiante(String nombre, int[] calificaciones) {
        Estudiante estudiante = new Estudiante(nombre, calificaciones);
        lista.agregar(estudiante);
    }

    // Muestra la lista de estudiantes registrados
    public void mostrarEstudiantes() {
        Nodo actual = lista.getCabeza();
        if (actual == null) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        while (actual != null) {
            Estudiante est = actual.estudiante;
            System.out.print("Nombre: " + est.getNombre() + " | Promedio: " + est.getPromedio() + " | Calificaciones: ");
            for (int nota : est.getCalificaciones()) {
                System.out.print(nota + " ");
            }
            System.out.println();
            actual = actual.siguiente;
        }
    }

    // Busca un estudiante por su nombre
    public void buscarEstudiante(String nombre) {
        Nodo actual = lista.getCabeza();
        boolean encontrado = false;

        while (actual != null) {
            if (actual.estudiante.getNombre().equalsIgnoreCase(nombre)) {
                Estudiante est = actual.estudiante;
                System.out.println("Estudiante encontrado: Nombre: " + est.getNombre() + " | Promedio: " + est.getPromedio());
                encontrado = true;
                break;
            }
            actual = actual.siguiente;
        }

        if (!encontrado) {
            System.out.println("Estudiante no encontrado.");
        }
    }

    // Elimina un estudiante por su nombre y reordena la lista si fue eliminado
    public void eliminarEstudiante(String nombre) {
        boolean eliminado = lista.eliminarEstudiante(nombre); // Ahora devuelve true o false
        if (eliminado) {
            lista.ordenarPorPromedio(1); // Reordenar automáticamente usando burbuja por defecto
            System.out.println("Estudiante eliminado exitosamente.");
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

    // Ordena la lista de estudiantes por su promedio usando el método seleccionado
    public void ordenarPorPromedio(int metodo) {
        lista.ordenarPorPromedio(metodo);
        System.out.println("Estudiantes ordenados por promedio.");
    }
}