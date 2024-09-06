package io.github.wolches.leetcode.solution.first_missing_positive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void test() {
        int[] nums = {1, 0};

        int res = solution.firstMissingPositive(nums);

        assertEquals(2, res);
    }

}