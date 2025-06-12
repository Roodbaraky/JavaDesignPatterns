package Behavioural.ChainOfResponsibility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HandlerTest {

    private Staff staff;
    private Manager manager;
    private Director director;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        staff = new Staff();
        manager = new Manager();
        director = new Director();
        staff.setNext(manager);
        manager.setNext(director);
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

    }

    @Test
    public void testStaff() {
        double amount = 99;
        Request request = new Request(amount);
        staff.handleRequest(request);
        assertEquals(amount + " is less than 100. " + "Staff can handle request", outputStream.toString().trim());
    }

    @Test
    public void testManager() {
        double amount = 101;
        Request request = new Request(amount);
        staff.handleRequest(request);
        assertEquals(amount + " is less than 1000. " + "Manager can handle request", outputStream.toString().trim());
    }

    @Test
    public void testDirector() {
        double amount = 1001;
        Request request = new Request(amount);
        staff.handleRequest(request);
        assertEquals("Director handled the request of: " + amount + "." , outputStream.toString().trim());
    }
}