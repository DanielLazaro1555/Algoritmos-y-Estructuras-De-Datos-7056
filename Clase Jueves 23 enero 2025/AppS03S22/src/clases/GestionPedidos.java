package clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Clase para gestionar pedidos de una pizzería.
 * Permite agregar, eliminar, buscar y listar pedidos.
 * 
 * @author daniel
 */
public class GestionPedidos {
    private ArrayList<Pedido> pedidos;               // Lista para almacenar los pedidos
    private static final int MAX_PEDIDOS = 100;      // Límite máximo de pedidos permitidos

    // Constructor que inicializa la lista de pedidos
    public GestionPedidos() {
        pedidos = new ArrayList<>();
    }

    /**
     * Método para agregar un nuevo pedido.
     * Verifica el límite de pedidos, ID duplicados y validación de datos de entrada.
     */
    public void agregarPedido() {
        Scanner dato = new Scanner(System.in);

        // Verificación del límite máximo de pedidos
        if (pedidos.size() >= MAX_PEDIDOS) {
            System.out.println("Error: Se alcanzó el límite máximo de pedidos.");
            return;
        }

        System.out.print("Ingrese ID del pedido: ");
        int id = dato.nextInt();
        dato.nextLine(); // Limpieza del buffer

        // Verificación de ID duplicado
        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                System.out.println("Error: Ya existe un pedido con ese ID.");
                return;
            }
        }

        System.out.print("Ingrese nombre del cliente: ");
        String cliente = dato.nextLine();

        System.out.print("Ingrese tipo de pizza: ");
        String tipoPizza = dato.nextLine();

        System.out.print("Ingrese cantidad de pizzas: ");
        int cantidad = dato.nextInt();
        dato.nextLine(); // Limpieza del buffer

        if (cantidad <= 0) {
            System.out.println("Error: La cantidad debe ser mayor que 0.");
            return;
        }

        System.out.print("Ingrese precio unitario: ");
        double precioUnitario = dato.nextDouble();

        double precioTotal = cantidad * precioUnitario;

        if (precioTotal <= 0) {
            System.out.println("Error: El precio total debe ser mayor que 0.");
            return;
        }

        // Creación y adición del nuevo pedido
        Pedido nuevoPedido = new Pedido(id, cliente, tipoPizza, cantidad, precioTotal);
        pedidos.add(nuevoPedido);

        System.out.println("Pedido agregado exitosamente.");
    }

    /**
     * Método para eliminar un pedido por su ID.
     */
    public void eliminarPedido() {
        Scanner dato = new Scanner(System.in);

        System.out.print("Ingrese ID del pedido a eliminar: ");
        int id = dato.nextInt();
        dato.nextLine();

        // Uso de un bucle con índice para evitar ConcurrentModificationException
        for (int i = 0; i < pedidos.size(); i++) {
            if (pedidos.get(i).getId() == id) {
                pedidos.remove(i);
                System.out.println("Pedido eliminado exitosamente.");
                return;
            }
        }
        System.out.println("Error: No se encontró el pedido.");
    }

    /**
     * Método para buscar un pedido por su ID.
     */
    public void buscarPedidoID() {
        Scanner dato = new Scanner(System.in);

        System.out.print("Ingrese el ID del pedido: ");
        int id = dato.nextInt();
        dato.nextLine();

        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                System.out.println(p);
                return;
            }
        }
        System.out.println("Error: No se encontró el pedido.");
    }

    /**
     * Método para buscar pedidos por el nombre del cliente.
     */
    public void buscarPedidoporCliente() {
        Scanner dato = new Scanner(System.in);

        System.out.print("Ingrese el nombre del cliente: ");
        String cliente = dato.nextLine();

        boolean encontrado = false;
        for (Pedido p : pedidos) {
            if (p.getCliente().equalsIgnoreCase(cliente)) {
                System.out.println(p);
                encontrado = true; // Marca que se ha encontrado al menos un pedido
            }
        }

        if (!encontrado) {
            System.out.println("Error: No se encontró ningún pedido para el cliente.");
        }
    }

    /**
     * Método para listar todos los pedidos, ordenados por el nombre del cliente.
     */
    public void listarPedidos() {
        // Ordenar la lista de pedidos por nombre del cliente (orden alfabético)
        Collections.sort(pedidos, new Comparator<Pedido>() {
            @Override
            public int compare(Pedido p1, Pedido p2) {
                return p1.getCliente().compareToIgnoreCase(p2.getCliente());
            }
        });

        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
        } else {
            System.out.println("===== LISTA DE PEDIDOS =====");
            for (Pedido p : pedidos) {
                System.out.println(p);
            }
        }
    }
}
