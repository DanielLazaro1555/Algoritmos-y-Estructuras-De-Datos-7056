package principal;

import view.ConsoleView;

/**
 *
 * @author daniel
 */
/**
 * En una empresa, los empleados suelen trabajar con documentos de texto que
 * requieren ediciones constantes. Sin embargo, un problema frecuente es la
 * necesidad de deshacer cambios recientes o rehacer modificaciones eliminadas
 * accidentalmente. Para resolver esta situación, se solicita desarrollar un
 * sistema de gestión de cambios para documentos, que permita registrar el
 * historial de modificaciones y aplicar las operaciones de deshacer (undo) y
 * rehacer (redo).
 *
 * El sistema debe ser capaz de: 1. Permitir la edición del contenido de un
 * documento. 2. Guardar automáticamente el estado anterior antes de realizar
 * una nueva edición. 3. Deshacer el último cambio realizado, restaurando el
 * contenido previo del documento. 4. Rehacer un cambio deshecho, restaurando la
 * versión más reciente si se deshizo una modificación. 5. Mostrar el contenido
 * actual del documento en cualquier momento. 6. Garantizar una interfaz
 * intuitiva en consola, para que los empleados puedan interactuar con
 * facilidad.
 *
 * Requerimientos del Sistema: - El sistema debe seguir el modelo MVC para una
 * separación clara de responsabilidades. - La gestión de deshacer y rehacer
 * debe implementarse utilizando la estructura de datos Stack (Pila). - El
 * sistema debe desarrollarse en Java, aplicando buenas prácticas de
 * programación y manteniendo la independencia de clases en archivos separados.
 * - La interacción con el usuario será mediante una interfaz en consola, con un
 * menú de opciones para facilitar la edición del documento.
 *
 * Flujo del Sistema: 1. El usuario accede al sistema y elige una opción del
 * menú. 2. Si selecciona "Editar documento", el sistema guarda el estado actual
 * en la pila de deshacer y permite modificar el contenido. 3. Si el usuario
 * elige "Deshacer", el sistema restaura la última versión guardada y mueve la
 * versión actual a la pila de rehacer. 4. Si el usuario selecciona "Rehacer",
 * se restaura la versión más reciente eliminada y se almacena el estado actual
 * en la pila de deshacer. 5. El usuario puede visualizar el contenido del
 * documento en cualquier momento. 6. Puede salir del sistema cuando lo desee.
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
