package UnitTesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringManipulatorTest {
    @Test
    void TestConcatenate() {
        StringManipulator sm = new StringManipulator();
        assertEquals("HelloWorld", sm.concatenate("Hello", "World"));
    }

    @Test
    void TestFindLength() {
        StringManipulator sm = new StringManipulator();
        assertEquals(5, sm.findLength("Hello"));
    }

    @Test
    void TestConvertToUpperCase() {
        StringManipulator sm = new StringManipulator();
        assertEquals("HELLO", sm.toUpperCase("hello"));
    }

    @Test
    void TestConvertToLowerCase() {
        StringManipulator sm = new StringManipulator();
        assertEquals("hello", sm.toLowerCase("HELLO"));
    }

    @Test
    void testContainsSubstring() {
        StringManipulator sm = new StringManipulator();
        assertTrue(sm.containsSubstring("Hello World", "World"));
        assertFalse(sm.containsSubstring("Hello World", "Goodbye"));
    }
}
