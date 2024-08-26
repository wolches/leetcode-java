package io.github.wolches.leetcode.solution.regulat_expression_matching.v2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void test1() {
        boolean match = solution.isMatch("aa", "a*");

        Assertions.assertTrue(match);
    }

    @Test
    void test2() {
        boolean match = solution.isMatch("aab", "c*a*b");

        Assertions.assertTrue(match);
    }

    @Test
    void test3() {
        boolean match = solution.isMatch("aaa", "ab*a*c*a");

        Assertions.assertTrue(match);
    }

}