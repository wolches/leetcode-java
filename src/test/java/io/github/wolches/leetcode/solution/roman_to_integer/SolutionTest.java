package io.github.wolches.leetcode.solution.roman_to_integer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void test1() {
        String input = "III";
        int expected = 3;

        int actual = solution.romanToInt(input);

        assertEquals(expected, actual);
    }
}