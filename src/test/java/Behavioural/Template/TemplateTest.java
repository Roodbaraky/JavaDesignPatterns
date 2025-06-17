package Behavioural.Template;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TemplateTest {
    private HotDrinkTemplate hotDrink;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void coffee_noCondiments() {
        hotDrink = new CoffeeImpl();
        hotDrink.prepareRecipe();
        assertTrue(outputStream.toString().contains("Boiling water"));
        assertTrue(outputStream.toString().contains("Place coffee in cafetiere..."));
        assertTrue(outputStream.toString().contains("Pour over hot water..."));
        assertTrue(outputStream.toString().contains("Sit for 5 minutes..."));
        assertTrue(outputStream.toString().contains("Plunge cafetiere..."));
        assertTrue(outputStream.toString().contains("Pouring into cup"));
        assertFalse(outputStream.toString().contains("Add coffee condiments..."));
    }

    @Test
    void coffee_condiments() {
        hotDrink = new CoffeeImpl(true);
        hotDrink.prepareRecipe();
        assertTrue(outputStream.toString().contains("Boiling water"));
        assertTrue(outputStream.toString().contains("Place coffee in cafetiere..."));
        assertTrue(outputStream.toString().contains("Pour over hot water..."));
        assertTrue(outputStream.toString().contains("Sit for 5 minutes..."));
        assertTrue(outputStream.toString().contains("Plunge cafetiere..."));
        assertTrue(outputStream.toString().contains("Pouring into cup"));
        assertTrue(outputStream.toString().contains("Add coffee condiments..."));
    }

    @Test
    void tea_noCondimentOverride() {
        hotDrink = new TeaImpl();
        hotDrink.prepareRecipe();
        assertTrue(outputStream.toString().contains("Boiling water"));
        assertTrue(outputStream.toString().contains("Put teabag in kettle..."));
        assertTrue(outputStream.toString().contains("Pour hot water into kettle..."));
        assertTrue(outputStream.toString().contains("Sit for 5 minutes..."));
        assertTrue(outputStream.toString().contains("Pouring into cup"));
        assertTrue(outputStream.toString().contains("Pour milk into cup"));
    }

}