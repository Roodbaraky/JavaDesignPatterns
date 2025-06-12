package Behavioural.Command;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}