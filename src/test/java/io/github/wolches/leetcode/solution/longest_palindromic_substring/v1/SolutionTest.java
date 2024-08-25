package io.github.wolches.leetcode.solution.longest_palindromic_substring.v1;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1() {
        String expected = "bb";
        String actual = solution.longestPalindrome("cbbd");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test2() {
        String expected = "bab";
        String actual = solution.longestPalindrome("babad");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test3() {
        String expected = "a";
        String actual = solution.longestPalindrome("a");

        Assertions.assertEquals(expected, actual);
    }
}