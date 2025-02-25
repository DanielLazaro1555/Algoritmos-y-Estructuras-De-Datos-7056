package principal;

import view.Menu;

/**
 *
 * @author daniel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("🚀 Sistema de Gestión de Productos Iniciado 🚀");
        Menu menu = new Menu();
        menu.mostrarMenu();
        System.out.println("👋 Programa finalizado.");
    }

}
