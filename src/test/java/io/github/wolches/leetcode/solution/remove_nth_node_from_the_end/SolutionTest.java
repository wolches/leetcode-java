package io.github.wolches.leetcode.solution.remove_nth_node_from_the_end;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1() {
        ListNode listNode = new ListNode(1, 2, 3, 4, 5);

        ListNode res = solution.removeNthFromEnd(listNode, 2);

        Assertions.assertArrayEquals(new Integer[] {1,2,3,5}, res.toList().toArray(new Integer[4]));
    }

    @Test
    void test2() {
        ListNode listNode = new ListNode(1);

        ListNode res = solution.removeNthFromEnd(listNode, 1);

        Assertions.assertNull(res);
    }

    @Test
    void test3() {
        ListNode listNode = new ListNode(1, 2);

        ListNode res = solution.removeNthFromEnd(listNode, 2);

        Assertions.assertArrayEquals(new Integer[] {2}, res.toList().toArray(new Integer[1]));
    }
}