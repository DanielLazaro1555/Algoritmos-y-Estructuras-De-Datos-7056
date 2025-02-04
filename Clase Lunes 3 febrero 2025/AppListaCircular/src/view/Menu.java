package view;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\n===============================");
        System.out.println("       MENÚ PRINCIPAL");
        System.out.println("===============================");
        System.out.println("1. Insertar al inicio");
        System.out.println("2. Insertar al final");
        System.out.println("3. Eliminar al inicio");
        System.out.println("4. Eliminar al final");
        System.out.println("5. Recorrer la lista");
        System.out.println("6. Salir");
        System.out.println("===============================");
        System.out.print("Ingrese una opción: ");
        return pedirOpcion();
    }

    public int pedirDato() {
        int dato = 0;
        boolean entradaValida = false;

        System.out.println("\n-------------------------------");
        System.out.println("   INGRESO DE NUEVO DATO");
        System.out.println("-------------------------------");

        while (!entradaValida) {
            System.out.print("Ingrese un dato (número entero): ");
            try {
                dato = scanner.nextInt();
                entradaValida = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("⚠️  Error: Debe ingresar un número entero válido.");
                scanner.nextLine(); // Limpia el búfer
            }
        }
        return dato;
    }

    public void mostrarLista(String mensaje) {
        System.out.println("\n===============================");
        System.out.println(mensaje);
        System.out.println("===============================\n");
    }

    public void mostrarResultado(String mensaje) {
        System.out.println("\n✅ " + mensaje + "\n");
    }

    private int pedirOpcion() {
        int opcion = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= 6) {
                    entradaValida = true;
                } else {
                    System.out.println("⚠️  Error: Ingrese un número entre 1 y 6.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("⚠️  Error: Ingrese un número entero válido.");
                scanner.nextLine(); // Limpia el búfer
            }
        }
        return opcion;
    }
}
