/*
 * (c) Midland Software Limited 2025
 * Name     : Demo.java
 * Author   : RoodbarakyK
 * Date     : 12 Jun 2025
 */
package Behavioural.Command;

import java.util.List;

public class Demo {

    public static void main(String[] args) {
        Light light = new Light();
        Light light2 = new Light();
        Switch lightSwitch = new Switch();
        Command onCommand = new OnCommand(light);
        Command onCommand2 = new OnCommand(light2);
        Command toggleCommand = new ToggleCommand(light);
        Command allOffCommand = new AllOffCommand(List.of(light, light2));


        lightSwitch.storeAndExecute(onCommand);
        lightSwitch.storeAndExecute(toggleCommand);
        lightSwitch.storeAndExecute(toggleCommand);
        lightSwitch.storeAndExecute(onCommand2);

        lightSwitch.storeAndExecute(allOffCommand);
    }
}
