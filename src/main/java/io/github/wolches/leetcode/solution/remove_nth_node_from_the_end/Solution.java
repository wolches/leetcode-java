package io.github.wolches.leetcode.solution.remove_nth_node_from_the_end;


import java.util.Stack;

class Solution {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        if (head.next == null) return null;
        Stack<ListNode> nodes = new Stack<>();
        ListNode current = head;
        nodes.push(current);
        while (current.next != null) {
            nodes.push(current.next);
            current = current.next;
        }
        for (int i = 0; i < n - 1; i++) {
            nodes.pop();
        }
        ListNode pop = nodes.pop();
        if (!nodes.isEmpty()) {
            ListNode peek = nodes.peek();
            peek.next = pop.next;
        } else {
            return pop.next;
        }

        return head;
    }
}