package io.github.wolches.leetcode.solution.longest_common_prefix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void test1() {
        String[] input = {"flower","flow","flight"};
        String expected = "fl";

        String actual = solution.longestCommonPrefix(input);

        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        String[] input = {"dog","racecar","car"};
        String expected = "";

        String actual = solution.longestCommonPrefix(input);

        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        String[] input = {"cir","car"};
        String expected = "c";

        String actual = solution.longestCommonPrefix(input);

        assertEquals(expected, actual);
    }

}