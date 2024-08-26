package io.github.wolches.leetcode.solution.merge_k_sorted_lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode start = new ListNode();
        ListNode current = start;
        int firstNonNull = findFirstNonNull(lists);
        while (firstNonNull != -1) {
            int min = findMin(lists, firstNonNull);
            current.next = lists[min];
            lists[min] = lists[min].next;
            current = current.next;
            firstNonNull = findFirstNonNull(lists);
        }
        return start.next;
    }

    private int findMin(ListNode[] lists, int firstNonNull) {
        int minIndex = firstNonNull;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[minIndex].val > lists[i].val) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public int findFirstNonNull(ListNode[] lists) {
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                return i;
            }
        }
        return -1;
    }
}