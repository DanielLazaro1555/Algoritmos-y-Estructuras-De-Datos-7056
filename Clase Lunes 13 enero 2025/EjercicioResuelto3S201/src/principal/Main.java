/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;

import clases.Producto;
import clases.GestorInventario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
/**
 * Clase principal Main
 * Permite interactuar con el usuario para gestionar los inventarios.
 * El negocio ha decidido realizar simulaciones adicionales con su sistema de gestión de inventario para optimizar
las operaciones con productos electrónicos. Ahora, además de las operaciones básicas, se requiere trabajar
con nuevas funcionalidades que impliquen la clonación, fusión y comparación de inventarios. Estas
funcionalidades permitirán mejorar el análisis y gestión de los productos registrados.
En esta actividad, trabajarás con dos inventarios de productos electrónicos representados como arreglos
unidimensionales. Ambos inventarios tendrán las mismas características (nombre, precio y cantidad en stock
por producto). El objetivo es implementar las siguientes funcionalidades:
Operaciones a implementar:
• Clonación de inventario: Crea una copia exacta de uno de los inventarios y muestra el contenido del
inventario original y del inventario clonado. Asegúrate de que los cambios realizados en uno de los arreglos
no afecten al otro.
• Fusión de inventarios: Combina los productos de ambos inventarios en un solo arreglo, sin perder datos.
Ordena el inventario resultante de la fusión por precio (de menor a mayor) y muestra el listado final.
* • Comparación de inventarios: Implementa una funcionalidad que permita verificar si ambos inventarios
tienen exactamente los mismos productos (mismos nombres, precios y cantidades, sin importar el orden).
Muestra un mensaje indicando si los inventarios son iguales o diferentes.
• Validación de datos de entrada: Asegúrate de que los datos ingresados para nombre, precio y cantidad
cumplan con los criterios establecidos (por ejemplo, precio > 0, cantidad ≥ 0). Solicita nuevamente los datos
si no son válidos.
Al finalizar la actividad, deberás:
• Mostrar el inventario original y su copia al realizar la clonación.
• Mostrar el inventario resultante de la fusión, ordenado por precio.
• Indicar si los dos inventarios (originales) son iguales o diferentes al realizar la comparación.
• Demostrar la correcta validación de datos en las operaciones implementadas.
 */
public class Main {

    public static void main(String[] args) {
        Scanner dato = new Scanner(System.in);
        GestorInventario gestor = new GestorInventario();

        // Crear el inventario 1
        System.out.print("Ingrese la cantidad de productos para el inventario 1: ");
        int cantidad1 = dato.nextInt();
        dato.nextLine(); // Consumir salto de línea

        List<Producto> inventario1 = new ArrayList<>();
        System.out.println("Ingrese los productos para el inventario 1:");
        for (int i = 0; i < cantidad1; i++) {
            inventario1.add(crearProducto(dato, gestor));
        }

        // Crear el inventario 2
        System.out.print("\nIngrese la cantidad de productos para el inventario 2: ");
        int cantidad2 = dato.nextInt();
        dato.nextLine(); // Consumir salto de línea

        List<Producto> inventario2 = new ArrayList<>();
        System.out.println("Ingrese los productos para el inventario 2:");
        for (int i = 0; i < cantidad2; i++) {
            inventario2.add(crearProducto(dato, gestor));
        }

        // Clonar el inventario 1
        List<Producto> clon = gestor.clonarInventario(inventario1);

        // Mostrar el inventario 1 y su clon
        System.out.println("\n=== Inventario 1 ===");
        inventario1.forEach(System.out::println);

        System.out.println("\n=== Clon del Inventario 1 ===");
        clon.forEach(System.out::println);

        // Comparar inventarios
        System.out.println("\n¿Son iguales los inventarios? " +
                (gestor.compararInventarios(inventario1, inventario2) ? "Sí" : "No"));

        // Fusionar inventarios
        List<Producto> fusion = gestor.fusionarInventarios(inventario1, inventario2);
        System.out.println("\n=== Inventario Fusionado ===");
        fusion.forEach(System.out::println);
    }

    private static Producto crearProducto(Scanner dato, GestorInventario gestor) {
        String nombre;
        double precio;
        int cantidad;

        while (true) {
            System.out.print("Nombre: ");
            nombre = dato.nextLine();

            System.out.print("Precio: ");
            precio = dato.nextDouble();

            System.out.print("Cantidad: ");
            cantidad = dato.nextInt();
            dato.nextLine(); // Consumir salto de línea

            Producto producto = new Producto(nombre, precio, cantidad);

            if (gestor.validarProducto(producto)) {
                return producto;
            } else {
                System.out.println("Producto inválido. Inténtelo nuevamente.");
            }
        }
    }
}
