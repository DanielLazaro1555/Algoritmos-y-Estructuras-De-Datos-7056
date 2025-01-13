package clases;

import java.util.Scanner; // Importamos Scanner para leer entradas del usuario

/**
 * Clase que gestiona el flujo principal del programa para administrar calificaciones.
 * Proporciona un menú interactivo que permite al usuario realizar diversas operaciones
 * sobre las calificaciones, como agregar, actualizar, eliminar, mostrar y calcular estadísticas.
 * 
 * @author daniel
 */
public class GestorCalificaciones {
    
    private final Calificaciones listaCalificaciones; // Instancia de la clase Calificaciones para almacenar las calificaciones
    private final Scanner entrada; // Scanner para leer las entradas del usuario
    
    /**
     * Constructor que inicializa las calificaciones y el lector de entrada.
     */
    public GestorCalificaciones() {
        this.listaCalificaciones = new Calificaciones(10); // Inicializamos la lista con capacidad de 10 calificaciones
        this.entrada = new Scanner(System.in); // Inicializamos el Scanner
    }
    
    /**
     * Método principal que inicia el programa con un menú interactivo.
     */
    public void iniciar() {
        while (true) { // Bucle infinito para mantener el programa en ejecución
            mostrarMenu(); // Mostramos el menú
            int opcion = obtenerOpcion(); // Obtenemos la opción del usuario
            procesarOpcion(opcion); // Procesamos la opción seleccionada
        }
    }
    
    /**
     * Muestra el menú principal al usuario.
     */
    private void mostrarMenu() {
        System.out.println("***************** Gestión de Calificaciones *****************");
        System.out.println("1. Agregar Calificación");
        System.out.println("2. Actualizar Calificación");
        System.out.println("3. Eliminar Calificación");
        System.out.println("4. Mostrar Calificaciones");
        System.out.println("5. Calcular Estadísticas");
        System.out.println("6. Salir");
        System.out.println("Ingrese Opción: ");
    }
    
    /**
     * Lee la opción ingresada por el usuario.
     * 
     * @return La opción seleccionada.
     */
    private int obtenerOpcion() {
        return entrada.nextInt(); // Retorna el número ingresado por el usuario
    }
    
    /**
     * Procesa la opción seleccionada y llama al método correspondiente.
     * 
     * @param opcion La opción ingresada por el usuario.
     */
    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1: 
                agregarCalificacion(); // Llamamos al método para agregar una calificación
                break;
            case 2: 
                actualizarCalificacion(); // Llamamos al método para actualizar una calificación
                break;
            case 3: 
                eliminarCalificacion(); // Llamamos al método para eliminar una calificación
                break;
            case 4: 
                mostrarCalificaciones(); // Llamamos al método para mostrar las calificaciones
                break;
            case 5: 
                calcularEstadisticas(); // Llamamos al método para calcular estadísticas
                break;
            case 6: 
                salir(); // Finalizamos el programa
                break;
            default: 
                System.out.println("Opción Inválida"); // Mensaje de error para opciones no válidas
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
