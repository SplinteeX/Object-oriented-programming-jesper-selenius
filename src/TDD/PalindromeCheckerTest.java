package TDD;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromeCheckerTest {
    @Test
    public void CheckPalindromeWithPalindrome() {
        PalindromeChecker checker = new PalindromeChecker();
        assertTrue(checker.isPalindrome("madam"));
        assertTrue(checker.isPalindrome("A man, a plan, a canal, Panama"));
    }

    @Test
    public void CheckPalindromeWithNonPalindrome() {
        PalindromeChecker checker = new PalindromeChecker();
        assertFalse(checker.isPalindrome("abc"));
        assertFalse(checker.isPalindrome("test"));

    }
}
