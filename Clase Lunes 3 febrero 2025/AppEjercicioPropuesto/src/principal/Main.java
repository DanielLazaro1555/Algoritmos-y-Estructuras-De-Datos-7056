package principal;

import controller.PeajeController;

/**
 *
 * @author daniel
 */
/*
    Una estación de peaje necesita administrar los vehículos que pasan por la caseta de cobro. 
    Los vehículos se atienden en orden de llegada y, si un vehículo no tiene saldo suficiente, 
    debe moverse al final de la cola hasta regularizar su situación. 
    Se requiere una lista circular para gestionar este proceso.

    Debes implementar una estructura de Lista Circular, cumpliendo con las siguientes funcionalidades:

    Registro de vehículos:
    - Registrar un nuevo vehículo en la cola de atención.
    - Cada vehículo debe contener:
        • Placa (cadena, única)
        • Tipo (cadena: "Automóvil", "Camión", "Moto", "Bus")
        • SaldoDisponible (decimal, mayor o igual a 0)
    
    No se pueden registrar dos vehículos con la misma placa.
 */
 /*
    Proceso de cobro:
    - Atender al primer vehículo en la cola.
    - Si el saldo es suficiente, descontar la tarifa y eliminar el vehículo de la lista.
    - Si el saldo es insuficiente, mover el vehículo al final de la lista.

    Búsqueda y visualización:
    - Buscar un vehículo por su placa y mostrar sus datos.
    - Listar los vehículos en la cola en orden de llegada.

    Reglas adicionales:
    - Si se intenta registrar un vehículo con un tipo no permitido, debe mostrar un error.
    - Las tarifas de peaje son:
        • Automóvil: S/5.00
        • Camión: S/10.00
        • Moto: S/3.00
        • Bus: S/8.00
    - Si el saldo del vehículo es menor a la tarifa, debe moverse al final de la lista hasta que regularice el pago.
    - Si la lista está vacía y se intenta atender a un vehículo, debe mostrar un mensaje de error.
 */

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PeajeController controlador = new PeajeController();
        controlador.gestionarMenu();
    }

}
