package principal;
import controller.ControladorOrganizacion;
import model.GestorOrganizacion;
import view.VistaOrganizacion;
/**
 *
 * @author daniel
 */

/**
 * Una empresa de consultoría está organizando la estructura jerárquica de su personal en un árbol binario 
 * de decisiones, con el director general como raíz y los empleados subordinados en los nodos. 
 * 
 * El sistema debe permitir insertar nuevos empleados respetando la jerarquía (un empleado puede tener 
 * máximo dos subordinados directos), eliminar empleados y reorganizar la jerarquía cuando un empleado 
 * es eliminado, reasignando a sus subordinados a su supervisor inmediato. 
 * 
 * Se debe implementar la estructura de datos con las clases:
 * - `Empleado`
 * - `ArbolBinario`
 * - `GestorOrganizacion`
 * 
 * Asegurando que el árbol respete las reglas de negocio. El sistema debe permitir al usuario insertar 
 * y eliminar empleados, y mostrar la jerarquía usando los recorridos Preorden, Inorden y Postorden.
 * 
 * Adicionalmente, se deben implementar las siguientes funcionalidades:
 * 
 * - Buscar un empleado: Permitir al usuario buscar un empleado por su ID o nombre en el árbol. 
 *   El sistema debe indicar si el empleado se encuentra en la jerarquía o no.
 * 
 * - Modificar información del empleado: Ofrecer la opción de modificar los datos de un empleado, 
 *   como su nombre, puesto o supervisor (si el puesto lo permite).
 * 
 * - Contar el número de empleados: Permitir al usuario consultar cuántos empleados hay en el árbol en total, 
 *   considerando todos los niveles jerárquicos.
 * 
 * - Obtener el nivel de un empleado: El sistema debe permitir al usuario conocer el nivel jerárquico 
 *   de un empleado dentro del árbol, es decir, cuántos niveles por debajo del director general se encuentra.
 * 
 * - Listar subordinados de un empleado: El sistema debe permitir visualizar los subordinados directos 
 *   de un empleado dado, mostrando los empleados a los que reporta directamente.
 * 
 * - Generar reporte jerárquico: El sistema debe generar un reporte en formato de texto o consola que 
 *   muestre la jerarquía completa de la empresa, mostrando a cada empleado con su supervisor directo.
 * 
 * - Validación de duplicados: Evitar la inserción de empleados con el mismo ID o nombre 
 *   (dependiendo de las reglas de negocio de la empresa).
 * 
 * - Reestructuración del árbol: En caso de que un supervisor tenga más de dos subordinados, 
 *   el sistema debe permitir realizar una reestructuración automática del árbol, 
 *   asignando a los empleados excedentes al siguiente nivel disponible.
 * 
 * - Eliminar subordinados de un empleado: Permitir al usuario eliminar a un subordinado directo 
 *   de un empleado específico, reasignando su posición dentro del árbol sin alterar 
 *   la estructura jerárquica de los demás empleados.
 * 
 * - Mostrar empleados por nivel jerárquico: Permitir al usuario consultar todos los empleados 
 *   de un nivel específico de la jerarquía, por ejemplo, todos los gerentes o jefes de departamento, 
 *   de forma ordenada.
 * 
 * Estas funcionalidades deben implementarse respetando la estructura de árbol binario, y considerando 
 * el uso adecuado de buenas prácticas de programación orientada a objetos (POO). 
 * 
 * El sistema debe ser interactivo, permitiendo al usuario realizar las operaciones mencionadas 
 * a través de un menú de opciones, con validaciones y mensajes claros sobre el estado de las operaciones.
 */

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestorOrganizacion gestor = new GestorOrganizacion();
        VistaOrganizacion vista = new VistaOrganizacion();
        ControladorOrganizacion controlador = new ControladorOrganizacion(gestor, vista);
        controlador.iniciar();
    }
    
}
