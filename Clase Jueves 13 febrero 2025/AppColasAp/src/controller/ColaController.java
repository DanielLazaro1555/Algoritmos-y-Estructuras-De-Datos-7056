package controller;

import model.Cola;
import view.Menu;

/**
 *
 * @author daniel
 */
public class ColaController {

    private Cola<String> cola;
    private Menu menu;

    public ColaController() {
        cola = new Cola<>();
        menu = new Menu();
    }

    public void iniciar() {
        int opcion;
        do {
            menu.mostrarMenu();
            opcion = menu.leerOpcion();

            switch (opcion) {
                case 1:
                    String dato = menu.leerDato();
                    cola.enqueue(dato);
                    menu.mostrarMensaje("Elemento insertado");
                    break;
                case 2:
                    String eliminado = cola.dequeue();
                    menu.mostrarMensaje(eliminado != null ? "Elemento eliminado: " + eliminado : "Cola vacia");
                    break;
                case 3:
                    String frente = cola.peek();
                    menu.mostrarMensaje(frente != null ? "Frente de la cola: " + frente : "La cola esta vacia");
                    break;
                case 4:
                    cola.mostrarCola();
                    break;
                case 5:
                    menu.mostrarMensaje("Saliendo del programa");
                    break;
                default:
                    menu.mostrarMensaje("Opcion no valida");
            }
        } while (opcion != 5);
    }
}
