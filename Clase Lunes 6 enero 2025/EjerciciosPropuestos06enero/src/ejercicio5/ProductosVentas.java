/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio5;
/**
 *
 * @author daniel
 */
/**
 * Clase ProductosVentas
 * Permite encontrar el producto más vendido de una tienda.
 */
public class ProductosVentas {

    /**
     * Encuentra el producto más vendido.
     * 
     * @param productos Arreglo con los nombres de los productos.
     * @param ventas Arreglo con las cantidades de ventas de cada producto.
     * @return Una cadena con el nombre del producto más vendido y su cantidad.
     */
    public String productoMasVendido(String[] productos, int[] ventas) {
        if (productos.length != ventas.length || productos.length == 0) {
            return "Error: Los arreglos deben tener el mismo tamaño y no deben estar vacíos.";
        }

        int indiceMayor = 0;
        for (int i = 1; i < ventas.length; i++) {
            if (ventas[i] > ventas[indiceMayor]) {
                indiceMayor = i;
            }
        }

        return "Producto más vendido: " + productos[indiceMayor] + " con " + ventas[indiceMayor] + " ventas.";
    }
}
