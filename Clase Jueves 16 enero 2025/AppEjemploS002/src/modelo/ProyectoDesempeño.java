/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author daniel
 */
public class ProyectoDesempeño {
    private int [] [] matriz;
    private int numProyectos;
    
    public ProyectoDesempeño(int numProyectos){
        this.numProyectos = numProyectos;
        this.matriz = new int[numProyectos][];
        for(int i=0; i < numProyectos; i++){
            matriz[i] = new int [i+1];
        }
    }
    public int getNumProyectos(){
        return numProyectos;
    }
    
    public void ingresarDatos(int fila, int columna, int valor){
        matriz[fila][columna] = valor;
    }
    public int obtenerValor(int fila, int columna){
        return matriz[fila][columna];
    }
    public double calcularPromedioUmbral(int umbral){
        double sumaTotal = 0;
        int proyectosValidos = 0;
        
        for(int i=0; i<numProyectos; i++){
            int sumaProyecto = 0;
            for(int j=0; j<matriz[i].length;j++){
                sumaProyecto += matriz[i][j];
            }
            if(sumaProyecto > umbral){
                sumaTotal += sumaProyecto;
                proyectosValidos++;
            }
        }
        return proyectosValidos > 0 ?  sumaTotal/proyectosValidos:0;
    }
    
    public ProyectoDesempeño clonar(){
        ProyectoDesempeño copia = new ProyectoDesempeño(numProyectos);
        for(int i=0; i<numProyectos;i++){
            System.arraycopy(this.matriz[i], 0, copia.matriz[i], 0, this.matriz[i].length);
        }
        return copia;
    }
    
    public boolean comparar(ProyectoDesempeño otraMatriz){
        if(this.numProyectos !=otraMatriz.numProyectos){
            return false;
        }
        for(int i=0; i<numProyectos; i++){
            for(int j=0; j<matriz[i].length; j++){
                if(matriz[i][j] !=otraMatriz.matriz[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    
    public void fusionar(ProyectoDesempeño otraMatriz){
        for(int i=0; i<numProyectos; i++){
            for(int j=0;j<matriz[i].length; j++){
                this.matriz[i][j] +=otraMatriz.matriz[i][j];
            }
        }
    }
    
    public int obtenerProyectoMD(){
        int indiceMejor = -1;
        int mejorSuma = -1;
        
        for(int i=0; i<numProyectos; i++){
            int sumaProyecto = 0;
            for(int j=0; j<matriz[i].length; j++){
                sumaProyecto +=matriz [i][j];
            }
            if(sumaProyecto>mejorSuma){
                mejorSuma = sumaProyecto;
                indiceMejor = i+1;
            }
        }
        return indiceMejor;
    }
    
    public void mostrarMatriz(){
        for(int i=0; i<numProyectos; i++){
            for(int j=0; j<matriz[i].length;j++){
                System.out.print(matriz[i][j]+"\t");
            }
            System.out.println();
        }
    }
    
}
