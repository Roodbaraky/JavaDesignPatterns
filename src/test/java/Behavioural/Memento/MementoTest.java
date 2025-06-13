package Behavioural.Memento;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MementoTest {

    private TextEditor textEditor;
    private History history;

    @BeforeEach
    void setUp() {
        textEditor = new TextEditor();
        history = new History(3);
    }

    @Test
    void testWriteText() {
        textEditor.type("cat");
        assertEquals("cat", textEditor.getText());
    }
    @Test
    void testWriteText_null() {
        textEditor.type(null);
        assertEquals("", textEditor.getText());
    }

    @Test
    void testSaveText() {
        textEditor.type("cat");
        history.save(textEditor.save());
        assertEquals("cat", history.restore().getText());
    }

    @Test
    void testSaveMultipleText() {
        textEditor.type("cat");
        history.save(textEditor.save());
        textEditor.type(" dog");
        history.save(textEditor.save());
        assertEquals("cat dog", history.restore().getText());
        assertEquals("cat", history.restore().getText());
    }

    @Test
    void testRevertText() {
        textEditor.type("cat");
        TextMemento test = new TextMemento("dog");
        textEditor.revert(test);
        assertEquals("dog",textEditor.getText());
    }

    @Test void testRestoreText() {
        assertNull(history.restore());
    }

    @Test
    void testFullStack(){
        textEditor.type("cat");
        history.save(textEditor.save());
        textEditor.type("dog");
        history.save(textEditor.save());
        textEditor.type("cat");
        history.save(textEditor.save());
        textEditor.type("dog");
        history.save(textEditor.save());
        assertEquals("catdogcatdog", history.restore().getText());
        assertEquals("catdogcat", history.restore().getText());
        assertEquals("catdog", history.restore().getText());
        assertNull(history.restore());
    }

}