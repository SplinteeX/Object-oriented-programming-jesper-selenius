package GuiDesignTools.Controller;

import GuiDesignTools.Note;
import GuiDesignTools.Notebook;
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

    @FXML
    private void handleAddButton() {
        String title = titleField.getText();
        String content = contentArea.getText();

        if (!title.isEmpty() && !content.isEmpty()) {
            Note newNote = new Note(title, content);
            notebook.addNote(newNote);
            updateDisplay();
        }
    }

    private void updateDisplay() {
        notesTextArea.clear(); // Clear the TextArea
        for (Note note : notebook.getNotes()) {
            notesTextArea.appendText("Title: " + note.getTitle() + "\n");
            notesTextArea.appendText("Content: " + note.getContent() + "\n\n");
        }
    }
    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }
}
