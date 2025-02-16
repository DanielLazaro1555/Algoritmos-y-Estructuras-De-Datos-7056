package model;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author daniel
 */
public class Cola<T> {

    private Deque<T> cola;

    public Cola() {
        cola = new LinkedList<>();
    }

    public void enqueue(T elemento) {
        cola.addLast(elemento);
    }

    public T dequeue() {
        if (!isEmpty()) {
            return cola.removeFirst();
        }
        return null;
    }

    public T peek() {
        return cola.peekFirst();
    }

    public boolean isEmpty() {
        return cola.isEmpty();
    }

    public int size() {
        return cola.size();
    }

    public void mostrarCola() {
        System.out.println("Cola Actual: " + cola);
    }

}
