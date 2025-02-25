package view;

import controller.GestorSolicitudes;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class Menu {

    private GestorSolicitudes gestor;
    private Scanner scanner;

    /**
     * Constructor del menú. Inicializa el gestor de solicitudes y el scanner.
     */
    public Menu() {
        this.gestor = new GestorSolicitudes();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Método para mostrar el menú interactivo.
     */
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n📌 MENÚ DE GESTIÓN DE SOLICITUDES");
            System.out.println("1⃣ Agregar solicitud");
            System.out.println("2⃣ Transferir solicitud a la cola");
            System.out.println("3⃣ Atender solicitud");
            System.out.println("4⃣ Mostrar estado de las solicitudes");
            System.out.println("5⃣ Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) { // Validar entrada numérica
                System.out.println("❌ Entrada inválida. Ingrese un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    agregarSolicitud();
                    break;
                case 2:
                    gestor.transferirSolicitud();
                    break;
                case 3:
                    gestor.atenderSolicitud();
                    break;
                case 4:
                    gestor.mostrarEstado();
                    break;
                case 5:
                    System.out.println("👋 Saliendo del sistema...");
                    break;
                default:
                    System.out.println("❌ Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    /**
     * Método para solicitar datos y agregar una nueva solicitud.
     */
    private void agregarSolicitud() {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        System.out.print("Ingrese la descripción de la solicitud: ");
        String descripcion = scanner.nextLine();
        gestor.agregarSolicitud(nombreCliente, descripcion);
    }
}
