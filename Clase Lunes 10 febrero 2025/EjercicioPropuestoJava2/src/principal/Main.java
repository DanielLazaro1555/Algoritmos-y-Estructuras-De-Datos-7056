package principal;

import view.ConsoleView;

/**
 *
 * @author daniel
 */
/**
 * Un negocio necesita un sistema para gestionar su inventario de productos
 * electrónicos. Actualmente, manejan su inventario de manera manual, lo que
 * genera ineficiencias, errores en el control de stock y dificultades para
 * actualizar la información de los productos.
 *
 * El nuevo sistema debe permitir: - Registrar productos - Consultar datos -
 * Actualizar información - Eliminar productos de manera sencilla
 *
 * En las primeras etapas del desarrollo, el sistema trabajará con pilas (Stack)
 * para almacenar y gestionar los datos de los productos, siguiendo la
 * estructura LIFO (Last In, First Out). Posteriormente, se podrá mejorar con
 * estructuras más avanzadas.
 *
 * 📌 Cada producto tendrá la siguiente información: - Nombre: Cadena de texto
 * que identifica al producto (por ejemplo, "Laptop Dell"). - Precio: Valor
 * numérico que indica el costo del producto. - Cantidad en stock: Número entero
 * que representa la cantidad disponible del producto.
 *
 * ======================== APLICACIÓN DEL SISTEMA: ======================== El
 * sistema debe realizar las siguientes operaciones con la pila:
 *
 * 📌 Agregar un producto (push) - Insertar un nuevo producto en la pila,
 * verificando que no exceda la capacidad máxima. - El último producto ingresado
 * será el primero en ser eliminado.
 *
 * 📌 Eliminar un producto (pop) - Retirar el producto que se encuentra en la
 * cima de la pila. - Si la pila está vacía, mostrar un mensaje de error.
 *
 * 📌 Consultar el último producto agregado (peek) - Mostrar la información del
 * producto en la cima sin eliminarlo.
 *
 * 📌 Mostrar todo el inventario - Iterar sobre la pila y mostrar todos los
 * productos registrados, respetando el orden LIFO.
 *
 * 📌 Copiar el inventario - Crear una copia exacta de la pila actual y mostrar
 * el resultado.
 *
 * ============================ FUNCIONALIDADES ADICIONALES:
 * ============================ 📌 Validación de datos de entrada: - Asegurar
 * que los valores ingresados para precio y cantidad sean válidos. - Si el
 * usuario ingresa datos incorrectos, mostrar un mensaje de error y solicitar
 * nuevamente los datos.
 *
 * 📌 Implementar un método de búsqueda: - Permitir al usuario buscar un
 * producto por su nombre en la pila sin modificarla. - Indicar un mensaje si el
 * producto no se encuentra.
 *
 * 📌 Ordenar el inventario por precio: - Implementar una funcionalidad para
 * ordenar los productos en la pila en función de su precio (de menor a mayor).
 * - Mostrar el inventario ordenado sin perder la estructura de la pila.
 *
 * 📌 Ampliar la capacidad de la pila: - Simular el crecimiento del inventario
 * implementando un mecanismo para duplicar el tamaño de la pila cuando esté
 * llena. - Copiar todos los elementos al nuevo arreglo.
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView();
        consoleView.showMenu(); // Iniciar el menú de la aplicación
    }

}
