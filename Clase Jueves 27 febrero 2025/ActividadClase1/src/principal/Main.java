package principal;
import view.Menu;
/**
 *
 * @author daniel
 */
/**

    Una empresa desea implementar una aplicación para gestionar los productos de su almacén
    utilizando Árboles Binarios de Búsqueda (ABB) y Árboles AVL. Cada producto tiene un código único (entero),
    nombre (cadena) y stock disponible (entero).
    El sistema debe permitir:
        Insertar un producto en el ABB y AVL.
        Buscar un producto por código en ambos árboles.
        Eliminar un producto, asegurando el balanceo en el AVL.
        Mostrar los productos en orden ascendente por código mediante recorrido inorden.
    Implementación:
        El proyecto debe seguir el patrón MVC:
        modelo: clases Producto, Nodo, ABB y AVL.
        controlador: clase GestorArboles para manejar operaciones en ABB y AVL.
        vista: clase Menu que permita la interacción con el usuario mediante entrada por teclado (Scanner).
    Requisitos:
        Implementar correctamente la estructura de datos en ABB y AVL.
        Aplicar rotaciones en el AVL cuando sea necesario.
        Utilizar buenas prácticas de programación y estructura modular.
        Responder a:
        Diferencias entre ABB y AVL en términos de rendimiento.
        Proceso de eliminación de un nodo con dos hijos en ABB.
        Casos en los que se aplican rotaciones en AVL.
    Nota:
        El programa debe ejecutarse en consola, permitiendo al usuario seleccionar opciones mediante un menú interactivo. */

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Menu menu = new Menu();
        menu.mostrarMenu();
    }
    
}
