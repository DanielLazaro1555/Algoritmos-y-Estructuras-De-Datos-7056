/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author daniel
 */
/**
 * Clase Ventas
 * Representa las ventas mensuales de varios vendedores.
 */
public class Ventas {
    private double[][] ventas; // Arreglo bidimensional para las ventas
    private int numVendedores;

    /**
     * Constructor de la clase Ventas.
     * 
     * @param numVendedores Número de vendedores.
     */
    public Ventas(int numVendedores) {
        this.numVendedores = numVendedores;
        this.ventas = new double[numVendedores][12]; // 12 meses para cada vendedor
    }

    /**
     * Registrar una venta en el mes y vendedor especificado.
     * 
     * @param vendedor Índice del vendedor.
     * @param mes Índice del mes.
     * @param monto Monto de la venta.
     */
    public void registrarVenta(int vendedor, int mes, double monto) {
        if (vendedor >= 0 && vendedor < numVendedores && mes >= 0 && mes < 12) {
            ventas[vendedor][mes] = monto;
        }
    }

    /**
     * Calcular el total de ventas anuales para un vendedor.
     * 
     * @param vendedor Índice del vendedor.
     * @return Total de ventas anuales.
     */
    public double calcularTotalVentas(int vendedor) {
        double total = 0;
        for (int mes = 0; mes < 12; mes++) {
            total += ventas[vendedor][mes];
        }
        return total;
    }

    /**
     * Encontrar el índice del vendedor con las mayores ventas totales.
     * 
     * @return Índice del vendedor con mayores ventas.
     */
    public int obtenerVendedorConMayorVentas() {
        int mejorVendedor = -1;
        double maxVentas = -1;

        for (int i = 0; i < numVendedores; i++) {
            double total = calcularTotalVentas(i);
            if (total > maxVentas) {
                maxVentas = total;
                mejorVendedor = i;
            }
        }
        return mejorVendedor;
    }

    /**
     * Calcular el promedio mensual de ventas para un vendedor.
     * 
     * @param vendedor Índice del vendedor.
     * @return Promedio mensual de ventas.
     */
    public double calcularPromedioVentas(int vendedor) {
        return calcularTotalVentas(vendedor) / 12;
    }

    /**
     * Mostrar las ventas de todos los vendedores.
     */
    public void mostrarVentas() {
        for (int i = 0; i < numVendedores; i++) {
            System.out.printf("Vendedor %d: ", i + 1);
            for (int mes = 0; mes < 12; mes++) {
                System.out.printf("%.2f ", ventas[i][mes]);
            }
            System.out.println();
        }
    }
}
