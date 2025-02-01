package principal;

import controller.GestorInventario;
import view.Menu;

/**
 *
 * @author daniel
 */

/**
 * Sistema de Gestión de Inventario de Productos Electrónicos
 *
 * El negocio necesita un sistema para gestionar su inventario de productos
 * electrónicos. Actualmente, tienen un sistema manual que presenta
 * ineficiencias y errores en el control de stock.
 *
 * El nuevo sistema debe permitir: - Registrar productos - Consultar datos -
 * Actualizar información - Eliminar productos de manera sencilla
 *
 * En esta etapa inicial, el sistema usará listas enlazadas para manejar los
 * datos de los productos. Además de las operaciones básicas de inserción,
 * eliminación y actualización, se añadirán operaciones de: - Recorrido de la
 * lista - Búsqueda de productos - Ordenamiento de productos
 *
 * Operaciones Básicas: 1. Agregar un producto: Insertar un nuevo producto al
 * inventario. 2. Actualizar un producto: Modificar los datos de un producto
 * existente. 3. Eliminar un producto: Eliminar un producto dado su nombre
 * (buscado por nombre). 4. Mostrar el inventario: Mostrar todos los productos
 * registrados en la lista enlazada. 5. Buscar un producto: Buscar un producto
 * por nombre. 6. Ordenar el inventario por precio: Ordenar los productos por su
 * precio (de menor a mayor).
 *
 * APLICACIÓN: El sistema se basa en una lista enlazada simple para almacenar
 * los productos, donde cada nodo representará un producto. Cada nodo de la
 * lista tendrá tres partes: - Datos del producto: (nombre, precio, cantidad) -
 * Referencia al siguiente nodo: Puntero que apunta al siguiente nodo en la
 * lista
 *
 * Cada vez que un nuevo producto se agrega, se crea un nodo con los datos del
 * producto y se enlaza con el siguiente nodo en la lista.
 *
 * Funcionalidades: - Inserción al final (Agregar un nuevo producto): Agrega un
 * producto al final de la lista enlazada. - Eliminación por nombre (Eliminar un
 * producto y reordenar los nodos): Busca un producto por su nombre y, si se
 * encuentra, lo elimina.
 *
 * APLICACIÓN: - Recorrido del Inventario: Permite recorrer la lista enlazada de
 * productos y mostrar todos los productos registrados. - Búsqueda de un
 * Producto por Nombre: Permite buscar un producto por su nombre y mostrar su
 * información si existe. - Ordenamiento del Inventario por Precio (de menor a
 * mayor): Ordena los productos del inventario según su precio usando un
 * algoritmo de ordenamiento.
 *
 * Validaciones del Sistema: - Validación de Precio: El precio debe ser mayor
 * que 0 antes de permitir la inserción o actualización. - Validación de
 * Cantidad: La cantidad debe ser mayor o igual a 0 antes de registrar o
 * actualizar productos. - Validación de Existencia al Eliminar o Buscar:
 * Verifica si el producto existe en el inventario antes de eliminarlo o
 * buscarlo.
 *
 * APLICACIÓN - Flujo de Trabajo: - Agregar Producto: El usuario puede agregar
 * un producto con nombre, precio y cantidad, insertándolo al final de la lista
 * enlazada. - Actualizar Producto: Si el producto existe en el inventario, se
 * actualizará su precio y/o cantidad. - Eliminar Producto: El producto será
 * buscado por nombre y, si se encuentra, será eliminado de la lista. - Mostrar
 * Inventario: El sistema recorrerá la lista y mostrará todos los productos
 * registrados en el inventario. - Buscar Producto: El sistema buscará un
 * producto por nombre y mostrará sus detalles si lo encuentra. - Ordenar
 * Inventario: El sistema ordenará los productos del inventario por precio, de
 * menor a mayor.
 */
public class Main {

    public static void main(String[] args) {
        GestorInventario gestor = new GestorInventario();
        Menu.mostrarMenu(gestor);
    }
}
