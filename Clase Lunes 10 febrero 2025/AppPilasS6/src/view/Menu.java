package view;

import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class Menu {

    private Scanner sc;

    public Menu() {
        this.sc = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("1. Insertar elemento (PUSH)");
        System.out.println("2. Eliminar elemento (POP)");
        System.out.println("3. Ver elemento Tope (PEEK)");
        System.out.println("4. Verificar si lista esta vacia (isEmpty)");
        System.out.println("5. Obtener tamaño de Pila (Size)");
        System.out.println("6. Mostrar Pila");
        System.out.println("7. Salir");
        System.out.println("1. Ingresar Opcion");
        return sc.nextInt();
    }

    public int obtenerElemento() {
        System.out.print("Ingrese un numero: ");
        return sc.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
