package view;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author daniel
 */
public class VistaOrganizacion {

    private Scanner sc;

    public VistaOrganizacion() {
        this.sc = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\n--- MENÚ DE GESTIÓN EMPRESARIAL ---");
        System.out.println("1. Añadir un empleado");
        System.out.println("2. Mostrar estructura organizacional");
        System.out.println("3. Salir");
        return leerEntero("Seleccione una opción: ");
    }

    public String leerCadena(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine().trim();
    }

    public int leerEntero(String mensaje) {
        int numero;
        while (true) {
            try {
                System.out.print(mensaje);
                numero = sc.nextInt();
                sc.nextLine(); // Consumir el salto de línea
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("❌ ERROR: Debe ingresar un número válido.");
                sc.nextLine(); // Limpiar buffer de entrada
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
