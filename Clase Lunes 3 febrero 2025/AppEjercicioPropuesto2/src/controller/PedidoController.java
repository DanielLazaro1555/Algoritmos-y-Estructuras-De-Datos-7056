package controller;

import model.ListaDobleEnlazada;
import model.Pedido;
import view.Menu;

/**
 * Controlador para gestionar los pedidos del restaurante. Permite registrar,
 * atender, cancelar, buscar y reasignar pedidos.
 *
 * @author Daniel
 */
public class PedidoController {

    private ListaDobleEnlazada lista;
    private Menu menu;

    public PedidoController() {
        lista = new ListaDobleEnlazada();
        menu = new Menu();
    }

    public void gestionarMenu() {
        int opcion;
        do {
            opcion = menu.mostrarMenu();
            switch (opcion) {
                case 1:
                    registrarPedido();
                    break;
                case 2:
                    atenderPedido();
                    break;
                case 3:
                    marcarPedidoListo();
                    break;
                case 4:
                    cancelarPedido();
                    break;
                case 5:
                    buscarPedido();
                    break;
                case 6:
                    menu.mostrarMensaje(lista.listarPedidos(false)); // Listar en orden normal
                    break;
                case 7:
                    menu.mostrarMensaje(lista.listarPedidos(true));  // Listar en orden inverso
                    break;
                case 8:
                    reasignarPedido();
                    break;
                case 9:
                    menu.mostrarMensaje("👋 Saliendo del sistema...");
                    break;
                default:
                    menu.mostrarMensaje("⚠️  Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 9);
    }

    // ✅ Validación del plato para asegurarse que esté en el menú permitido
    private boolean esPlatoValido(String plato) {
        String[] menuPlatos = {"Lomo Saltado", "Ceviche", "Arroz Chaufa", "Ají de Gallina", "Seco de Res"};
        for (String item : menuPlatos) {
            if (item.equalsIgnoreCase(plato)) {
                return true;
            }
        }
        return false;
    }

    // ✅ Registrar un nuevo pedido
    private void registrarPedido() {
        int id = menu.pedirIdPedido();
        String cliente = menu.pedirNombreCliente();
        int mesa = menu.pedirMesa();
        String plato = menu.pedirPlato();

        // Validación del plato
        if (!esPlatoValido(plato)) {
            menu.mostrarMensaje("⚠️  Error: El plato ingresado no está en el menú.");
            return;
        }

        Pedido pedido = new Pedido(id, cliente, mesa, plato);
        lista.agregarPedido(pedido);
        menu.mostrarMensaje("✅ Pedido registrado exitosamente.");
    }

    // ✅ Atender el primer pedido de la lista
    private void atenderPedido() {
        Pedido pedido = lista.atenderPedido();
        if (pedido != null) {
            menu.mostrarMensaje("🍽️ Pedido " + pedido.getIdPedido() + " está en preparación.");
        } else {
            menu.mostrarMensaje("⚠️  No hay pedidos para atender.");
        }
    }

    // ✅ Marcar un pedido como "Listo para servir"
    private void marcarPedidoListo() {
        int id = menu.pedirIdPedido();
        lista.marcarListo(id);
    }

    // ✅ Cancelar un pedido
    private void cancelarPedido() {
        int id = menu.pedirIdPedido();
        lista.cancelarPedido(id);
    }

    // ✅ Buscar un pedido por ID
    private void buscarPedido() {
        int id = menu.pedirIdPedido();
        Pedido pedido = lista.buscarPedido(id);
        if (pedido != null) {
            menu.mostrarMensaje("📋 Pedido encontrado:\n"
                    + "ID: " + pedido.getIdPedido()
                    + ", Cliente: " + pedido.getNombreCliente()
                    + ", Mesa: " + pedido.getMesa()
                    + ", Plato: " + pedido.getPlato()
                    + ", Estado: " + pedido.getEstado());
        } else {
            menu.mostrarMensaje("⚠️  Pedido no encontrado.");
        }
    }

    // ✅ Reasignar un pedido a otra mesa (solo si está pendiente)
    private void reasignarPedido() {
        int id = menu.pedirIdPedido();
        Pedido pedido = lista.buscarPedido(id);

        if (pedido != null && pedido.getEstado().equals("Pendiente")) {
            String nuevoNombre = menu.pedirNuevoNombreCliente();
            int nuevaMesa = menu.pedirNuevaMesa();

            if (nuevaMesa < 1 || nuevaMesa > 20) {
                menu.mostrarMensaje("⚠️  Error: El número de mesa debe estar entre 1 y 20.");
                return;
            }

            pedido.setNombreCliente(nuevoNombre);
            pedido.setMesa(nuevaMesa);
            menu.mostrarMensaje("✅ Pedido reasignado correctamente.");
        } else if (pedido == null) {
            menu.mostrarMensaje("⚠️  Pedido no encontrado.");
        } else {
            menu.mostrarMensaje("⚠️  Solo se pueden reasignar pedidos en estado 'Pendiente'.");
        }
    }
}
