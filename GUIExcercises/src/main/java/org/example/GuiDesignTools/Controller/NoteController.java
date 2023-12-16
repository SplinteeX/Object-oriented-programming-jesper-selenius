package org.example.GuiDesignTools.Controller;

import org.example.GuiDesignTools.Main;
import org.example.GuiDesignTools.Model.Note;
import org.example.GuiDesignTools.Model.Notebook;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NoteController {
    @FXML
    private TextField titleField;

    @FXML
    private TextArea contentArea;

    @FXML
    private Button addButton;

    @FXML
    private TextArea notesTextArea;

    @FXML
    private ListView<String> notesList;

    private Notebook notebook;

    // Method to set the notebook
    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    // Method to handle adding notes
    @FXML
    private void handleAddButton() {
        String title = titleField.getText();
        String content = contentArea.getText();

        if (!title.isEmpty() && !content.isEmpty() && notebook != null) {
            Note newNote = new Note(title, content);
            notebook.addNote(newNote);
            updateDisplay();
        }
    }

    // Method to update the display
    private void updateDisplay() {
        notesTextArea.clear(); // Clear the TextArea
        if (notebook != null) {
            for (Note note : notebook.getNotes()) {
                notesTextArea.appendText("Title: " + note.getTitle() + "\n");
                notesTextArea.appendText("Content: " + note.getContent() + "\n\n");
            }
        }
    }

    public static void main(String[] args) {
        Main.launch(Main.class);
    }
}
