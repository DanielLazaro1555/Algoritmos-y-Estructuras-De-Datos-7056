package principal;

import controller.ControladorArbol;
import model.ArbolBinario;
import view.VistaArbol;

/**
 *
 * @author daniel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        VistaArbol vista = new VistaArbol();
        ControladorArbol controlador = new ControladorArbol(arbol, vista);
        controlador.iniciar();
    }

}
