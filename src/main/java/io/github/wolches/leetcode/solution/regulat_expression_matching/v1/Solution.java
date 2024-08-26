package io.github.wolches.leetcode.solution.regulat_expression_matching.v1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Passes 293/356 tests
 */
public class Solution {

    public boolean isMatch(String s, String p) {
        int pos = 0;
        Iterator<Token> iterator = toTokens(p).iterator();
        Token token = iterator.next();
        while (pos < s.length()) {
            char c = s.charAt(pos);
            if (token.matches(c)) {
                pos++;
                if (!token.isInfinite) {
                    if (iterator.hasNext()) {
                        token = iterator.next();
                    }
                }
            } else {
                if (!token.matched && !token.isInfinite) {
                    return false;
                } else {
                    if (iterator.hasNext()) {
                        token = iterator.next();
                    } else {
                        return false;
                    }
                }
            }
        }
        return !iterator.hasNext() && token.matched;
    }

    private List<Token> toTokens(String regex) {
        ArrayList<Token> tokens = new ArrayList<>();
        for (int i = 0; i < regex.length(); i++) {
            Token next = new Token();
            next.character = regex.charAt(i);
            if (i + 1 < regex.length() && regex.charAt(i + 1) == '*') {
                i++;
                next.isInfinite = true;
            }
            tokens.add(next);
        }
        for (int i = 0; i < tokens.size() - 1; i++) { // Case "N*N"
            if (tokens.get(i).isInfinite && tokens.get(i + 1).character == tokens.get(i).character) {
                Token iData = tokens.get(i);
                tokens.set(i, tokens.get(i + 1));
                tokens.set(i + 1, iData);
            }
        }
        return tokens;
    }

    static class Token {
        char character;
        boolean isInfinite; // *
        boolean matched;

        private boolean matches(char c) {
            this.matched = (c == character || character == '.') && (!matched || isInfinite);
            return matched;
        }
    }
}