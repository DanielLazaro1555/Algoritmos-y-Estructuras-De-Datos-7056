package view;

import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class Menu {

    private Scanner sc;

    public Menu() {
        sc = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("1. Insertar Elemento");
        System.out.println("2. Eliminar Elemento");
        System.out.println("3. Ver primer elemento");
        System.out.println("4. Mostrar cola");
        System.out.println("5. Salir");
        System.out.println("Ingrese Opcion: ");
    }

    public int leerOpcion() {
        return sc.nextInt();
    }

    public String leerDato() {
        System.out.println("Ingrese Elemento : ");
        return sc.next();

    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
