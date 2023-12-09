package org.example.PriciplesOfGui.Controller;

import org.example.PriciplesOfGui.Model.Dictionary;

public class DictionaryController {
    private Dictionary dictionary;

    public DictionaryController(Dictionary dictionary) {
        this.dictionary = dictionary;
        dictionary.addWord("Apple", "A fruit that grows on trees.");
        dictionary.addWord("Banana", "An yellow fruit that grows on trees.");
        dictionary.addWord("Cat", "A pet that likes to eat fish.");

    }
    public String searchWord(String word) {
        try {
            return dictionary.searchWord(word);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
