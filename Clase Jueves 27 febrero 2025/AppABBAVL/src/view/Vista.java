package view;

import controller.Controlador;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class Vista {

    private Scanner sc;
    private Controlador controlador;

    public Vista() {
        sc = new Scanner(System.in);
        controlador = new Controlador();
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("1. INSERTAR NUMERO.");
            System.out.println("2. BUSCAR NUMERO.");
            System.out.println("3. ELIMINAR NUMERO.");
            System.out.println("4. SALIR");
            System.out.print("INGRESE OPCION: ");
            opcion = sc.nextInt();

            if (opcion != 4) {
                controlador.manejarOpcion(opcion, sc);
            }
        } while (opcion != 4);
        System.out.println("PROGRAMA FINALIZADO.");
        sc.close();
    }
}
