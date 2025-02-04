package model;

import java.util.LinkedList;

/**
 *
 * @author daniel
 */
public class ColaCircular {

    private LinkedList<Vehiculo> cola;

    public ColaCircular() {
        cola = new LinkedList<>();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        if (buscarVehiculo(vehiculo.getPlaca()) == null) {
            cola.add(vehiculo);
        } else {
            System.out.println("Error: Ya existe un vehículo con esta placa.");
        }
    }

    public Vehiculo atenderVehiculo() {
        if (!cola.isEmpty()) {
            Vehiculo vehiculo = cola.peek();
            double tarifa = obtenerTarifa(vehiculo.getTipo());

            if (vehiculo.tieneSaldoSuficiente(tarifa)) {
                vehiculo.descontarSaldo(tarifa);
                return cola.poll(); // Atiende y elimina de la cola
            } else {
                cola.add(cola.poll()); // Mueve al final si no tiene saldo suficiente
            }
        } else {
            System.out.println("Error: La lista está vacía.");
        }
        return null;
    }

    public Vehiculo buscarVehiculo(String placa) {
        for (Vehiculo v : cola) {
            if (v.getPlaca().equals(placa)) {
                return v;
            }
        }
        return null;
    }

    public String mostrarCola() {
        StringBuilder sb = new StringBuilder();
        for (Vehiculo v : cola) {
            sb.append(v.getPlaca()).append(" | ");
        }
        return sb.toString().isEmpty() ? "Cola vacía" : sb.toString();
    }

    private double obtenerTarifa(String tipo) {
        switch (tipo.toLowerCase()) {
            case "automóvil":
                return 5.0;
            case "camión":
                return 10.0;
            case "moto":
                return 3.0;
            case "bus":
                return 8.0;
            default:
                return 0.0;
        }
    }
}
