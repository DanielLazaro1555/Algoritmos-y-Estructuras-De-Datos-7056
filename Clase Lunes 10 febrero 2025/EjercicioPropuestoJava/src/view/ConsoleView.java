package view;

import controller.DocumentController;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class ConsoleView {

    private DocumentController controller;
    private Scanner scanner;

    /**
     * Constructor que inicializa el controlador y el escáner para la entrada
     * del usuario.
     */
    public ConsoleView() {
        this.controller = new DocumentController();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Muestra el menú y gestiona las opciones seleccionadas por el usuario.
     */
    public void showMenu() {
        int option = 0; // Inicializa con un valor válido

        do {
            System.out.println("\n=== Sistema de Gestión de Documentos ===");
            System.out.println("1. Editar documento");
            System.out.println("2. Deshacer última modificación");
            System.out.println("3. Rehacer última modificación");
            System.out.println("4. Mostrar contenido del documento");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) { // Verifica si la entrada es un número válido
                option = scanner.nextInt();
                scanner.nextLine(); // ⚠ IMPORTANTE: Limpia el buffer después de leer un número
            } else {
                System.out.println("⚠ Entrada no válida. Por favor, ingrese un número.");
                scanner.nextLine(); // Limpia la entrada incorrecta
                continue; // Vuelve al inicio del bucle sin ejecutar el switch
            }

            switch (option) {
                case 1:
                    editDocument();
                    break;
                case 2:
                    controller.undo();
                    break;
                case 3:
                    controller.redo();
                    break;
                case 4:
                    controller.displayDocument();
                    break;
                case 5:
                    System.out.println("🚀 Saliendo del sistema...");
                    break;
                default:
                    System.out.println("⚠ Opción no válida. Intente de nuevo.");
            }
        } while (option != 5); // Se ejecutará hasta que el usuario elija salir
    }

    /**
     * Solicita al usuario que ingrese el nuevo contenido del documento y lo
     * edita.
     */
    private void editDocument() {
        System.out.println("Ingrese el nuevo contenido del documento (presione ENTER para finalizar):");

        StringBuilder contenido = new StringBuilder();
        String linea;

        // Leer múltiples líneas hasta que el usuario ingrese una línea vacía
        while (!(linea = scanner.nextLine()).isEmpty()) {
            contenido.append(linea).append("\n");
        }

        // Guardar el contenido ingresado en el controlador
        controller.editDocument(contenido.toString().trim());

        System.out.println("✔ Documento editado con éxito.");
    }

}
