package principal;
import controller.ControladorAcademico;
import model.RegistroAcademico;
import view.VistaAcademica;
/**
 *
 * @author daniel
 */
/**
 * Desarrolla una aplicación de gestión académica, donde se maneje la información 
 * de alumnos y sus calificaciones. Implementa el patrón MVC para estructurar la aplicación.
 *
 * - Clase Alumno con atributos para nombre, edad y lista de calificaciones.
 * - Clase RegistroAcademico que gestione una colección de alumnos, permitiendo 
 *   operaciones como añadir alumnos, registrar calificaciones y calcular promedios.
 * - Clase ControladorAcademico que maneje la lógica de negocio entre la vista y el modelo.
 * - Clase VistaAcademica que proporciona una interfaz de usuario para interactuar con el 
 *   sistema mediante un menú con las siguientes opciones:
 *
 *   1. Mostrar lista de alumnos.
 *   2. Añadir nuevo alumno.
 *   3. Registrar calificaciones para un alumno.
 *   4. Calcular promedio de un alumno.
 *   5. Salir del sistema.
 */

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RegistroAcademico registro = new RegistroAcademico();
        VistaAcademica vista = new VistaAcademica();
        ControladorAcademico controlador = new ControladorAcademico(registro, vista);
        controlador.iniciar();
    }
    
}
