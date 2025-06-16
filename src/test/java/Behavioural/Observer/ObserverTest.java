package Behavioural.Observer;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ObserverTest {

    private FileSystem fileSystem;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        fileSystem = new FileSystem();
        fileSystem.setState("testFile.txt");
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testUpdate() {
        LoggerListener loggerListener = mock(LoggerListener.class);
        fileSystem.attach(loggerListener);
        fileSystem.setState("testFile.txt");
        verify(loggerListener).update();
    }

    @Test
    void testLogger() {
        LoggerListener loggerListener = new LoggerListener(fileSystem);
        fileSystem.setState("testFile.txt");
        assertTrue(outputStream.toString().contains("[Logger]: testFile.txt"));
    }

    @Test
    void testDetach(){
        LoggerListener loggerListener = mock(LoggerListener.class);
        fileSystem.attach(loggerListener);
        fileSystem.setState("testFile.txt");
        fileSystem.detach(loggerListener);
        fileSystem.setState("testFile.txt");
        verify(loggerListener, times(1)).update();
    }
}