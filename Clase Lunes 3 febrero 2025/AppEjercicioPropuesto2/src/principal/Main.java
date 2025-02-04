package principal;

import controller.PedidoController;

/**
 *
 * @author daniel
 */
/*
    Problema: Sistema de Gestión de Pedidos para un Restaurante

    Un restaurante requiere un sistema para administrar los pedidos de los clientes, asegurando que 
    se atiendan en el orden correcto y que los clientes puedan modificar o cancelar sus pedidos si es necesario. 
    Se debe implementar una lista doblemente enlazada para gestionar los pedidos, permitiendo un acceso 
    eficiente en ambas direcciones.

    Funcionalidades:
    - Registrar un nuevo pedido en la lista.
    - Cada pedido debe contener:
        • idPedido (entero, único)
        • nombreCliente (cadena)
        • mesa (entero entre 1 y 20)
        • plato (cadena: "Lomo Saltado", "Ceviche", "Arroz Chaufa", "Ají de Gallina", "Seco de Res")
        • estado (cadena: "Pendiente", "En preparación", "Listo para servir")
    - No se pueden registrar dos pedidos con el mismo idPedido.

    Proceso de atención:
    - Atender el primer pedido de la lista y cambiar su estado a "En preparación".
    - Marcar un pedido como "Listo para servir".
    - Eliminar un pedido si el cliente decide cancelarlo.

    Búsqueda y visualización:
    - Buscar un pedido por idPedido y mostrar sus datos.
    - Listar los pedidos en orden de llegada (recorriendo la lista hacia adelante).
    - Mostrar los pedidos en orden inverso (recorriendo la lista hacia atrás).

    Reasignación de pedidos a otro cliente:
    - Si un cliente decide cambiar su pedido a otra mesa, se debe modificar el campo mesa y nombreCliente.
    - La reasignación solo es válida si el pedido aún está en estado "Pendiente".
    - Si el nuevo número de mesa es mayor a 20 o menor a 1, debe mostrar un error.

    Reglas adicionales:
    - Si se intenta registrar un plato que no está en el menú, debe mostrar un error.
    - Solo se pueden marcar como "Listo para servir" los pedidos que ya pasaron a "En preparación".
    - Si un cliente cancela un pedido, debe eliminarse de la lista y actualizar el orden de los demás registros.
    - Si la lista está vacía y se intenta atender un pedido, debe mostrar un mensaje de error.
    - Un pedido solo puede ser reasignado si está en estado "Pendiente".
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PedidoController controller = new PedidoController();
        controller.gestionarMenu();
    }

}
