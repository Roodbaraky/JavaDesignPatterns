/*
 * (c) Midland Software Limited 2025
 * Name     : History.java
 * Author   : RoodbarakyK
 * Date     : 13 Jun 2025
 */
package Behavioural.Memento;

import java.util.Stack;

//Caretaker
public class History {
    private final Stack<TextMemento> history = new Stack<>();

    public void save(TextMemento memento) {
        history.push(memento);
    }

    public TextMemento restore() {
        return history.isEmpty() ? null : history.pop();
    }
}
