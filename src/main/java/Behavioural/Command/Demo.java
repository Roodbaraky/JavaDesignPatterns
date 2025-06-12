/*
 * (c) Midland Software Limited 2025
 * Name     : Demo.java
 * Author   : RoodbarakyK
 * Date     : 12 Jun 2025
 */
package Behavioural.Command;

public class Demo {

    public static void main(String[] args) {
        Light light = new Light();
        Switch lightSwitch = new Switch();
        Command onCommand = new OnCommand(light);
        Command toggleCommand = new ToggleCommand(light);

        lightSwitch.storeAndExecute(onCommand);
        lightSwitch.storeAndExecute(toggleCommand);
        lightSwitch.storeAndExecute(toggleCommand);

    }
}
