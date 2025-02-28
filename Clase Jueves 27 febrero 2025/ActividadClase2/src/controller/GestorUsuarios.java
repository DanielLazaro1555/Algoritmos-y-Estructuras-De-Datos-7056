package controller;
import model.ABB;
import model.AVL;
import model.Usuario;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author daniel
 */
/**
 * Clase controladora que gestiona las operaciones en los árboles ABB y AVL.
 * Se encarga de insertar, buscar, eliminar y mostrar usuarios en ambos árboles.
 */
public class GestorUsuarios {
    private ABB abb;  // Árbol Binario de Búsqueda
    private AVL avl;  // Árbol AVL

    /**
     * Constructor que inicializa los árboles ABB y AVL.
     */
    public GestorUsuarios() {
        this.abb = new ABB();
        this.avl = new AVL();
    }

    /**
     * Método para registrar un usuario en ambos árboles.
     * 
     * @param id ID único del usuario.
     * @param nombre Nombre del usuario.
     * @param correo Correo electrónico del usuario.
     * @param nivelAcceso Nivel de acceso (1 = Básico, 2 = Intermedio, 3 = Avanzado).
     */
    public void registrarUsuario(int id, String nombre, String correo, int nivelAcceso) {
        Usuario nuevoUsuario = new Usuario(id, nombre, correo, nivelAcceso);
        abb.insertar(nuevoUsuario);
        avl.insertar(nuevoUsuario);
        System.out.println("✅ Usuario registrado correctamente en ABB y AVL.");
    }

    /**
     * Método para buscar un usuario por ID en ambos árboles.
     * 
     * @param id ID del usuario a buscar.
     */
    public void buscarUsuario(int id) {
        Usuario usuarioABB = abb.buscar(id);
        Usuario usuarioAVL = avl.buscar(id);

        if (usuarioABB != null) {
            System.out.println("🔍 Usuario encontrado en ABB: " + usuarioABB);
        } else {
            System.out.println("❌ Usuario no encontrado en ABB.");
        }

        if (usuarioAVL != null) {
            System.out.println("🔍 Usuario encontrado en AVL: " + usuarioAVL);
        } else {
            System.out.println("❌ Usuario no encontrado en AVL.");
        }
    }

    /**
     * Método para eliminar un usuario en ambos árboles.
     * 
     * @param id ID del usuario a eliminar.
     */
    public void eliminarUsuario(int id) {
        abb.eliminar(id);
        avl.eliminar(id);
        System.out.println("🗑️ Usuario eliminado correctamente en ABB y AVL.");
    }

    /**
     * Método para mostrar todos los usuarios ordenados por ID.
     */
    public void mostrarUsuarios() {
        System.out.println("📌 Usuarios en ABB (Orden ascendente por ID):");
        abb.mostrarInorden();

        System.out.println("\n📌 Usuarios en AVL (Orden ascendente por ID):");
        avl.mostrarInorden();
    }

    /**
     * Método para mostrar usuarios de un nivel de acceso específico.
     * 
     * @param nivelAcceso Nivel de acceso a filtrar (1 = Básico, 2 = Intermedio, 3 = Avanzado).
     */
    public void mostrarUsuariosPorNivel(int nivelAcceso) {
        System.out.println("\n📌 Usuarios con nivel de acceso " + nivelAcceso + ":");

        // Lista temporal para almacenar usuarios con el nivel especificado
        List<Usuario> usuariosFiltrados = new ArrayList<>();

        // Recorrer ABB y almacenar usuarios con el nivel deseado
        obtenerUsuariosPorNivel(abb, abb.getRaiz(), nivelAcceso, usuariosFiltrados);
        
        // Mostrar resultados
        if (usuariosFiltrados.isEmpty()) {
            System.out.println("❌ No se encontraron usuarios con este nivel de acceso.");
        } else {
            for (Usuario u : usuariosFiltrados) {
                System.out.println(u);
            }
        }
    }

    /**
     * Método auxiliar para recorrer el ABB y filtrar usuarios por nivel de acceso.
     */
    private void obtenerUsuariosPorNivel(ABB abb, model.Nodo nodo, int nivelAcceso, List<Usuario> usuariosFiltrados) {
        if (nodo != null) {
            obtenerUsuariosPorNivel(abb, nodo.getIzquierdo(), nivelAcceso, usuariosFiltrados);
            if (nodo.getUsuario().getNivelAcceso() == nivelAcceso) {
                usuariosFiltrados.add(nodo.getUsuario());
            }
            obtenerUsuariosPorNivel(abb, nodo.getDerecho(), nivelAcceso, usuariosFiltrados);
        }
    }
}