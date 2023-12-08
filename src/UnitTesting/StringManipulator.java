package UnitTesting;

public class StringManipulator {
    public String concatenate(String a, String b) {
        return a + b;
    }

    public int findLength(String str) {
        return str.length();
    }

    public String toUpperCase(String str) {
        return str.toUpperCase();
    }

    public String toLowerCase(String str) {
        return str.toLowerCase();
    }

    public boolean containsSubstring(String str, String subString) {
        return str.contains(subString);
    }
}
