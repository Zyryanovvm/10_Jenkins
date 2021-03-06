package tests.simple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Disabled tests")
public class SnippedTests {
    @Test
    @Disabled
    void test12() {
        assertTrue(false);
    }
    @Test
    void test13() {
        assertTrue(true);
    }
    @Test
    @Disabled
    void test14() {
        assertTrue(true);
    }
    @Test
    void test15() {
        assertTrue(true);
    }
    @Test
    @Disabled
    void test16() {
        assertFalse(false);

    }
}
