package org.example.GuiDesignTools.Model;

import org.example.GuiDesignTools.Model.Note;

import java.util.ArrayList;
import java.util.List;

public class Notebook {
    private List<Note> notes;

    public Notebook() {
        notes = new ArrayList<>();
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void editNote(int index, Note editedNote) {
        if (index >= 0 && index < notes.size()) {
            notes.set(index, editedNote);
        }
    }
}
