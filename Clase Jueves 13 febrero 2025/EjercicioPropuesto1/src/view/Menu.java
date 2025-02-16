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
                System.out.println("\n=== MENÚ DE GESTIÓN DE CLIENTES ===");
                System.out.println("1. Registrar un cliente (Regular o VIP)");
                System.out.println("2. Atender a un cliente");
                System.out.println("3. Ver siguiente cliente");
                System.out.println("4. Mostrar toda la cola");
                System.out.println("5. Contar clientes en espera");
                System.out.println("6. Vaciar la cola");
                System.out.println("7. Salir");
                System.out.print("Seleccione una opción: ");

                opcion = Integer.parseInt(scanner.nextLine()); // Lee como String y convierte a int
                if (opcion >= 1 && opcion <= 7) {
                    entradaValida = true;
                } else {
                    System.out.println("⚠️ Error: Ingrese un número entre 1 y 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Error: Entrada inválida. Ingrese un número entre 1 y 7.");
            }
        }

        return opcion;
    }

    public String obtenerNombre() {
        System.out.print("Ingrese el nombre del cliente: ");
        return scanner.next();
    }

    public boolean esVIP() {
        System.out.print("¿El cliente es VIP? (1=Sí, 0=No): ");
        return scanner.nextInt() == 1;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
