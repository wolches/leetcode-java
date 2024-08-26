package io.github.wolches.leetcode.solution.regulat_expression_matching.v2;

/**
 *
 */
public class Solution {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        char[] string = s.toCharArray();
        char[] pattern = p.toCharArray();
        boolean[][] map = new boolean[string.length + 1][pattern.length + 1];
        map[0][0] = true;
        for (int i = 0; i < pattern.length; i++) {
            if (pattern[i] == '*' && map[0][i - 1]) {
                map[0][i + 1] = true;
            }
        }
        for (int i = 0 ; i < string.length; i++) {
            for (int j = 0; j < pattern.length; j++) {
                if (pattern[j] == '.') {
                    map[i + 1][j + 1] = map[i][j];
                } else if (pattern[j] == string[i]) {
                    map[i + 1][j + 1] = map[i][j];
                } else if (pattern[j] == '*') {
                    if (pattern[j - 1] != '.' && pattern[j - 1] != string[i]) {
                        map[i + 1][j + 1] = map[i + 1][j - 1];
                    } else {
                        map[i + 1][j + 1] = map[i + 1][j] ||
                                            map[i][j + 1] ||
                                            map[i + 1][j - 1];
                    }
                }
                //for (boolean[] row : map) {
                //    for (boolean cell : row) {
                //        System.out.print(cell ? 1 : 0);
                //    }
                //    System.out.print("\r\n");
                //}
                //System.out.print("===\r\n");
            }
        }
        return map[string.length][pattern.length];
    }
}