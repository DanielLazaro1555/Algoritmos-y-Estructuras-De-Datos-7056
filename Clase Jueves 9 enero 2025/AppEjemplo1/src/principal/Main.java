package principal;

import clases.GestorCalificaciones; // Importamos la clase GestorCalificaciones

/**
 * Clase principal que inicia el programa.
 * Aquí es donde se crea una instancia del gestor de calificaciones
 * y se llama al método para iniciar la aplicación.
 * 
 * @author daniel
 */
public class Main {

    /**
     * Método principal que sirve como punto de entrada del programa.
     * 
     * @param args Argumentos de línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        
        // Creamos una instancia del GestorCalificaciones
        GestorCalificaciones gestor = new GestorCalificaciones();
        
        // Iniciamos la gestión de calificaciones mediante el menú interactivo
        gestor.iniciar();
    }
}
