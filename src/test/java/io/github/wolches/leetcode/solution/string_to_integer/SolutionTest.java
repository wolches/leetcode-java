package io.github.wolches.leetcode.solution.string_to_integer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void test1() {
        String input = "2147483648";
        int expected = 2147483647;

        int actual = solution.myAtoi(input);

        assertEquals(expected, actual);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
    }

    @Test
    void test2() {
        String input = "42";
        int expected = 42;

        int actual = solution.myAtoi(input);

        assertEquals(expected, actual);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
    }

    @Test
    void test3() {
        String input = "-42";
        int expected = -42;

        int actual = solution.myAtoi(input);

        assertEquals(expected, actual);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
    }

    @Test
    void test4() {
        String input = "";
        int expected = 0;

        int actual = solution.myAtoi(input);

        assertEquals(expected, actual);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
    }

    @Test
    void test5() {
        String input = "2147483646";
        int expected = 2147483646;

        int actual = solution.myAtoi(input);

        assertEquals(expected, actual);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
    }

}