package view;

import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class Menu {

    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        int opcion = -1;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.println("\n=== MENÚ ===");
                System.out.println("1. Agregar producto al inventario");
                System.out.println("2. Eliminar producto del inventario");
                System.out.println("3. Consultar último producto agregado");
                System.out.println("4. Mostrar inventario");
                System.out.println("5. Contar productos en inventario");
                System.out.println("6. Salir");
                System.out.print("Seleccione una opción: ");

                String entrada = scanner.nextLine(); // Lee como String para evitar errores
                opcion = Integer.parseInt(entrada); // Convierte a número

                if (opcion >= 1 && opcion <= 6) {
                    entradaValida = true;
                } else {
                    System.out.println("⚠️ Error: Ingrese un número entre 1 y 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Error: Entrada inválida. Ingrese un número entre 1 y 6.");
            }
        }

        return opcion;
    }

    public String obtenerNombreProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        return scanner.next();
    }

    public double obtenerPrecioProducto() {
        System.out.print("Ingrese el precio del producto: ");
        return scanner.nextDouble();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
