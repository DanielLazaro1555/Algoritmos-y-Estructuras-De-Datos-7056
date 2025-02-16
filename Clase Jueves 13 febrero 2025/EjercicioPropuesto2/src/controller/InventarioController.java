package controller;

import model.*;
import view.Menu;

/**
 *
 * @author daniel
 */
public class InventarioController {

    private PilaInventario inventario;
    private ColaPedidos pedidos;
    private ColaPedidos reposiciones;
    private Menu vista;
    private int idProducto;

    public InventarioController() {
        this.inventario = new PilaInventario();
        this.pedidos = new ColaPedidos();
        this.reposiciones = new ColaPedidos();
        this.vista = new Menu();
        this.idProducto = 1;
    }

    public void ejecutar() {
        boolean continuar = true;
        while (continuar) {
            int opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    String nombre = vista.obtenerNombreProducto();
                    double precio = vista.obtenerPrecioProducto();
                    Producto nuevoProducto = new Producto(idProducto++, nombre, precio);
                    inventario.push(nuevoProducto);
                    vista.mostrarMensaje("Producto agregado al inventario: " + nuevoProducto);
                    break;
                case 2:
                    Producto eliminado = inventario.pop();
                    vista.mostrarMensaje(eliminado != null ? "Producto eliminado: " + eliminado : "Inventario vacío.");
                    break;
                case 3:
                    vista.mostrarMensaje("Último producto agregado: " + inventario.peek());
                    break;
                case 4:
                    inventario.mostrarInventario();
                    break;
                case 5:
                    vista.mostrarMensaje("Cantidad de productos en inventario: " + inventario.contarProductos());
                    break;
                case 6:
                    continuar = false;
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida.");
            }
        }
    }
}
