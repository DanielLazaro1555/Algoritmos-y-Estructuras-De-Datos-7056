package clases;

import java.util.Arrays;

/**
 * Clase para realizar cálculos relacionados con las ventas.
 * Incluye métodos para totales por mes, totales por sucursal
 * y ordenamiento de sucursales por ventas.
 * 
 * @author daniel
 */
public class CalculosVentas {

    /**
     * Calcula el total de ventas por mes.
     * Matriz de ventas (filas: meses, columnas: sucursales).
     * Arreglo con los totales de ventas por mes.
     */
    public static int[] calcularTotalPorMes(int[][] matriz) {
        int[] totales = new int[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                totales[i] += matriz[i][j];
            }
        }
        return totales;
    }

    /**
     * Calcula el total de ventas por sucursal.
     * Matriz de ventas (filas: meses, columnas: sucursales).
     * Arreglo con los totales de ventas por sucursal.
     */
    public static int[] calcularTotalPorSucursal(int[][] matriz) {
        int[] totales = new int[matriz[0].length];
        for (int j = 0; j < matriz[0].length; j++) {
            for (int i = 0; i < matriz.length; i++) {
                totales[j] += matriz[i][j];
            }
        }
        return totales;
    }

    /**
     * Ordena los índices de las sucursales por ventas totales en orden ascendente.
     * Arreglo con los totales de ventas por sucursal.
     * Arreglo de índices ordenados según las ventas.
     */
    public static int[] ordenarIndicesPorVentas(int[] ventas) {
        Integer[] indices = new Integer[ventas.length];
        for (int i = 0; i < ventas.length; i++) {
            indices[i] = i;
        }
        // Ordenar índices según los totales de ventas
        Arrays.sort(indices, (a, b) -> Integer.compare(ventas[a], ventas[b]));
        // Convertir a un arreglo de enteros
        return Arrays.stream(indices).mapToInt(Integer::intValue).toArray();
    }
}
