package controller;

/**
 *
 * @author daniel
 */
import model.ColaCircular;
import model.Vehiculo;
import view.Menu;

public class PeajeController {

    private ColaCircular cola;
    private Menu menu;

    public PeajeController() {
        cola = new ColaCircular();
        menu = new Menu();
    }

    public void gestionarMenu() {
        int opcion;
        do {
            opcion = menu.mostrarMenu();
            switch (opcion) {
                case 1:
                    registrarVehiculo();
                    break;
                case 2:
                    atenderVehiculo();
                    break;
                case 3:
                    menu.mostrarMensaje("Cola actual: " + cola.mostrarCola());
                    break;
                case 4:
                    buscarVehiculo();
                    break;
                case 5:
                    menu.mostrarMensaje("Saliendo del sistema...");
                    break;
                default:
                    menu.mostrarMensaje("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private void registrarVehiculo() {
        String placa = menu.pedirPlaca();
        String tipo = menu.pedirTipo().toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u");
        double saldo = menu.pedirSaldo();

        // Validación de tipo de vehículo (permitiendo variantes sin tildes)
        if (!tipo.matches("automovil|camion|moto|bus")) {
            menu.mostrarMensaje("Error: Tipo de vehículo no permitido.");
            return;
        }

        Vehiculo vehiculo = new Vehiculo(placa, tipo, saldo);
        cola.agregarVehiculo(vehiculo);
        menu.mostrarMensaje("Vehículo registrado correctamente.");
    }

    private void atenderVehiculo() {
        Vehiculo atendido = cola.atenderVehiculo();
        if (atendido != null) {
            menu.mostrarMensaje("Vehículo atendido: " + atendido.getPlaca());
        } else {
            menu.mostrarMensaje("No hay vehículos con saldo suficiente o la cola está vacía.");
        }
    }

    private void buscarVehiculo() {
        String placa = menu.pedirPlaca();
        Vehiculo vehiculo = cola.buscarVehiculo(placa);
        if (vehiculo != null) {
            menu.mostrarMensaje("Vehículo encontrado: Placa=" + vehiculo.getPlaca() + ", Tipo=" + vehiculo.getTipo() + ", Saldo=S/" + vehiculo.getSaldoDisponible());
        } else {
            menu.mostrarMensaje("Vehículo no encontrado en la cola.");
        }
    }
}
