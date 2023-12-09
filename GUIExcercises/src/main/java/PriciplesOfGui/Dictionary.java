package PriciplesOfGui;
import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> dictionary;

    public Dictionary() {
        dictionary = new HashMap<>();
    }

    public void addWord(String word, String meaning) {
        dictionary.put(word.toLowerCase(), meaning);
    }

    public String searchWord(String word) {
        String meaning = dictionary.get(word.toLowerCase());
        if (meaning == null) {
            return "Word not found in the dictionary.";
        }
        return meaning;
    }
}

