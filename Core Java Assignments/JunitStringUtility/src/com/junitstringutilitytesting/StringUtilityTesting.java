package com.junitstringutilitytesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.junitstringutility.StringUtility;

class StringUtilityTesting {
    private StringUtility stringUtility;

    @BeforeAll
    static void setupBeforeAll() {
        System.out.println("Before All ");
    }

    @BeforeEach
    void setupBeforeEach() {
        stringUtility = new StringUtility();
        System.out.println("Before Each Test");
    }

    @Test
    void testIsPalindrome() {
        assertTrue(stringUtility.isPalindrome("madam"));
        assertTrue(stringUtility.isPalindrome("Racecar"));
        assertFalse(stringUtility.isPalindrome("hello"));
        assertFalse(stringUtility.isPalindrome(""));
        assertFalse(stringUtility.isPalindrome(null));
        System.out.println("Palindrome Test Passed");
    }

  

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", stringUtility.toUpperCase("hello"));
        assertEquals("TESTING", stringUtility.toUpperCase("Testing"));
        assertEquals(null, stringUtility.toUpperCase(null));
        System.out.println("Upper Case Conversion Test Passed");
    }

    @AfterEach
    void teardownAfterEach() {
        System.out.println("After Each Test");
    }

    @AfterAll
    static void teardownAfterAll() {
        System.out.println("After All");
    }
}
