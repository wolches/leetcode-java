package io.github.wolches.leetcode.solution.longest_substring;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> chars;
        for (int i = 0; i < s.length(); i++) {
            chars = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (chars.contains(c)) {
                    break;
                }
                chars.add(c);
            }
            max = Math.max(max, chars.size());
        }
        return max;
    }
}