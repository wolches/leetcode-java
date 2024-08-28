package io.github.wolches.leetcode.solution.reverse_nodes_in_k_group.v1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void test1() {
        ListNode reversed = solution.reverseKGroup(new ListNode(1, 2, 3, 4, 5), 2);

        Assertions.assertArrayEquals(new Integer[] {2, 1, 4, 3, 5}, reversed.toList().toArray(), Arrays.toString(reversed.toList().toArray()));
    }

}