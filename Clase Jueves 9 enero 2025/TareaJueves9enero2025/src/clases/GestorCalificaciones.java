package clases;

import java.util.Scanner;

/**
 * Clase que gestiona el flujo principal del programa.
 */
public class GestorCalificaciones {
    private final Calificaciones listaCalificaciones; // Instancia de Calificaciones
    private final Scanner entrada; // Para leer las entradas del usuario

    // Constructor que acepta la capacidad dinámica
    public GestorCalificaciones(int capacidad) {
        this.listaCalificaciones = new Calificaciones(capacidad);
        this.entrada = new Scanner(System.in);
    }

    // Método principal para iniciar el programa
    public void iniciar() {
        while (true) {
            mostrarMenu();
            int opcion = obtenerOpcion();
            procesarOpcion(opcion);
        }
    }

    // Menú modificado con nuevas opciones
    private void mostrarMenu() {
        System.out.println("***************** Gestión de Calificaciones *****************");
        System.out.println("1. Agregar Calificación");
        System.out.println("2. Actualizar Calificación");
        System.out.println("3. Eliminar Calificación");
        System.out.println("4. Mostrar Calificaciones");
        System.out.println("5. Calcular Estadísticas");
        System.out.println("6. Buscar Calificación"); // Nueva opción
        System.out.println("7. Mostrar Calificaciones Ordenadas"); // Nueva opción
        System.out.println("8. Salir");
        System.out.println("Ingrese Opción: ");
    }

    private int obtenerOpcion() {
        return entrada.nextInt();
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                agregarCalificacion();
                break;
            case 2:
                actualizarCalificacion();
                break;
            case 3:
                eliminarCalificacion();
                break;
            case 4:
                mostrarCalificaciones();
                break;
            case 5:
                calcularEstadisticas();
                break;
            case 6:
                buscarCalificacion(); // Nueva funcionalidad
                break;
            case 7:
                mostrarCalificacionesOrdenadas(); // Nueva funcionalidad
                break;
            case 8:
                salir();
                break;
            default:
                System.out.println("Opción Inválida");
        }
    }

    /**
     * Agrega una nueva calificación ingresada por el usuario.
     */
    private void agregarCalificacion() {
        System.out.println("Ingrese Calificación: ");
        int calificacion = entrada.nextInt(); // Leemos la calificación del usuario
        if (listaCalificaciones.agregar(calificacion)) { // Intentamos agregar la calificación
            System.out.println("Calificación Agregada");
        } else {
            System.out.println("Capacidad máxima alcanzada"); // Si no hay espacio, mostramos un mensaje
        }
    }
    
    /**
     * Actualiza una calificación existente en un índice dado.
     */
    private void actualizarCalificacion() {
        System.out.println("Ingrese Índice de Calificación a Actualizar: ");
        int indice = entrada.nextInt(); // Leemos el índice del usuario
        System.out.println("Ingrese Nueva Nota: ");
        int nuevoValor = entrada.nextInt(); // Leemos el nuevo valor
        if (listaCalificaciones.actualizar(indice, nuevoValor)) { // Intentamos actualizar
            System.out.println("Calificación Actualizada");
        } else {
            System.out.println("Índice Inválido"); // Si el índice no es válido, mostramos un mensaje
        }
    }
    
    /**
     * Elimina una calificación existente en un índice dado.
     */
    private void eliminarCalificacion() {
        System.out.println("Ingrese Índice de Calificación a Eliminar: ");
        int indice = entrada.nextInt(); // Leemos el índice del usuario
        if (listaCalificaciones.eliminar(indice)) { // Intentamos eliminar
            System.out.println("Calificación Eliminada");
        } else {
            System.out.println("Índice Inválido"); // Si el índice no es válido, mostramos un mensaje
        }
    }
    
    /**
     * Muestra todas las calificaciones almacenadas.
     */
    private void mostrarCalificaciones() {
        listaCalificaciones.mostrar(); // Llamamos al método mostrar de la clase Calificaciones
    }

    /**
     * Busca una calificación específica ingresada por el usuario.
     */
    private void buscarCalificacion() {
        System.out.println("Ingrese la Calificación a Buscar: ");
        int calificacion = entrada.nextInt(); // Leemos la calificación a buscar
        int indice = listaCalificaciones.buscarCalificacion(calificacion); // Buscamos la calificación
        if (indice != -1) {
            System.out.println("Calificación encontrada en el índice: " + indice);
        } else {
            System.out.println("Calificación no encontrada");
        }
    }

    /**
     * Muestra todas las calificaciones ordenadas en orden ascendente.
     */
    private void mostrarCalificacionesOrdenadas() {
        listaCalificaciones.mostrarOrdenadas(); // Ordenamos y mostramos las calificaciones
    }
    
    /**
     * Calcula y muestra estadísticas básicas sobre las calificaciones.
     */
    private void calcularEstadisticas() {
        listaCalificaciones.mostrarEstadisticas(); // Llamamos al método mostrarEstadisticas de la clase Calificaciones
    }
    
    /**
     * Finaliza el programa.
     */
    private void salir() {
        System.out.println("Saliendo Del Programa");
        System.exit(0); // Finalizamos el programa con el código de salida 0
    }
}
