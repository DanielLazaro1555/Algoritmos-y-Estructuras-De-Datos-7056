/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author daniel
 */
/**
 * Clase GestorInventario
 * Contiene métodos para gestionar operaciones sobre inventarios.
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
public class GestorInventario {

    // Validar que los datos de un producto sean correctos
    public boolean validarProducto(Producto producto) {
        return producto.getPrecio() > 0 && producto.getCantidad() >= 0 && !producto.getNombre().isEmpty();
    }

    // Clonar un inventario
    public List<Producto> clonarInventario(List<Producto> inventario) {
        List<Producto> clon = new ArrayList<>();
        for (Producto producto : inventario) {
            clon.add(new Producto(producto.getNombre(), producto.getPrecio(), producto.getCantidad()));
        }
        return clon;
    }

    // Comparar dos inventarios
    public boolean compararInventarios(List<Producto> inventario1, List<Producto> inventario2) {
        if (inventario1.size() != inventario2.size()) {
            return false;
        }

        // Ordenar los inventarios para comparación
        inventario1.sort(Comparator.comparing(Producto::getNombre));
        inventario2.sort(Comparator.comparing(Producto::getNombre));

        for (int i = 0; i < inventario1.size(); i++) {
            if (!inventario1.get(i).equals(inventario2.get(i))) {
                return false;
            }
        }
        return true;
    }

    // Fusionar dos inventarios
    public List<Producto> fusionarInventarios(List<Producto> inventario1, List<Producto> inventario2) {
        List<Producto> fusion = new ArrayList<>(inventario1);

        // Agregar productos del segundo inventario al primero
        for (Producto producto : inventario2) {
            fusion.add(new Producto(producto.getNombre(), producto.getPrecio(), producto.getCantidad()));
        }

        // Ordenar por precio
        fusion.sort(Comparator.comparingDouble(Producto::getPrecio));
        return fusion;
    }
}
