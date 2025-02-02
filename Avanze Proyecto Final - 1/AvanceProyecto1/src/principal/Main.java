package principal;

import controller.GestorTareas;
import view.Menu;

/**
 *
 * @author daniel
 */
public class Main {

    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();
        Menu.mostrarMenu(gestor);
    }
}
