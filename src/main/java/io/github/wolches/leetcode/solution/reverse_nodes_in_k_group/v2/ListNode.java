package io.github.wolches.leetcode.solution.reverse_nodes_in_k_group.v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    ListNode(int...vals) {
        this(vals[0], Arrays.copyOfRange(vals, 1, vals.length));
    }
    ListNode(int val, int[] next) {
        this.val = val;
        if (next.length > 0) {
            this.next = new ListNode(next);
        }
    }
    List toList() {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = this;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        return list;
    }
}