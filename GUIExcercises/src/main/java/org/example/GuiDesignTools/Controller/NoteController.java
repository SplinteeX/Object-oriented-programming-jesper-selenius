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
    private Notebook notebook;
    @FXML
    private TextArea titleField;
    @FXML
    private TextField contentArea;

    @FXML
    private ListView<String> notesListView;

    @FXML
    private Button addButton;


    @FXML
    private void initialize() {
        addButton.setOnAction(event -> handleAddButton());
    }

    @FXML
    private void handleAddButton() {
        String title = titleField.getText();
        String content = contentArea.getText();
        System.out.println("Title: " + title + "\nContent: " + content);

        if (!title.isEmpty() && !content.isEmpty()) {
            Note newNote = new Note(title, content);
            notebook.addNote(newNote);
            updateDisplay();
        }
    }

    private void updateDisplay() {
        notesListView.getItems().clear();
        for (Note note : notebook.getNotes()) {
            notesListView.getItems().add("Title: " + note.getTitle() + "\n" + "Content: " + note.getContent() + "\n\n");
        }
    }



    @FXML
    private void deleteNote() {
        int selectedIndex = notesListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            notesListView.getItems().remove(selectedIndex);

        }
    }
    @FXML
    private void editNote() {
        int selectedIndex = notesListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            String title = titleField.getText();
            String content = contentArea.getText();

            if (!title.isEmpty() && !content.isEmpty()) {
                Note editedNote = new Note(title, content);
                notebook.editNote(selectedIndex, editedNote);
                updateDisplay();
            }
        }
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }



    public static void main(String[] args) {
        Main.launch(Main.class);
    }

}
