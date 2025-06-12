/*
 * (c) Midland Software Limited 2025
 * Name     : ToggleCommand.java
 * Author   : RoodbarakyK
 * Date     : 12 Jun 2025
 */
package Behavioural.Command;

public class ToggleCommand  implements Command {
    private final Light light;
    public ToggleCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.toggle();
    }
}
