package model;

import java.util.Stack;

/**
 *
 * @author daniel
 */
public class Pila<T> {

    private Stack<T> stack;

    public Pila() {
        this.stack = new Stack<>();
    }

    public void push(T elemento) {
        stack.push(elemento);
    }

    public T pop() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.pop();
    }

    public T peek() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    @Override
    public String toString() {
        return "Pila: " + stack.toString();
    }
}
