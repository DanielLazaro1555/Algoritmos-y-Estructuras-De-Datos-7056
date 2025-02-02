package controller;

import model.ListaEnlazada;
import model.Tarea;
import model.Nodo;
import clases.ValidadorTareas;
import clases.Prioridad;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
/**
 * Clase que gestiona las operaciones del sistema de tareas pendientes.
 */
public class GestorTareas {

    private ListaEnlazada lista;
    private Scanner scanner = new Scanner(System.in);

    public GestorTareas() {
        lista = new ListaEnlazada();
    }

    // Método para agregar una tarea con validación de datos
    public void agregarTarea(String descripcion, String prioridad) {
        imprimirLineaDecorativa();
        if (!ValidadorTareas.validarDescripcion(descripcion)) {
            System.out.println("⚠️  La descripción de la tarea no puede estar vacía.");
            pausar();
            return;
        }
        if (!ValidadorTareas.validarPrioridad(prioridad)) {
            System.out.println("⚠️  Prioridad no válida. Debe ser Alta, Media o Baja.");
            pausar();
            return;
        }
        lista.agregar(new Tarea(descripcion, prioridad));
        System.out.println("✅ Tarea agregada exitosamente.");
        imprimirLineaDecorativa();
        pausar();
    }

    // Método para listar todas las tareas pendientes
    public void listarTareas() {
        imprimirLineaDecorativa();
        lista.listarTareas();
        imprimirLineaDecorativa();
        pausar();
    }

    // Método para completar (eliminar) una tarea con sugerencias de coincidencias parciales
    public void completarTarea(String descripcion) {
        imprimirLineaDecorativa();
        Tarea tarea = lista.buscarTarea(descripcion);
        if (tarea != null) {
            lista.eliminarTarea(tarea.getDescripcion());
            System.out.println("✅ Tarea completada y eliminada exitosamente: " + tarea.getDescripcion());
        } else {
            System.out.println("❌ Tarea no encontrada.");
            sugerirTareasSimilares(descripcion);
        }
        imprimirLineaDecorativa();
        pausar();
    }

    // Método para sugerir tareas similares si no se encuentra una coincidencia exacta
    private void sugerirTareasSimilares(String descripcion) {
        System.out.println("🔍 ¿Quizás quisiste decir?");
        Nodo actual = lista.getCabeza();
        boolean encontrado = false;
        while (actual != null) {
            if (actual.tarea.getDescripcion().toLowerCase().contains(descripcion.toLowerCase())) {
                System.out.println("- " + actual.tarea.getDescripcion() + " | Prioridad: " + actual.tarea.getPrioridad());
                encontrado = true;
            }
            actual = actual.siguiente;
        }
        if (!encontrado) {
            System.out.println("❗ No se encontraron tareas similares.");
        }
    }

    // Método para buscar una tarea por su descripción
    public void buscarTarea(String descripcion) {
        imprimirLineaDecorativa();
        Tarea tarea = lista.buscarTarea(descripcion);
        if (tarea != null) {
            System.out.println("🔎 Tarea encontrada:");
            System.out.println("📋 " + tarea.getDescripcion() + " | ⏫ Prioridad: " + tarea.getPrioridad());
        } else {
            System.out.println("❌ Tarea no encontrada.");
            sugerirTareasSimilares(descripcion);
        }
        imprimirLineaDecorativa();
        pausar();
    }

    // Método para imprimir una línea decorativa
    private void imprimirLineaDecorativa() {
        System.out.println("=====================================");
    }

    // Método para pausar la ejecución y esperar una tecla
    private void pausar() {
        System.out.println("Presiona Enter para continuar...");
        scanner.nextLine();
        limpiarPantalla();
    }

    // Método para simular la limpieza de pantalla
    private void limpiarPantalla() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
}
