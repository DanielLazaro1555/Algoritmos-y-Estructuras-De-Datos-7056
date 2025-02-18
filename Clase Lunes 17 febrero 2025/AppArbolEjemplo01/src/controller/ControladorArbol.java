package controller;

import model.ArbolBinario;
import view.VistaArbol;

/**
 *
 * @author Daniel
 */
public class ControladorArbol {
    private ArbolBinario arbol;
    private VistaArbol vista;

    public ControladorArbol(ArbolBinario arbol, VistaArbol vista) {
        this.arbol = arbol;
        this.vista = vista;
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            int opcion = vista.mostrarMenu();
            int valor; // Declaramos 'valor' una sola vez

            switch (opcion) {
                case 1:
                    valor = vista.leerEntero("Ingrese Valor: ");
                    arbol.insertar(valor);
                    vista.mostrarMensaje("Valor " + valor + " insertado correctamente.");
                    break;

                case 2:
                    valor = vista.leerEntero("Ingrese valor a buscar: ");
                    boolean encontrado = arbol.buscar(valor);
                    vista.mostrarMensaje(encontrado ? "El valor existe en el árbol." : "El valor no existe en el árbol.");
                    break;

                case 3:
                    vista.mostrarMensaje("Recorrido en Preorden: ");
                    arbol.preorden();
                    vista.mostrarMensaje("Recorrido en Inorden: ");
                    arbol.inorden();
                    vista.mostrarMensaje("Recorrido en Postorden: ");
                    arbol.postorden();
                    break;

                case 4:
                    valor = vista.leerEntero("Ingrese valor a eliminar: ");
                    arbol.eliminar(valor);
                    vista.mostrarMensaje("Valor " + valor + " eliminado correctamente.");
                    break;

                case 5:
                    salir = true;
                    vista.mostrarMensaje("SALIENDO...");
                    break;

                default:
                    vista.mostrarMensaje("OPCIÓN INVÁLIDA. Intente nuevamente.");
                    break;
            }
        }
    }
}
