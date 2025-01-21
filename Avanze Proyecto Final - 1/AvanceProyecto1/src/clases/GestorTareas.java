/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.LinkedList;
import java.util.Comparator;
/**
 *
 * @author daniel
 */

public class GestorTareas {
    private LinkedList<Tarea> listaTareas;

    public GestorTareas() {
        listaTareas = new LinkedList<>();
    }

    public void agregarTarea(String descripcion, int prioridad) {
        Tarea nuevaTarea = new Tarea(descripcion, prioridad);
        listaTareas.add(nuevaTarea);
        listaTareas.sort(Comparator.comparingInt(Tarea::getPrioridad));
    }

    public void mostrarTareas() {
        if (listaTareas.isEmpty()) {
            System.out.println("No hay tareas pendientes.");
        } else {
            System.out.println("Tareas pendientes:");
            for (Tarea tarea : listaTareas) {
                System.out.println("Prioridad: " + tarea.getPrioridad() + " - Descripción: " + tarea.getDescripcion());
            }
        }
    }

    public void completarTarea() {
        if (listaTareas.isEmpty()) {
            System.out.println("No hay tareas para completar.");
        } else {
            Tarea completada = listaTareas.removeFirst();
            System.out.println("Tarea completada: " + completada.getDescripcion());
        }
    }
}
