package view;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class VistaAcademica {

    private Scanner sc;

    public VistaAcademica() {
        this.sc = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\n--- MENÚ GESTIÓN ACADÉMICA ---");
        System.out.println("1. Mostrar lista de alumnos");
        System.out.println("2. Añadir nuevo alumno");
        System.out.println("3. Registrar calificaciones para un alumno");
        System.out.println("4. Calcular promedio de un alumno");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
        return leerEntero("Seleccione una opción: ");
    }

    public String leerCadena(String mensaje) {
        String input;
        while (true) {
            System.out.print(mensaje);
            input = sc.nextLine().trim();

            // Validar que no tenga números
            if (input.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
                return input;
            } else {
                System.out.println("❌ ERROR: El nombre solo debe contener letras.");
            }
        }
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
                System.out.println("❌ ERROR: Ingrese un número válido.");
                sc.nextLine(); // Limpiar buffer
            }
        }
    }

    public double leerDouble(String mensaje) {
        double numero;
        while (true) {
            try {
                System.out.print(mensaje);
                numero = sc.nextDouble();
                sc.nextLine(); // Consumir el salto de línea
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("❌ ERROR: Ingrese un número válido.");
                sc.nextLine(); // Limpiar buffer
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
