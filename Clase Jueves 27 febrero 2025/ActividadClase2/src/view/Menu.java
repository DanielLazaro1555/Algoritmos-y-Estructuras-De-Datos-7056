package view;

import controller.GestorUsuarios;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
/**
 * Clase que gestiona el menú interactivo para el usuario. Permite registrar,
 * buscar, eliminar y mostrar usuarios en ABB y AVL.
 */
public class Menu {

    private GestorUsuarios gestor;
    private Scanner scanner;

    /**
     * Constructor que inicializa el gestor de usuarios y el scanner.
     */
    public Menu() {
        this.gestor = new GestorUsuarios();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Método para mostrar el menú interactivo y manejar la entrada del usuario.
     */
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n📌 Menú de Gestión de Usuarios");
            System.out.println("1 Registrar usuario");
            System.out.println("2 Buscar usuario por ID");
            System.out.println("3 Eliminar usuario");
            System.out.println("4 Mostrar usuarios en orden ascendente");
            System.out.println("5 Mostrar usuarios por nivel de acceso");
            System.out.println("0 Salir");
            System.out.print("👉 Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        registrarUsuario();
                        break;
                    case 2:
                        buscarUsuario();
                        break;
                    case 3:
                        eliminarUsuario();
                        break;
                    case 4:
                        gestor.mostrarUsuarios();
                        break;
                    case 5:
                        mostrarUsuariosPorNivel();
                        break;
                    case 0:
                        System.out.println("🚀 Saliendo del programa...");
                        break;
                    default:
                        System.out.println("❌ Opción no válida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Error: Debe ingresar un número válido.");
                scanner.nextLine(); // Limpiar buffer
                opcion = -1; // Forzar repetir el menú
            }
        } while (opcion != 0);
    }

    /**
     * Método para registrar un usuario solicitando los datos al usuario.
     */
    private void registrarUsuario() {
        int id = leerEntero("📌 Ingrese el ID del usuario: ");

        System.out.print("📌 Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();

        System.out.print("📌 Ingrese el correo electrónico del usuario: ");
        String correo = scanner.nextLine();

        int nivelAcceso;
        do {
            nivelAcceso = leerEntero("📌 Ingrese el nivel de acceso (1 = Básico, 2 = Intermedio, 3 = Avanzado): ");
            if (nivelAcceso < 1 || nivelAcceso > 3) {
                System.out.println("⚠️ Error: El nivel de acceso debe ser 1, 2 o 3.");
            }
        } while (nivelAcceso < 1 || nivelAcceso > 3);

        gestor.registrarUsuario(id, nombre, correo, nivelAcceso);
    }

    /**
     * Método para buscar un usuario por su ID.
     */
    private void buscarUsuario() {
        int id = leerEntero("🔍 Ingrese el ID del usuario a buscar: ");
        gestor.buscarUsuario(id);
    }

    /**
     * Método para eliminar un usuario por su ID.
     */
    private void eliminarUsuario() {
        int id = leerEntero("🗑️ Ingrese el ID del usuario a eliminar: ");
        gestor.eliminarUsuario(id);
    }

    /**
     * Método para mostrar usuarios de un nivel de acceso específico.
     */
    private void mostrarUsuariosPorNivel() {
        int nivelAcceso;
        do {
            nivelAcceso = leerEntero("📌 Ingrese el nivel de acceso a filtrar (1 = Básico, 2 = Intermedio, 3 = Avanzado): ");
            if (nivelAcceso < 1 || nivelAcceso > 3) {
                System.out.println("⚠️ Error: El nivel de acceso debe ser 1, 2 o 3.");
            }
        } while (nivelAcceso < 1 || nivelAcceso > 3);

        gestor.mostrarUsuariosPorNivel(nivelAcceso);
    }

    /**
     * Método auxiliar para leer un número entero con validación.
     *
     * @param mensaje Mensaje a mostrar antes de la entrada.
     * @return Un número entero válido ingresado por el usuario.
     */
    private int leerEntero(String mensaje) {
        int numero;
        while (true) {
            try {
                System.out.print(mensaje);
                numero = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Error: Debe ingresar un número válido.");
                scanner.nextLine(); // Limpiar buffer
            }
        }
    }
}
