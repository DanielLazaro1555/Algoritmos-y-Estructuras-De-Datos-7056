package controller;

import model.Document;
import model.UndoRedoManager;

/**
 *
 * @author daniel
 */
public class DocumentController {

    private Document document;
    private UndoRedoManager undoRedoManager;

    /**
     * Constructor que inicializa el documento y el gestor de deshacer/rehacer.
     */
    public DocumentController() {
        this.document = new Document();
        this.undoRedoManager = new UndoRedoManager();
    }

    /**
     * Permite editar el contenido del documento, guardando el estado previo
     * antes de la modificación.
     *
     * @param newContent El nuevo contenido del documento.
     */
    public void editDocument(String newContent) {
        if (!newContent.isEmpty()) {
            undoRedoManager.saveState(document.getContent()); // Guarda el estado antes de modificar
            document.setContent(newContent); // Modifica el documento con el nuevo contenido
        } else {
            System.out.println("⚠ No se puede guardar contenido vacío.");
        }
    }

    /**
     * Realiza la operación de deshacer (undo) restaurando el estado previo del
     * documento.
     */
    public void undo() {
        String previousState = undoRedoManager.undo();
        if (previousState != null) {
            document.setContent(previousState);
            System.out.println("✔ Se ha deshecho el último cambio.");
        } else {
            System.out.println("⚠ No hay cambios para deshacer.");
        }
    }

    /**
     * Realiza la operación de rehacer (redo) restaurando la versión más
     * reciente eliminada.
     */
    public void redo() {
        String nextState = undoRedoManager.redo();
        if (nextState != null) {
            document.setContent(nextState);
            System.out.println("✔ Se ha re-hecho el último cambio.");
        } else {
            System.out.println("⚠ No hay cambios para rehacer.");
        }
    }

    /**
     * Muestra el contenido actual del documento.
     */
    public void displayDocument() {
        document.displayContent();
    }
}
