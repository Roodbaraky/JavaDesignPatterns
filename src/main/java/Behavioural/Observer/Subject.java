/*
 * (c) Midland Software Limited 2025
 * Name     : Subject.java
 * Author   : RoodbarakyK
 * Date     : 16 Jun 2025
 */
package Behavioural.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    private final List<Observer> observers = new ArrayList<>();

    public abstract void setState(String state);

    public abstract String getState();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

}
