package Behavioural.Command;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommandTest {
    private Light light;
    private Switch lightSwitch;
    private Command onCommand;
    private Command toggleCommand;

    @BeforeEach
    void setUp() {
        light = new Light();
        lightSwitch = new Switch();
        onCommand = new OnCommand(light);
        toggleCommand = new ToggleCommand(light);
    }

    @Test
    void onCommand() {
        lightSwitch.storeAndExecute(onCommand);
        assertTrue(light.isOn());
        lightSwitch.storeAndExecute(onCommand);
        assertTrue(light.isOn());
    }

    @Test
    void toggleCommand() {
        lightSwitch.storeAndExecute(toggleCommand);
        assertTrue(light.isOn());
        lightSwitch.storeAndExecute(toggleCommand);
        assertFalse(light.isOn());
    }

    @Test
    void onAndToggleCommand() {
        lightSwitch.storeAndExecute(onCommand);
        assertTrue(light.isOn());
        lightSwitch.storeAndExecute(toggleCommand);
        assertFalse(light.isOn());
    }

    @Test
    void allOffCommand() {
        Light secondLight = new Light();
        Command secondOnCommand = new OnCommand(secondLight);
        Command allOffCommand = new AllOffCommand(List.of(light, secondLight));
        lightSwitch.storeAndExecute(onCommand);
        lightSwitch.storeAndExecute(secondOnCommand);
        lightSwitch.storeAndExecute(allOffCommand);
        assertFalse(light.isOn());
        assertFalse(secondLight.isOn());
    }

    @Test
    void allOffCommand_VarArgs() {
        Light secondLight = new Light();
        Command secondOnCommand = new OnCommand(secondLight);
        Command allOffCommand = new AllOffCommand(light, secondLight);
        lightSwitch.storeAndExecute(onCommand);
        lightSwitch.storeAndExecute(secondOnCommand);
        lightSwitch.storeAndExecute(allOffCommand);
        assertFalse(light.isOn());
        assertFalse(secondLight.isOn());

    }
}