package io.github.wolches.leetcode.solution.roman_to_integer;

class Solution {

    public int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int result = convertDigit(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int lastValue = convertDigit(s.charAt(i - 1));
            int currentValue = convertDigit(s.charAt(i));
            result = result
                    + (
                            lastValue < currentValue
                                    ? currentValue - (2 * lastValue)
                                    : currentValue
            );
        }
        return result;
    }

    /**
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     */
    private int convertDigit(char c) {
        if (c == 'I') return 1;
        if (c == 'V') return 5;
        if (c == 'X') return 10;
        if (c == 'L') return 50;
        if (c == 'C') return 100;
        if (c == 'D') return 500;
        if (c == 'M') return 1000;
        return 0;
    }
}