/*
 * (c) Midland Software Limited 2025
 * Name     : LoggerListener.java
 * Author   : RoodbarakyK
 * Date     : 16 Jun 2025
 */
package Behavioural.Observer;

public class LoggerListener extends Observer {

    public LoggerListener(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("[Logger]: " + subject.getState());

    }
}
