package io.github.wolches.leetcode.solution.zigzag_conversion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1() {
        String in = "PAYPALISHIRING";
        int num = 3;

        String expected = "PAHNAPLSIIGYIR";

        String actual = solution.convert(in, num);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test2() {
        String in = "PAYPALISHIRING";
        int num = 4;

        String expected = "PINALSIGYAHRPI";

        String actual = solution.convert(in, num);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test3() {
        String in = "A";
        int num = 1;

        String expected = "A";

        String actual = solution.convert(in, num);

        Assertions.assertEquals(expected, actual);
    }

}