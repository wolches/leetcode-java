package io.github.wolches.leetcode.solution.valid_parentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> opening = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                opening.push(c);
            } else {
                if (opening.isEmpty()) {
                    return false;
                }
                char closing = opening.pop();
                if (c == ')' && !(closing == '(')) {
                    return false;
                }
                if (c == ']' && !(closing =='[')) {
                    return false;
                }
                if (c == '}' && !(closing =='{')) {
                    return false;
                }
            }
        }
        return opening.isEmpty();
    }
}