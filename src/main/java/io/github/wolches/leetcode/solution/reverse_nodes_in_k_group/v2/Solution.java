package io.github.wolches.leetcode.solution.reverse_nodes_in_k_group.v2;


import java.util.Stack;

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
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode resultStart = null;
        ListNode current = head;
        ListNode currentGroupStart = head;
        ListNode lastResultGroupEnd = null;
        int i = 0;
        while (true) {
            if (current != null) {
                stack.push(current);
            } else {
                if (resultStart == null) {
                    return head;
                }
                lastResultGroupEnd.next = currentGroupStart;
                break;
            }
            if (++i == k) {
                ListNode headReversed = new ListNode();
                ListNode currentReversing = headReversed;
                while (!stack.isEmpty()) {
                    currentReversing.next = new ListNode();
                    currentReversing = currentReversing.next;
                    currentReversing.val = stack.pop().val;
                }
                if (resultStart == null) {
                    resultStart = headReversed.next;
                } else {
                    lastResultGroupEnd.next = headReversed.next;
                }
                lastResultGroupEnd = currentReversing;
                i = 0;
                currentGroupStart = current.next;
            }
            current = current.next;
        }
        return resultStart;
    }
}