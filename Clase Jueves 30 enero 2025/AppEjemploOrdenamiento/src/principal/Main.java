package principal;

import java.util.InputMismatchException;
import model.ListaEnlazada;
import view.Menu;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();

        System.out.println("Ingrese cantidad de elementos en la lista: ");
        int n = 0;

        // Validación para la cantidad de elementos
        while (true) {
            try {
                n = sc.nextInt();
                if (n <= 0) {
                    System.out.println("Por favor, ingrese un número positivo.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Ingrese un número entero.");
                sc.next(); // Limpiar el buffer del scanner
            }
        }

        System.out.println("Ingrese los " + n + " elementos de la lista (solo números):");

        int contador = 0;
        while (contador < n) {
            System.out.print("Elemento " + (contador + 1) + ": ");
            try {
                int dato = sc.nextInt();
                lista.agregar(dato);
                contador++; // Solo avanza si la entrada es válida
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Ingrese un número entero.");
                sc.next(); // Limpiar el buffer para evitar bucle infinito
            }
        }

        Menu.mostrarMenu(lista);
        sc.close();
    }
}
