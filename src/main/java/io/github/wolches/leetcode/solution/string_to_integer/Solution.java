package io.github.wolches.leetcode.solution.string_to_integer;

class Solution {
    public int myAtoi(String s) {
        if (s == null) {
            return 0;
        }
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        boolean positive = true;
        int i = 0;
        int result = 0;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            positive = s.charAt(i) == '+';
            i++;
        }
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (c > '/' && c < ':') {
                int digit = (c - '0');
                if (positive && (Integer.MAX_VALUE - digit) / 10 < result) {
                    return Integer.MAX_VALUE;
                } else if (!positive && (Integer.MIN_VALUE + digit) / 10 > -result) {
                    return Integer.MIN_VALUE;
                }
                result = (result * 10) +  digit;
            } else {
                break;
            }
        }
        return positive ? result : -result;
    }
}