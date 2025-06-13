/*
 * (c) Midland Software Limited 2025
 * Name     : TextEditor.java
 * Author   : RoodbarakyK
 * Date     : 13 Jun 2025
 */
package Behavioural.Memento;

//Originator
public class TextEditor {
    private String text = "";

    public void type(String text) {
        this.text += text == null ? "" : text;
    }

    public String getText() {
        return text;
    }

    public TextMemento save() {
        return new TextMemento(text);
    }

    public void revert(TextMemento memento) {
        this.text = memento.getText();
    }
}
