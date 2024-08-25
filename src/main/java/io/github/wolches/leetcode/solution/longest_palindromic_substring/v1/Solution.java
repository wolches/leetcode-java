package io.github.wolches.leetcode.solution.longest_palindromic_substring.v1;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution implements io.github.wolches.leetcode.solution.longest_palindromic_substring.Solution {

    @Override
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String subString = s.substring(i, j + 1);
                if (isPalyndrome(subString)) {
                    if (subString.length() > result.length()) {
                        result = subString;
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalyndrome(String s) {
        if (s.length() == 0 || s.length() == 1) return true;
        if (s.length() == 2) {
            return s.charAt(0) == s.charAt(1);
        }
        Deque<Character> deque = new ArrayDeque<>();
        s.chars().forEach(c -> deque.add((char) c));
        while (!deque.isEmpty()) {
            if (deque.size() == 1) break;
            Character c1 = deque.removeFirst();
            Character c2 = deque.removeLast();
            if (!c1.equals(c2)) return false;
        }
        return true;
    }
}