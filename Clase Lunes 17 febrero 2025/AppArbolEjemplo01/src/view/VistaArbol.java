package view;

import java.util.Scanner;



/**
 *
 * @author daniel
 */
public class VistaArbol {
    private Scanner sc = new Scanner(System.in);
    
    public int mostrarMenu(){
        System.out.println("1. INSERTAR UN NODO");
        System.out.println("2. BUSCAR UN NODO");
        System.out.println("3. RECORRIDO(PREORDEN,INORDEN,POSTORDEN)");
        System.out.println("4. ELIMINAR UN NODO");
        System.out.println("5. SALIR");
        System.out.print("INGRESAR OPCION: ");
        return sc.nextInt();
    }
    
    public int leerEntero(String mensaje){
        System.out.print(mensaje);
        return sc.nextInt();
    }
    
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }    
}