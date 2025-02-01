package principal;

import controller.GestorEstudiantes;
import view.Menu;

/**
 *
 * @author daniel
 */
/**
 * Se necesita una aplicación para gestionar el registro de estudiantes junto
 * con sus calificaciones en diversas asignaturas utilizando listas enlazadas.
 *
 * El sistema debe permitir al usuario registrar estudiantes, mostrando su
 * nombre y calificaciones, y luego calcular su promedio general.
 *
 * La lista de estudiantes debe ser ordenada por promedio general utilizando
 * diferentes algoritmos de ordenamiento. El usuario debe tener la opción de
 * elegir qué algoritmo desea utilizar.
 *
 * Además, el sistema debe permitir mostrar la lista original de estudiantes y
 * calificaciones, la lista ordenada por promedio general y proporcionar la
 * funcionalidad de búsqueda, para que los usuarios puedan buscar estudiantes
 * por nombre.
 *
 * Cada estudiante será representado como un nodo en la lista enlazada, con su
 * nombre, un arreglo de calificaciones y su promedio general calculado
 * automáticamente.
 *
 * El sistema debe también ofrecer la opción de eliminar estudiantes por nombre,
 * y la lista debe reordenarse al eliminar un estudiante.
 *
 * La estructura de la lista enlazada facilita estas operaciones dinámicas sin
 * necesidad de redimensionar estructuras fijas, mejorando la flexibilidad y
 * eficiencia del sistema en la gestión de estudiantes y sus calificaciones.
 */
public class Main {

    public static void main(String[] args) {
        GestorEstudiantes gestor = new GestorEstudiantes();
        Menu.mostrarMenu(gestor); // Llama al menú para iniciar la interacción con el usuario
    }
}
