package view;

import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class Menu {

    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n===== MENÚ PRINCIPAL =====");
        System.out.println("1. Registrar vehículo");
        System.out.println("2. Atender vehículo");
        System.out.println("3. Mostrar cola");
        System.out.println("4. Buscar vehículo por placa");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public String pedirPlaca() {
        System.out.print("Ingrese la placa del vehículo: ");
        return scanner.next();
    }

    public String pedirTipo() {
        System.out.print("Ingrese el tipo de vehículo (Automóvil, Camión, Moto, Bus): ");
        return scanner.next();
    }

    public double pedirSaldo() {
        System.out.print("Ingrese el saldo disponible: ");
        return scanner.nextDouble();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
