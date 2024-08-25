package io.github.wolches.leetcode.solution.merge_sorted_lists;


public class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode start = new ListNode();
        ListNode current = start;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                current.next = list2;
                list2 = list2.next;
            } else {
                current.next = list1;
                list1 = list1.next;
            }
            if (current.next != null) {
                current = current.next;
            }
        }
        current.next = list1 != null ? list1 : list2;
        return start.next;
    }
}