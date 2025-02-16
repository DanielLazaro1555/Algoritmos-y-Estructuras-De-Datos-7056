package controller;
import model.Cliente;
import model.ColaPrioritaria;
import view.Menu;

/**
 *
 * @author daniel
 */
public class ColaController {
    private ColaPrioritaria cola;
    private Menu vista;
    private int ticketActual;

    public ColaController() {
        this.cola = new ColaPrioritaria();
        this.vista = new Menu();
        this.ticketActual = 1;
    }

    public void ejecutar() {
        boolean continuar = true;
        while (continuar) {
            int opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    String nombre = vista.obtenerNombre();
                    boolean esVIP = vista.esVIP();
                    Cliente nuevoCliente = new Cliente(nombre, ticketActual++, esVIP);
                    cola.encolar(nuevoCliente);
                    vista.mostrarMensaje("Cliente registrado: " + nuevoCliente);
                    break;
                case 2:
                    Cliente atendido = cola.desencolar();
                    vista.mostrarMensaje(atendido != null ? "Atendiendo a: " + atendido : "No hay clientes en la cola.");
                    break;
                case 3:
                    Cliente siguiente = cola.verSiguiente();
                    vista.mostrarMensaje(siguiente != null ? "Siguiente cliente: " + siguiente : "La cola está vacía.");
                    break;
                case 4:
                    cola.mostrarCola();
                    break;
                case 5:
                    vista.mostrarMensaje("Clientes en espera: " + cola.contarClientes());
                    break;
                case 6:
                    cola.vaciarCola();
                    vista.mostrarMensaje("Cola vaciada.");
                    break;
                case 7:
                    continuar = false;
                    vista.mostrarMensaje("Saliendo del programa...");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida.");
            }
        }
    }
}