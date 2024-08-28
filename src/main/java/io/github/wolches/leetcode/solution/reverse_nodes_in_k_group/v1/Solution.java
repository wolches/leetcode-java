package io.github.wolches.leetcode.solution.reverse_nodes_in_k_group.v1;

import java.util.ArrayList;
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
        ArrayList<ListNode> reversed = new ArrayList<>();
        ListNode current = head;
        ListNode currentStart = head;
        int i = 0;
        while (true) {
            if (current != null) {
                stack.push(current);
            } else {
                reversed.add(currentStart);
                break;
            }
            if (++i == k) {
                ListNode headReversed = reverseFromStack(stack);
                reversed.add(headReversed);
                i = 0;
                currentStart = current.next;
            }
            current = current.next;
        }
        return reversed.stream().reduce((a, b) -> {
            getLast(a).next = b;
            return a;
        }).orElse(null);
    }

    private ListNode reverseFromStack(Stack<ListNode> stack) {
        ListNode head = new ListNode();
        ListNode current = head;
        while (!stack.isEmpty()) {
            current.next = new ListNode();
            current = current.next;
            current.val = stack.pop().val;
        }
        return head.next;
    }

    private ListNode getLast(ListNode from) {
        while (from.next != null) {
            from = from.next;
        }
        return from;
    }
}