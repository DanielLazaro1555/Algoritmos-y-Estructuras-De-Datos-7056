package principal;
import controller.ColaController;

/**
 *
 * @author daniel
 */

/**
 * Una empresa de atención al cliente necesita una gestión avanzada de clientes.
 * Se requiere una cola priorizada, donde los clientes pueden ser regulares o VIP.
 * Los clientes VIP siempre tienen prioridad sobre los regulares, manteniendo el 
 * orden de llegada entre los clientes del mismo tipo.
 * 
 * Requisitos:
 * ✅ Implementar la cola dinámica con listas enlazadas manualmente (sin usar Deque ni LinkedList de Java).
 * ✅ Implementar una cola con prioridad, donde los clientes VIP se atienden antes que los clientes regulares.
 * ✅ Manejar excepciones y validaciones para evitar errores en la manipulación de la cola.
 * ✅ Aplicar buenas prácticas de POO, incluyendo encapsulación y separación de responsabilidades (arquitectura MVC).
 * ✅ Implementar un menú interactivo en consola para gestionar la cola.
 * 
 * Características:
 * 📌 Cada cliente tiene un nombre, número de ticket y tipo (VIP o Regular).
 * 📌 Los clientes VIP se atienden antes que los clientes regulares, pero los VIP siguen un orden FIFO entre ellos.
 * 📌 La cola debe permitir las siguientes operaciones:
 *      1. Registrar un cliente (Regular o VIP).
 *      2. Atender a un cliente (Eliminar el cliente con mayor prioridad).
 *      3. Ver el siguiente cliente en la cola (sin eliminarlo).
 *      4. Mostrar toda la cola.
 *      5. Contar el número de clientes en espera.
 *      6. Vaciar la cola.
 */

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ColaController().ejecutar();
    }
    
}
