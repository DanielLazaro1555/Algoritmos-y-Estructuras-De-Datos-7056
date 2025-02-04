package model;

/**
 *
 * @author daniel
 */
public class Vehiculo {

    private String placa;
    private String tipo;
    private double saldoDisponible;

    public Vehiculo(String placa, String tipo, double saldoDisponible) {
        this.placa = placa;
        this.tipo = tipo;
        this.saldoDisponible = Math.max(0, saldoDisponible);
    }

    public String getPlaca() {
        return placa;
    }

    public String getTipo() {
        return tipo;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void recargarSaldo(double monto) {
        if (monto > 0) {
            this.saldoDisponible += monto;
        }
    }

    public boolean tieneSaldoSuficiente(double costoPeaje) {
        return saldoDisponible >= costoPeaje;
    }

    public void descontarSaldo(double costoPeaje) {
        if (tieneSaldoSuficiente(costoPeaje)) {
            saldoDisponible -= costoPeaje;
        }
    }
}
