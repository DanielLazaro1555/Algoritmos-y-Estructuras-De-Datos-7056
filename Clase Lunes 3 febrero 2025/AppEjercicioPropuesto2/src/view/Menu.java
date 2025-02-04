package view;

import java.util.Scanner;

/**
 * Menú interactivo para gestionar pedidos del restaurante. Permite al usuario
 * seleccionar opciones y capturar datos de entrada.
 *
 * @author Daniel
 */
public class Menu {

    private Scanner scanner = new Scanner(System.in);

    // ✅ Mostrar el menú principal
    public int mostrarMenu() {
        int opcion = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.println("\n===== MENÚ DEL RESTAURANTE =====");
                System.out.println("1. Registrar pedido");
                System.out.println("2. Atender pedido");
                System.out.println("3. Marcar pedido como listo");
                System.out.println("4. Cancelar pedido");
                System.out.println("5. Buscar pedido");
                System.out.println("6. Listar pedidos (orden normal)");
                System.out.println("7. Listar pedidos (orden inverso)");
                System.out.println("8. Reasignar pedido a otra mesa");
                System.out.println("9. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = Integer.parseInt(scanner.nextLine());
                if (opcion >= 1 && opcion <= 9) {  // ✅ Permitimos la opción 9 para salir
                    entradaValida = true;
                } else {
                    System.out.println("⚠️  Error: Opción inválida. Ingrese un número entre 1 y 9.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️  Error: Debe ingresar un número entero válido.");
            }
        }
        return opcion;
    }

    // ✅ Pedir el ID del pedido
    public int pedirIdPedido() {
        int id = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Ingrese el ID del pedido: ");
                id = Integer.parseInt(scanner.nextLine());
                if (id > 0) {
                    entradaValida = true;
                } else {
                    System.out.println("⚠️  El ID debe ser un número positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️  Error: Debe ingresar un número entero válido.");
            }
        }
        return id;
    }

    // ✅ Pedir el nombre del cliente
    public String pedirNombreCliente() {
        System.out.print("Ingrese el nombre del cliente: ");
        return scanner.nextLine();
    }

    // ✅ Pedir el número de mesa
    public int pedirMesa() {
        int mesa = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Ingrese el número de mesa (1-20): ");
                mesa = Integer.parseInt(scanner.nextLine());
                if (mesa >= 1 && mesa <= 20) {
                    entradaValida = true;
                } else {
                    System.out.println("⚠️  Error: La mesa debe estar entre 1 y 20.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️  Error: Ingrese un número entero válido para la mesa.");
            }
        }
        return mesa;
    }

    // ✅ Mostrar el menú de platos
    public void mostrarMenuPlatos() {
        System.out.println("\n===== MENÚ DE PLATOS DISPONIBLES =====");
        System.out.println("1. Lomo Saltado");
        System.out.println("2. Ceviche");
        System.out.println("3. Arroz Chaufa");
        System.out.println("4. Ají de Gallina");
        System.out.println("5. Seco de Res");
        System.out.println("======================================");
    }

    // ✅ Pedir el plato al usuario
    public String pedirPlato() {
        mostrarMenuPlatos();  // Mostrar el menú de platos

        String plato = "";
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print("Ingrese el nombre exacto del plato: ");
            plato = scanner.nextLine().trim();

            // Validar que el plato esté en el menú
            if (plato.equalsIgnoreCase("Lomo Saltado")
                    || plato.equalsIgnoreCase("Ceviche")
                    || plato.equalsIgnoreCase("Arroz Chaufa")
                    || plato.equalsIgnoreCase("Ají de Gallina")
                    || plato.equalsIgnoreCase("Seco de Res")) {
                entradaValida = true;
            } else {
                System.out.println("⚠️  Error: El plato ingresado no está en el menú. Intente nuevamente.");
                mostrarMenuPlatos();  // Volver a mostrar el menú para ayudar al usuario
            }
        }

        return plato;
    }

    // ✅ Mostrar mensajes al usuario
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // ✅ Pedir el nuevo nombre del cliente para reasignación
    public String pedirNuevoNombreCliente() {
        System.out.print("Ingrese el nuevo nombre del cliente: ");
        return scanner.nextLine();
    }

    // ✅ Pedir la nueva mesa para reasignación
    public int pedirNuevaMesa() {
        int mesa = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Ingrese el nuevo número de mesa (1-20): ");
                mesa = Integer.parseInt(scanner.nextLine());
                if (mesa >= 1 && mesa <= 20) {
                    entradaValida = true;
                } else {
                    System.out.println("⚠️  Error: La mesa debe estar entre 1 y 20.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️  Error: Ingrese un número entero válido para la mesa.");
            }
        }
        return mesa;
    }
}
