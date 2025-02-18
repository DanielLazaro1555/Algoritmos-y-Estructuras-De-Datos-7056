package controller;

import model.Alumno;
import model.RegistroAcademico;
import view.VistaAcademica;

/**
 *
 * @author daniel
 */
public class ControladorAcademico {
    private RegistroAcademico registro;
    private VistaAcademica vista;

    public ControladorAcademico(RegistroAcademico registro, VistaAcademica vista) {
        this.registro = registro;
        this.vista = vista;
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            int opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    vista.mostrarMensaje("\nLista de alumnos:");
                    if (registro.obtenerAlumnos().isEmpty()) {
                        vista.mostrarMensaje("📌 No hay alumnos registrados.");
                    } else {
                        for (Alumno alumno : registro.obtenerAlumnos()) {
                            vista.mostrarMensaje("🧑 " + alumno.getNombre() + " - Edad: " + alumno.getEdad());
                        }
                    }
                    break;
                case 2:
                    String nombre = vista.leerCadena("Ingrese nombre del alumno: ");
                    int edad = vista.leerEntero("Ingrese edad: ");
                    registro.agregarAlumno(new Alumno(nombre, edad));
                    vista.mostrarMensaje("✅ Alumno agregado correctamente.");
                    break;
                case 3:
                    nombre = vista.leerCadena("Ingrese nombre del alumno: ");
                    Alumno alumno = registro.buscarAlumno(nombre);
                    if (alumno != null) {
                        double calificacion = vista.leerDouble("Ingrese calificación: ");
                        alumno.agregarCalificacion(calificacion);
                        vista.mostrarMensaje("✅ Calificación añadida.");
                    } else {
                        vista.mostrarMensaje("❌ Alumno no encontrado.");
                    }
                    break;
                case 4:
                    nombre = vista.leerCadena("Ingrese nombre del alumno: ");
                    alumno = registro.buscarAlumno(nombre);
                    if (alumno != null) {
                        double promedio = alumno.calcularPromedio();
                        vista.mostrarMensaje("📊 Promedio de " + alumno.getNombre() + ": " + promedio);
                    } else {
                        vista.mostrarMensaje("❌ Alumno no encontrado.");
                    }
                    break;
                case 5:
                    salir = true;
                    vista.mostrarMensaje("👋 Saliendo del sistema...");
                    break;
                default:
                    vista.mostrarMensaje("❌ Opción inválida.");
            }
        }
    }
}