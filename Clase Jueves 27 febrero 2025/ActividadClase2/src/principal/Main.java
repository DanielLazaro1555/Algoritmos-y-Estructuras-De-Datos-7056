package principal;
import view.Menu;
/**
 *
 * @author daniel
 */
/**
 * Una empresa de tecnología requiere un sistema para gestionar los usuarios de su plataforma.
 * Para garantizar eficiencia en las búsquedas y operaciones, los datos se almacenarán en un
 * Árbol Binario de Búsqueda (ABB) y en un Árbol AVL, permitiendo comparar su rendimiento.
 *
 * Cada usuario tendrá los siguientes atributos:
 * - ID (entero, único)
 * - Nombre (cadena de texto)
 * - Correo electrónico (cadena de texto)
 * - Nivel de acceso (entero: 1 = Básico, 2 = Intermedio, 3 = Avanzado)
 *
 * El sistema debe permitir:
 * - Registrar un usuario en ambos árboles.
 * - Buscar un usuario por ID y mostrar su información.
 * - Eliminar un usuario, asegurando que el AVL se mantenga balanceado.
 * - Mostrar todos los usuarios ordenados por ID mediante recorrido inorden.
 * - Mostrar usuarios de un determinado nivel de acceso.
 *
 * Implementación en Java siguiendo el patrón MVC, separando las clases en paquetes:
 * - modelo: clases Usuario, Nodo, ABB, AVL.
 * - controlador: clase GestorUsuarios que maneje las operaciones en ambos árboles.
 * - vista: clase Menu que permita la interacción con el usuario.
 *
 * Requisitos:
 * 1. Utilizar entrada por teclado (Scanner) para ingresar datos y navegar en un menú interactivo.
 * 2. Aplicar rotaciones en el AVL cuando sea necesario para mantener el balanceo.
 */

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
