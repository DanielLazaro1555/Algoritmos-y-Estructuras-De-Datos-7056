package principal;

import controller.GestorTareas;
import view.Menu;

/**
 * Clase principal que inicia la aplicación del Sistema de Gestión de Tareas
 * Pendientes.
 *
 * @author daniel
 */
public class Main {

    /**
     * Método principal que actúa como punto de entrada de la aplicación. Aquí
     * se crea una instancia del GestorTareas y se llama al menú principal para
     * que el usuario pueda interactuar con el sistema.
     *
     * @param args argumentos de la línea de comandos (no utilizados en este
     * programa)
     */
    public static void main(String[] args) {
        // Se crea una instancia del GestorTareas, que gestiona la lógica de las tareas
        GestorTareas gestor = new GestorTareas();
        gestor.cargarTareasDesdeTxt();

        // Se muestra el menú principal de la aplicación para interactuar con el usuario
        Menu.mostrarMenu(gestor);
    }
}
