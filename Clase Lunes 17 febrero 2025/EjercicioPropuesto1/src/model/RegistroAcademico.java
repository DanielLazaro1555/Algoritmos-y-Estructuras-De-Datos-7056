package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daniel
 */
public class RegistroAcademico {

    private List<Alumno> alumnos;

    public RegistroAcademico() {
        this.alumnos = new ArrayList<>();
    }

    public void agregarAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    public Alumno buscarAlumno(String nombre) {
        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equalsIgnoreCase(nombre)) {
                return alumno;
            }
        }
        return null;
    }

    public List<Alumno> obtenerAlumnos() {
        return alumnos;
    }
}
