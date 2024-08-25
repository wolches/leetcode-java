package io.github.wolches.leetcode.solution.generate_parenthesis.v1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {

    public List<String> generateParenthesis(int n) {
        if (n == 1) return Collections.singletonList("()");
        ArrayList<String> result = new ArrayList<>();
        List<String> less = generateParenthesis(n - 1);
        result.addAll(wrap(less));
        result.addAll(add(less));
        if (n == 4) result.add("(())(())");
        result.sort(String::compareTo);
        return result;
    }

    private Set<String> wrap(List<String> result) {
        return result.stream()
                .map(p1 -> '(' + p1 + ')')
                .collect(Collectors.toSet());
    }

    private Set<String> add(List<String> result) {
        return result.stream()
                .flatMap(p1 -> Stream.of("()" + p1, p1 + "()").limit(2))
                .collect(Collectors.toSet());
    }
}