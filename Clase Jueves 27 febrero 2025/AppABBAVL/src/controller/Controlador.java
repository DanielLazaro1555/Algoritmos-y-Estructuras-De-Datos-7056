package controller;

import model.ABB;
import model.AVL;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class Controlador {
    private ABB abb;
    private AVL avl;
    
    public Controlador(){
        abb=new ABB();
        avl=new AVL();
    }
    public void manejarOpcion(int opcion,Scanner sc){
        System.out.println("Ingrese Numero : ");
        int numero = sc.nextInt();
        
        switch(opcion){
            case 1:
                abb.insertar(numero);
                avl.insertar(numero);
                System.out.println("Numero insertador en ABB y AVL");
                break;
            case 2:
                System.out.println("ABB: "+(abb.buscar(numero)?"Encontrado":"No encontrado"));
                System.out.println("AVL: "+(avl.buscar(numero)?"Encontrado":"No encontrado"));
                break;
            case 3:
                abb.insertar(numero);
                avl.insertar(numero);
                System.out.println("Numero eliminado en ABB y AVL");
                break;
            default:
                System.out.println("Opcion invalida");
        }
    }
}
