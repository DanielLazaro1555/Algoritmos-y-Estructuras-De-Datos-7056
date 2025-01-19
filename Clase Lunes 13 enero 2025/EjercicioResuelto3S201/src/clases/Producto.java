/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author daniel
 */
/**
 * Clase Producto
 * Representa un producto con nombre, precio y cantidad en stock.
 * El negocio ha decidido realizar simulaciones adicionales con su sistema de gestión de inventario para optimizar
las operaciones con productos electrónicos. Ahora, además de las operaciones básicas, se requiere trabajar
con nuevas funcionalidades que impliquen la clonación, fusión y comparación de inventarios. Estas
funcionalidades permitirán mejorar el análisis y gestión de los productos registrados.
En esta actividad, trabajarás con dos inventarios de productos electrónicos representados como arreglos
unidimensionales. Ambos inventarios tendrán las mismas características (nombre, precio y cantidad en stock
por producto). El objetivo es implementar las siguientes funcionalidades:
Operaciones a implementar:
• Clonación de inventario: Crea una copia exacta de uno de los inventarios y muestra el contenido del
inventario original y del inventario clonado. Asegúrate de que los cambios realizados en uno de los arreglos
no afecten al otro.
• Fusión de inventarios: Combina los productos de ambos inventarios en un solo arreglo, sin perder datos.
Ordena el inventario resultante de la fusión por precio (de menor a mayor) y muestra el listado final.
* • Comparación de inventarios: Implementa una funcionalidad que permita verificar si ambos inventarios
tienen exactamente los mismos productos (mismos nombres, precios y cantidades, sin importar el orden).
Muestra un mensaje indicando si los inventarios son iguales o diferentes.
• Validación de datos de entrada: Asegúrate de que los datos ingresados para nombre, precio y cantidad
cumplan con los criterios establecidos (por ejemplo, precio > 0, cantidad ≥ 0). Solicita nuevamente los datos
si no son válidos.
Al finalizar la actividad, deberás:
• Mostrar el inventario original y su copia al realizar la clonación.
• Mostrar el inventario resultante de la fusión, ordenado por precio.
• Indicar si los dos inventarios (originales) son iguales o diferentes al realizar la comparación.
• Demostrar la correcta validación de datos en las operaciones implementadas.
 */
public class Producto {
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return String.format("Producto: %s, Precio: %.2f, Cantidad: %d", nombre, precio, cantidad);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Producto)) return false;
        Producto other = (Producto) obj;
        return nombre.equalsIgnoreCase(other.nombre) &&
               Double.compare(precio, other.precio) == 0 &&
               cantidad == other.cantidad;
    }
}
