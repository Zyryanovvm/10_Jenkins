package tests.simple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertTrue(false);
    }
    @Test
    void test15() {
        assertTrue(false);
    }
    @Test
    @Disabled
    void test16() {
        assertTrue(false);
    }
}
