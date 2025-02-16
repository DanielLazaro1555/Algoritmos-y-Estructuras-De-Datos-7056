package principal;

import controller.ColaController;

/**
 *
 * @author daniel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ColaController controlador = new ColaController();
        controlador.iniciar();
    }

}
