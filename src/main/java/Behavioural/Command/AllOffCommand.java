/*
 * (c) Midland Software Limited 2025
 * Name     : AllOffCommand.java
 * Author   : RoodbarakyK
 * Date     : 12 Jun 2025
 */
package Behavioural.Command;

import java.util.List;

public class AllOffCommand implements Command {

    private final List<Light> lights;

    public AllOffCommand(List<Light> lights) {
        this.lights = lights;
    }

    public AllOffCommand(Light... lights) {
        this.lights = List.of(lights);
    }

    @Override
    public void execute() {
        lights.stream()
                .filter(Light::isOn)
                .forEach(Light::toggle);

    }
}
