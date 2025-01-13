/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.util.Arrays;
/**
 *
 * @author daniel
 */
public class Clasificaciones {
    private final int [] calificaciones;
    private int totalCalificaciones;
    
    public Clasificaciones (int capacidad){
        this.calificaciones = new int [capacidad];
        this.totalCalificaciones = 0;
    }
    public boolean agregar (int calificacion){
        if(totalCalificaciones < calificaciones.length){
            calificaciones[totalCalificaciones++] = calificacion;
        }
        return true;
    }
    public boolean actualizar(int indice, int nuevoValor){
        if(indice >= 0 && indice < totalCalificaciones){
            calificaciones[indice] = nuevoValor;
            return true;
        }
        return false;
    }
    public boolean eliminar(int indice){
        if(indice >= 0 && indice < totalCalificaciones){
            for(int i=indice;i<totalCalificaciones-1; i++){
                calificaciones[i]=calificaciones[i+1];
            }
            calificaciones[--totalCalificaciones]=0;
            return true;
        }
        return false;
    }
    
    public void mostrar(){
        System.out.println("Calificaciones Actuales: ");
        for(int i=0; i<totalCalificaciones; i++){
            System.out.println("Indice: "+i+": "+calificaciones[i]);
        }
    }
    
    public void mostrarEstadisticas(){
        if(totalCalificaciones == 0){
            System.out.println("No hay calificaciones registradas");
            return;
        }
        int suma = Arrays.stream(calificaciones,0,totalCalificaciones).sum();
    }
}