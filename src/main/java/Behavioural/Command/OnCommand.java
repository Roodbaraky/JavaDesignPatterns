/*
 * (c) Midland Software Limited 2025
 * Name     : OnCommand.java
 * Author   : RoodbarakyK
 * Date     : 12 Jun 2025
 */
package Behavioural.Command;

public class OnCommand implements Command {

    private final Light light;


    public OnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
