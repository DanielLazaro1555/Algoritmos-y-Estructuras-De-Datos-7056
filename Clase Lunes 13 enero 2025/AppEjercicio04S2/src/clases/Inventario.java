/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author daniel
 */
/**
 * Clase Inventario
 * Proporciona funcionalidades para gestionar productos en un inventario.
 */
public class Inventario {
    private List<Producto> productos;

    // Constructor
    public Inventario() {
        this.productos = new ArrayList<>();
    }

    // Agregar un producto al inventario
    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    // Clonar el inventario
    public Inventario clonar() {
        Inventario copia = new Inventario();
        for (Producto p : this.productos) {
            copia.agregarProducto(new Producto(p.getNombre(), p.getPrecio(), p.getCantidad()));
        }
        return copia;
    }

    // Fusionar dos inventarios
    public static Inventario fusionar(Inventario inv1, Inventario inv2) {
        Inventario fusion = new Inventario();
        fusion.productos.addAll(inv1.productos);
        fusion.productos.addAll(inv2.productos);
        fusion.ordenarPorPrecio();
        return fusion;
    }

    // Ordenar los productos por precio
    public void ordenarPorPrecio() {
        this.productos.sort((p1, p2) -> Double.compare(p1.getPrecio(), p2.getPrecio()));
    }

    // Comparar dos inventarios
    public boolean comparar(Inventario otro) {
        if (this.productos.size() != otro.productos.size()) {
            return false;
        }
        for (Producto p : this.productos) {
            if (!otro.productos.contains(p)) {
                return false;
            }
        }
        return true;
    }

    // Validar que los productos sean correctos
    public static boolean validarProducto(String nombre, double precio, int cantidad) {
        return nombre != null && !nombre.trim().isEmpty() && precio > 0 && cantidad >= 0;
    }

    // Mostrar el inventario
    public void mostrarInventario() {
        for (Producto p : productos) {
            System.out.println(p);
        }
    }
}
