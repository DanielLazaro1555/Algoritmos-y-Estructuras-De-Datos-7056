package principal;
import controller.InventarioController;
/**
 *
 * @author daniel
 */
/**
 * Además del uso de pilas para el almacenamiento de productos, se introduce el uso de colas 
 * para mejorar la gestión del inventario y facilitar operaciones adicionales.
 * 
 * 📌 Las colas se emplearán en dos áreas clave:
 * - Cola de Pedidos Pendientes: Manejar pedidos de clientes en espera, asegurando que se atienden en orden FIFO (First In, First Out).
 * - Cola de Productos en Reposición: Almacenar productos que necesitan ser reabastecidos, asegurando que se reponen en el orden en que se solicitaron.
 * 
 * 🚀 Operaciones con Pilas (LIFO)
 * - 📌 Agregar un producto (push)
 * - 📌 Eliminar un producto (pop)
 * - 📌 Consultar el último producto agregado (peek)
 * - 📌 Mostrar todo el inventario
 * - 📌 Copiar el inventario
 * - 📌 Búsqueda de productos
 * - 📌 Ordenar productos por precio
 * - 📌 Ampliar la capacidad de la pila
 * 
 * 🚀 Operaciones con Colas (FIFO)
 * ✅ Registrar un pedido en espera (Agregar un pedido a la cola de pedidos pendientes).
 * ✅ Atender un pedido (Eliminar el primer pedido de la cola y actualizar stock si hay disponibilidad).
 * ✅ Mostrar pedidos pendientes (Mostrar la cola sin modificarla).
 * ✅ Registrar una reposición de producto (Agregar un producto a la cola de reposiciones cuando el stock sea insuficiente).
 * ✅ Procesar reposición (Atender una reposición, sacando el primer elemento de la cola y actualizando stock si es necesario).
 * ✅ Mostrar la cola de reposiciones (Consultar la lista de productos en espera de reposición sin eliminarlos).
 * 
 * 📍 Notas importantes:
 * - Los productos en inventario siguen la lógica de pila (LIFO), ya que los últimos ingresados son los primeros en venderse.
 * - Los pedidos de clientes se manejan en una cola (FIFO), asegurando que los pedidos más antiguos se atienden primero.
 * - La reposición de productos también se maneja en una cola (FIFO) para evitar demoras en el reabastecimiento.
 * - Se debe manejar errores y excepciones cuando el inventario esté vacío o no haya suficiente stock para atender pedidos.
 */

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new InventarioController().ejecutar();
    }
    
}
