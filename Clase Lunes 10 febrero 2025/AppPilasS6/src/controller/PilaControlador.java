package controller;

import model.Pila;
import view.Menu;

/**
 *
 * @author daniel
 */
public class PilaControlador {

    private Pila<Integer> pila;
    private Menu vista;

    public PilaControlador() {
        this.pila = new Pila<>();
        this.vista = new Menu();
    }

    public void ejecutar() {
        boolean continuar = true;

        while (continuar) {
            int opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    int elemento = vista.obtenerElemento();
                    pila.push(elemento);
                    vista.mostrarMensaje("Elemento agregado: " + elemento);
                    break;
                case 2:
                    // Cambiado a Integer para evitar NullPointerException
                    Integer eliminado = pila.pop();
                    vista.mostrarMensaje(eliminado != null ? "Elemento eliminado: " + eliminado : "La pila está vacía");
                    break;
                case 3:
                    Integer tope = pila.peek();
                    vista.mostrarMensaje(tope != null ? "Elemento en el tope: " + tope : "La pila está vacía");
                    break;
                case 4:
                    vista.mostrarMensaje(pila.isEmpty() ? "La pila está vacía" : "La pila no está vacía");
                    break;
                case 5:
                    vista.mostrarMensaje("Tamaño de la pila: " + pila.size());
                    break;
                case 6:
                    // Verifica si la pila tiene un método toString() adecuado
                    vista.mostrarMensaje(pila.toString());
                    break;
                case 7:
                    continuar = false;
                    vista.mostrarMensaje("Saliendo del programa...");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida");
            }
        }
    }
}
