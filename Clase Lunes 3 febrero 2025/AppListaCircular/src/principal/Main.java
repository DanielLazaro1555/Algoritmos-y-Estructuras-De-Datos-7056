package principal;

import controller.ListaCircularController;

/**
 * Clase principal que inicia la aplicación de la lista circular.
 *
 * @author daniel
 */
public class Main {

    /**
     * Método principal que sirve como punto de entrada para la aplicación.
     *
     * @param args Argumentos de la línea de comandos (no utilizados en este
     * caso).
     */
    public static void main(String[] args) {
        // Se crea una instancia del controlador que gestiona la lógica del programa
        ListaCircularController controlador = new ListaCircularController();

        // Se llama al método gestionarMenu para iniciar la interacción con el usuario
        controlador.gestionarMenu();
    }
}
