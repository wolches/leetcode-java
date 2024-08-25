package io.github.wolches.leetcode.solution.zigzag_conversion;

class Solution {


    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < rows.length; i++) {
            rows[i] =  new StringBuilder();
        }
        int row = 0;
        for (int i = 0; i < s.length(); i++) {
            rows[row].append(s.charAt(i));
            row = row + (int) Math.pow(-1.0, i / (numRows - 1));
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder r : rows) {
            if (r != null) {
                res.append(r);
            }
        }
        return res.toString();
    }
}