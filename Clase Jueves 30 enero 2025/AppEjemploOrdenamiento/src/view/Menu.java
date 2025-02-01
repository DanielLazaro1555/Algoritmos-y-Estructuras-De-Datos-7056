package view;

import model.ListaEnlazada;
import controller.OrdenarLista;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class Menu {
    public static void mostrarMenu(ListaEnlazada lista){
        Scanner sc= new Scanner(System.in);
        int opcion;
        do{
            System.out.println("=================================");
            System.out.println("1. Recorrer Lista");
            System.out.println("2. Ordenar por burbuja");
            System.out.println("3. Ordenar por seleccion");
            System.out.println("4. Ordenar por insercion");
            System.out.println("5. Ordenar por merge sort");
            System.out.println("6. Buscar elemento");
            System.out.println("7. Salir");
            System.out.println("Seleccionar Opcion: ");
            opcion = sc.nextInt();
            
            switch(opcion){
                case 1:
                    lista.imprimirLista();
                    break;
                case 2:
                    OrdenarLista.OrdenarBurbuja(lista);
                    System.out.println("\n Lista ordenada con burbuja");
                    lista.imprimirLista();
                    break;
                case 3:
                    OrdenarLista.OrdenarSeleccion(lista);
                    System.out.println("\nLista ordenada con seleccion");
                    lista.imprimirLista();
                    break;
                case 4:
                    OrdenarLista.OrdenarInsercion(lista);
                    System.out.println("\nLista Ordenada con insercion");
                    break;
                case 5:
                    OrdenarLista.OrdenarMerge(lista);
                    System.out.println("\nLista ordenada con merge sort");
                    lista.imprimirLista();
                    break;
                case 6:
                    System.out.println("Ingrese Numero a Buscar: ");
                    int valor = sc.nextInt();
                    lista.buscar(valor);
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                    default:
                        System.out.println("Opcion Invalida");
            }
            
            
        }while(opcion !=7);
    }
}
