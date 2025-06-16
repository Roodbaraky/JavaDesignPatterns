/*
 * (c) Midland Software Limited 2025
 * Name     : FileSystem.java
 * Author   : RoodbarakyK
 * Date     : 16 Jun 2025
 */
package Behavioural.Observer;

import java.util.ArrayDeque;
import java.util.Deque;

//Subject
public class FileSystem extends Subject {

    private final Deque<String> files = new ArrayDeque<>();

    @Override
    public void setState(final String state) {
        files.add(state);
        this.notifyObservers();

    }

    @Override
    public String getState() {
        return files.getLast();

    }
}
