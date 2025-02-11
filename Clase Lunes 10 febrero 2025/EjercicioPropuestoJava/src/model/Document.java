package model;

/**
 *
 * @author daniel
 */
public class Document {

    private String content;

    /**
     * Constructor que inicializa el documento con un contenido vacío.
     */
    public Document() {
        this.content = "";
    }

    /**
     * Método para obtener el contenido actual del documento.
     *
     * @return El contenido del documento como una cadena de texto.
     */
    public String getContent() {
        return content;
    }

    /**
     * Método para actualizar el contenido del documento.
     *
     * @param newContent El nuevo contenido que se asignará al documento.
     */
    public void setContent(String newContent) {
        this.content = newContent;
    }

    /**
     * Método para mostrar el contenido del documento en consola.
     */
    public void displayContent() {
        System.out.println("\n--- Contenido del Documento ---");
        if (content.isEmpty()) {
            System.out.println("(Documento vacío)");
        } else {
            System.out.println(content); // Imprime el contenido completo sin truncarlo
        }
        System.out.println("-------------------------------");
    }
}
