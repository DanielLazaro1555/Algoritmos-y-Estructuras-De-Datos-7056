package controller;

import model.ListaCircularModel;
import view.Menu;

/**
 * Controlador de la lista circular que gestiona la interacción entre la vista
 * (Menu) y el modelo (ListaCircularModel).
 *
 * @author daniel
 */
public class ListaCircularController {

    // Atributos del controlador: modelo (lógica de la lista) y vista (interfaz de usuario)
    private ListaCircularModel modelo;
    private Menu vista;

    /**
     * Constructor de la clase que inicializa el modelo y la vista.
     */
    public ListaCircularController() {
        modelo = new ListaCircularModel();
        vista = new Menu();
    }

    /**
     * Método principal para gestionar el menú de la aplicación. Permite al
     * usuario seleccionar opciones para manipular la lista circular.
     */
    public void gestionarMenu() {
        int opcion;

        // Bucle que muestra el menú hasta que el usuario elige salir (opción 6)
        do {
            opcion = vista.mostrarMenu(); // Muestra el menú y obtiene la opción del usuario

            // Estructura switch para gestionar las diferentes opciones del menú
            switch (opcion) {
                case 1: // Insertar elemento al inicio de la lista
                    int datoInicio = vista.pedirDato(); // Solicita el dato al usuario
                    modelo.insertarInicio(datoInicio); // Inserta el dato al inicio de la lista
                    break;

                case 2: // Insertar elemento al final de la lista
                    int datoFinal = vista.pedirDato(); // Solicita el dato al usuario
                    modelo.insertarFinal(datoFinal); // Inserta el dato al final de la lista
                    break;

                case 3: // Eliminar el primer elemento de la lista
                    modelo.eliminarInicio();
                    break;

                case 4: // Eliminar el último elemento de la lista
                    modelo.eliminarFinal();
                    break;

                case 5: // Recorrer la lista y mostrar sus elementos
                    String lista = modelo.recorrer();
                    vista.mostrarLista("Recorrido de la lista: " + lista);
                    break;

                case 6: // Salir del programa
                    vista.mostrarResultado("Saliendo...");
                    break;

                default: // Opción inválida
                    vista.mostrarResultado("Opción inválida. Intenta de nuevo.");
            }
        } while (opcion != 6); // El bucle continúa hasta que el usuario elige la opción 6 (salir)
    }
}
