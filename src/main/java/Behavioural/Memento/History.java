/*
 * (c) Midland Software Limited 2025
 * Name     : History.java
 * Author   : RoodbarakyK
 * Date     : 13 Jun 2025
 */
package Behavioural.Memento;

import java.util.ArrayDeque;

//Caretaker
public class History {
    private int limit = 20;
    private final ArrayDeque<TextMemento> history = new ArrayDeque<>();

    public History(int limit) {
        this.limit = limit;
    }
    public History() {

    }
    public void save(TextMemento memento) {
        if(isFull()){
            history.removeLast();
        }
        history.push(memento);
    }

    public TextMemento restore() {
        return history.isEmpty() ? null : history.pop();
    }

    private boolean isFull(){
        return history.size() == limit;
    }

}
