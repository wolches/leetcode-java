package io.github.wolches.leetcode.solution.closest_palindrome;


public class Solution {

    public String nearestPalindromic(String n) {
        long value = Long.parseLong(n);
        if (value == 0) return "1";
        if (value == 11) return "9";
        if (value <= 10) return String.valueOf(value - 1);
        if (n.replaceAll("9+", "").isEmpty()) return String.valueOf(value + 2);
        if (n.replaceAll("10+1", "").isEmpty()) return String.valueOf(value - 2);
        if (n.replaceAll("10+", "").isEmpty()) return String.valueOf(value - 1);

        long edge_999 = (long) Math.pow(10, n.length() - 1) - 1;
        long edge_101 = (long) Math.pow(10, n.length() - 1) + 1;

        boolean isEvenDigits = n.length() % 2 == 0;
        String left = n.substring(0, n.length() / 2 + 1);

        long unchanged = getPalindrome(left, isEvenDigits, 0);
        long incremented = getPalindrome(left, isEvenDigits, 1);
        long decremented = getPalindrome(left, isEvenDigits, -1);

        return String.valueOf(findWithMinDiff(value, edge_101, edge_999, unchanged, incremented, decremented));
    }

    private long getPalindrome(String left, boolean isEvenDigits, int change) {
        long changedLeft = Long.parseLong(isEvenDigits ? left.substring(0, left.length() - 1) : left) + change;
        String changedLeftStr = String.valueOf(changedLeft);
        String right = reverse(changedLeftStr.substring(0, left.length() == changedLeftStr.length() ? left.length() - 1 : changedLeftStr.length()));
        return Long.parseLong(changedLeft + right);
    }

    private String reverse(String str) {
        char[] charArray = str.toCharArray();
        char[] newCharArray = new char[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            newCharArray[newCharArray.length - 1 - i] = charArray[i];
        }
        return String.copyValueOf(newCharArray);
    }

    private long findWithMinDiff(long value, long...results) {
        Long min = null;
        for (long result : results) {
            if (result == value) continue;
            if (min == null) {
                min = result;
            } else {
                long diff = Math.abs(value - result);
                long minDiff = Math.abs(value - min);
                if (diff < minDiff || (diff == minDiff && result < min)) {
                    min = result;
                }
            }
        }
        return min;
    }
}