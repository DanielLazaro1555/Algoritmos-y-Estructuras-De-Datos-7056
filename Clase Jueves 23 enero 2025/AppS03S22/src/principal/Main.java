package principal;

import clases.GestionPedidos;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class Main {

    public static void main(String[] args) {
        GestionPedidos gestion = new GestionPedidos();
        Scanner dato = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== MENÚ DE GESTIÓN DE PEDIDOS =====");
            System.out.println("1. Agregar Pedido");
            System.out.println("2. Eliminar Pedido");
            System.out.println("3. Buscar Pedido por ID");  // CORRECCIÓN DEL TEXTO
            System.out.println("4. Buscar Pedido por Cliente");
            System.out.println("5. Listar Pedidos");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");

            // Validación de entrada numérica
            while (!dato.hasNextInt()) {
                System.out.println("Opción no válida. Por favor, ingrese un número.");
                dato.next(); // Limpiar la entrada inválida
                System.out.print("Ingrese una opción: ");
            }
            opcion = dato.nextInt();

            // Menú de opciones
            switch (opcion) {
                case 1:
                    gestion.agregarPedido();
                    break;
                case 2:
                    gestion.eliminarPedido();
                    break;
                case 3:
                    gestion.buscarPedidoID();
                    break;
                case 4:
                    gestion.buscarPedidoporCliente();
                    break;
                case 5:
                    gestion.listarPedidos();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema... ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 6);

        dato.close(); // Buenas prácticas: cerrar el Scanner
    }
}
