package io.github.wolches.leetcode.solution.add_two_numbers;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int add) {
        // End check
        if (l1 == null && l2 == null) {
            return add == 0 ? null : new ListNode(add);
        }
        // Short numbers
        if (l1 == null) {
            l1 = new ListNode(0);
        }
        if (l2 == null) {
            l2 = new ListNode(0);
        }
        int curVal = l1.val + l2.val + add;
        int newAdd = 0;
        // Overflow scenario
        if (curVal > 9) {
            newAdd = curVal / 10;
            curVal -= 10;
        }
        // Next
        return new ListNode(curVal, addTwoNumbers(l1.next, l2.next, newAdd));
    }
}