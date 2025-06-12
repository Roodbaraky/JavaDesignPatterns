/*
 * (c) Midland Software Limited 2025
 * Name     : Light.java
 * Author   : RoodbarakyK
 * Date     : 12 Jun 2025
 */
package Behavioural.Command;

//receiver
public class Light {
    public boolean isOn() {
        return on;
    }

    private boolean on;

    public void toggle() {
        on = !on;
        if(on){
            on();
        }
        else{
            off();
        }
    }

    public void on() {
        if(!on){
            on = true;
        }
        System.out.println("Light on");
    }

    public void off() {
        System.out.println("Light off");
    }
}
