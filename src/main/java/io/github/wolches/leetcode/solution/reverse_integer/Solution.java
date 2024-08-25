package io.github.wolches.leetcode.solution.reverse_integer;

class Solution {
    public int reverse(int x) {
        boolean positive = x > 0;
        x = Math.abs(x);
        int y = 0;

        while (x > 0) {
            int d = x % 10;
            if (y > (Integer.MAX_VALUE - d) / 10) return 0;
            y = y * 10 + d;
            x = x / 10;
        }

        return positive ? y : -y;
    }
}