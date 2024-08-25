package io.github.wolches.leetcode.solution.longest_common_prefix;

class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int maxLength = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.equals("")) {
                return str;
            }
            maxLength = Math.min(maxLength, str.length());
        }
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                while (!hasSamePrefixOfLength(strs[i], strs[j], maxLength)) {
                    if (!hasSamePrefixOfLength(strs[i], strs[j], maxLength) && maxLength > 0) {
                        maxLength--;
                    } else {
                        return "";
                    }
                }
            }
        }
        return strs[0].substring(0, maxLength);
    }

    private boolean hasSamePrefixOfLength(String str1, String str2, int length) {
        return str1.substring(0, length).equals(str2.substring(0, length));
    }
}