package io.github.wolches.leetcode.solution.merge_sorted_lists;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void test1() {
        ListNode list1 =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(4)));
        ListNode list2 =
                new ListNode(1,
                        new ListNode(3,
                                new ListNode(4)));

        ListNode result = solution.mergeTwoLists(list1, list2);

        assertArrayEquals(new Integer[] {1, 1, 2, 3, 4, 4}, result.toList().toArray(new Integer[6]));
    }

}