package view;

import controller.GestorPedidos;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class Menu {

    private GestorPedidos gestor;
    private Scanner scanner;

    public Menu() {
        this.gestor = new GestorPedidos();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n📋 MENÚ - GESTIÓN DE PEDIDOS EN CAFETERÍA 📋");
            System.out.println("1 Agregar pedido");
            System.out.println("2 Mostrar pedidos en orden normal");
            System.out.println("3 Mostrar pedidos en orden inverso");
            System.out.println("4 Entregar pedido (Eliminar más antiguo)");
            System.out.println("5 Buscar pedido por código");
            System.out.println("0 Salir");
            System.out.print("👉 Selecciona una opción: ");

            opcion = validarEntradaNumerica();

            switch (opcion) {
                case 1 ->
                    agregarPedido();
                case 2 ->
                    gestor.mostrarPedidos(false);
                case 3 ->
                    gestor.mostrarPedidos(true);
                case 4 -> {
                    gestor.entregarPedido();
                    System.out.println("✅ Pedido más antiguo entregado.");
                }
                case 5 ->
                    buscarPedido();
                case 0 ->
                    System.out.println("👋 Saliendo del sistema...");
                default ->
                    System.out.println("⚠ Opción inválida, intenta de nuevo.");
            }
        } while (opcion != 0);
    }

    private void agregarPedido() {
        scanner.nextLine(); // Limpiar buffer antes de leer el nombre
        String nombre;
        do {
            System.out.print("\n👤 Ingrese el nombre del cliente (solo letras): ");
            nombre = scanner.nextLine().trim();
            if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                System.out.println("⚠ Error: El nombre solo puede contener letras y espacios.");
            }
        } while (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")); // 🔹 Se repite hasta que sea válido

        String prioridad;
        do {
            System.out.print("🌟 Prioridad (Normal/VIP): ");
            prioridad = scanner.nextLine().trim();
            if (!prioridad.equalsIgnoreCase("Normal") && !prioridad.equalsIgnoreCase("VIP")) {
                System.out.println("⚠ Error: Prioridad inválida. Intenta nuevamente.");
            }
        } while (!prioridad.equalsIgnoreCase("Normal") && !prioridad.equalsIgnoreCase("VIP"));

        gestor.agregarPedido(nombre, prioridad);
        System.out.println("✅ Pedido agregado correctamente.");
    }

    private void buscarPedido() {
        System.out.print("\n🔍 Ingrese el código del pedido a buscar: ");
        int codigo = validarEntradaNumerica();
        gestor.buscarPedido(codigo);
    }

    private int validarEntradaNumerica() {
        while (!scanner.hasNextInt()) {
            System.out.print("⚠ Entrada inválida. Ingresa un número: ");
            scanner.next(); // Limpia la entrada incorrecta
        }
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.mostrarMenu();
    }
}
