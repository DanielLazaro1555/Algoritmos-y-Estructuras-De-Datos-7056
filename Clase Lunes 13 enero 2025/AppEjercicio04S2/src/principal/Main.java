/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;

import clases.Inventario;
import clases.Producto;

import java.util.Scanner;

/**
 *
 * @author daniel
 */
/**
 * Clase Main Punto de entrada del programa.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear dos inventarios
        System.out.println("== Creando Inventario 1 ==");
        Inventario inventario1 = crearInventario(scanner);

        System.out.println("== Creando Inventario 2 ==");
        Inventario inventario2 = crearInventario(scanner);

        // Clonar inventario 1
        Inventario inventarioClonado = inventario1.clonar();
        System.out.println("\nInventario original:");
        inventario1.mostrarInventario();
        System.out.println("\nInventario clonado:");
        inventarioClonado.mostrarInventario();

        // Fusionar inventarios
        Inventario inventarioFusionado = Inventario.fusionar(inventario1, inventario2);
        System.out.println("\nInventario fusionado, ordenado por precio:");
        inventarioFusionado.mostrarInventario();

        // Comparar inventarios originales
        boolean sonIguales = inventario1.comparar(inventario2);
        System.out.println("\n¿Los inventarios originales son iguales? " + (sonIguales ? "Sí" : "No"));
    }

    // Método para crear un inventario leyendo datos del usuario
    private static Inventario crearInventario(Scanner scanner) {
        Inventario inventario = new Inventario();

        System.out.print("Ingrese la cantidad de productos: ");
        int cantidad = 0;

        // Validar que el número ingresado para la cantidad sea correcto
        while (true) {
            try {
                cantidad = Integer.parseInt(scanner.nextLine());
                if (cantidad <= 0) {
                    System.out.println("La cantidad debe ser mayor a 0. Inténtelo nuevamente.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número entero válido. Inténtelo nuevamente.");
            }
        }

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Nombre del producto " + (i + 1) + ": ");
            String nombre = scanner.nextLine();

            double precio = 0.0;
            while (true) {
                try {
                    System.out.print("Precio del producto " + (i + 1) + ": ");
                    precio = Double.parseDouble(scanner.nextLine());
                    if (precio <= 0) {
                        System.out.println("El precio debe ser mayor a 0. Inténtelo nuevamente.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Debe ingresar un número decimal válido para el precio. Inténtelo nuevamente.");
                }
            }

            int cantidadProducto = 0;
            while (true) {
                try {
                    System.out.print("Cantidad del producto " + (i + 1) + ": ");
                    cantidadProducto = Integer.parseInt(scanner.nextLine());
                    if (cantidadProducto < 0) {
                        System.out.println("La cantidad no puede ser negativa. Inténtelo nuevamente.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Debe ingresar un número entero válido para la cantidad. Inténtelo nuevamente.");
                }
            }

            if (Inventario.validarProducto(nombre, precio, cantidadProducto)) {
                inventario.agregarProducto(new Producto(nombre, precio, cantidadProducto));
            } else {
                System.out.println("Producto inválido. Inténtelo de nuevo.");
                i--; // Reintentar el ingreso del producto actual
            }
        }
        return inventario;
    }

}
