package controller;
import model.Empleado;
import model.GestorOrganizacion;
import view.VistaOrganizacion;
/**
 *
 * @author daniel
 */
public class ControladorOrganizacion {
    private GestorOrganizacion gestor;
    private VistaOrganizacion vista;

    public ControladorOrganizacion(GestorOrganizacion gestor, VistaOrganizacion vista) {
        this.gestor = gestor;
        this.vista = vista;
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            int opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    int id = vista.leerEntero("Ingrese ID del empleado: ");
                    String nombre = vista.leerCadena("Ingrese nombre: ");
                    String puesto = vista.leerCadena("Ingrese puesto: ");
                    if (gestor.agregarEmpleado(new Empleado(id, nombre, puesto))) {
                        vista.mostrarMensaje("✅ Empleado añadido correctamente.");
                    } else {
                        vista.mostrarMensaje("❌ Error: ID ya existe.");
                    }
                    break;
                case 2:
                    gestor.mostrarEstructura();
                    break;
                case 3:
                    salir = true;
                    vista.mostrarMensaje("👋 Saliendo del sistema...");
                    break;
                default:
                    vista.mostrarMensaje("❌ Opción inválida.");
            }
        }
    }
}