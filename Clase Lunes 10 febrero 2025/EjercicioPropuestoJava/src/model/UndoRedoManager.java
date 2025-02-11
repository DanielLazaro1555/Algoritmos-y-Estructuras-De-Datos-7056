package model;

import java.util.Stack;

/**
 *
 * @author daniel
 */
public class UndoRedoManager {

    private Stack<String> undoStack;
    private Stack<String> redoStack;

    /**
     * Constructor que inicializa las pilas de deshacer y rehacer.
     */
    public UndoRedoManager() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    /**
     * Guarda el estado actual en la pila de deshacer y limpia la pila de
     * rehacer.
     *
     * @param currentState El estado actual del documento.
     */
    public void saveState(String currentState) {
        undoStack.push(currentState);
        redoStack.clear(); // Al editar, la pila de rehacer debe vaciarse
    }

    /**
     * Deshace la última modificación y la mueve a la pila de rehacer.
     *
     * @return El estado anterior del documento o null si no hay cambios
     * previos.
     */
    public String undo() {
        if (!undoStack.isEmpty()) {
            String lastState = undoStack.pop();
            redoStack.push(lastState);
            return undoStack.isEmpty() ? "" : undoStack.peek(); // Devuelve el estado anterior o vacío si no hay más
        }
        return null; // No hay nada para deshacer
    }

    /**
     * Rehace un cambio previamente deshecho y lo guarda en la pila de deshacer.
     *
     * @return El estado más reciente del documento o null si no hay nada que
     * rehacer.
     */
    public String redo() {
        if (!redoStack.isEmpty()) {
            String lastRedo = redoStack.pop();
            undoStack.push(lastRedo);
            return lastRedo;
        }
        return null; // No hay nada para rehacer
    }

    /**
     * Verifica si hay estados disponibles para deshacer.
     *
     * @return true si se puede deshacer, false en caso contrario.
     */
    public boolean canUndo() {
        return !undoStack.isEmpty();
    }

    /**
     * Verifica si hay estados disponibles para rehacer.
     *
     * @return true si se puede rehacer, false en caso contrario.
     */
    public boolean canRedo() {
        return !redoStack.isEmpty();
    }
}
