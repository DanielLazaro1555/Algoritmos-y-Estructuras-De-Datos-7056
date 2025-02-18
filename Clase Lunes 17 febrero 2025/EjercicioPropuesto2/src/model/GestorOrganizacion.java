package model;

/**
 *
 * @author daniel
 */
public class GestorOrganizacion {
    private ArbolBinario arbol;

    public GestorOrganizacion() {
        this.arbol = new ArbolBinario();
    }

    public boolean agregarEmpleado(Empleado empleado) {
        return arbol.insertar(empleado);
    }

    public void mostrarEstructura() {
        System.out.println("\n🌍 Estructura de la empresa (Inorden):");
        arbol.inorden();
    }
}