package io.github.wolches.leetcode.solution.longest_palindromic_substring.v2;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution implements io.github.wolches.leetcode.solution.longest_palindromic_substring.Solution {

    @Override
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String result = "";
        for (int i = 0; i < s.length() - 1; i++) {
            String palindromeOdd = longestPalindromeWithCenterAt(s, i, true);
            String palindromeEven = longestPalindromeWithCenterAt(s, i, false);
            if (palindromeOdd.length() > result.length()) {
                result = palindromeOdd;
            }
            if (palindromeEven.length() > result.length()) {
                result = palindromeEven;
            }
        }
        return result;
    }

    private String longestPalindromeWithCenterAt(String s, int position, boolean odd) {
        int left = position;
        int right = odd ? position : position + 1;
        while (
                left >= 0 
                && right < s.length()
                && s.charAt(left) == s.charAt(right)
        ) {
            left--;
            right++;
        }
        return s.substring(left, right);
    }
}