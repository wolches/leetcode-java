package io.github.wolches.leetcode.solution.integer_to_roman;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {

    private Map<Integer, Character> symbols;

    public Solution() {
        this.symbols = new HashMap<>();
        this.symbols.put(1, 'I');
        this.symbols.put(5, 'V');
        this.symbols.put(10, 'X');
        this.symbols.put(50, 'L');
        this.symbols.put(100, 'C');
        this.symbols.put(500, 'D');
        this.symbols.put(1000, 'M');
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
    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        AtomicInteger num2 = new AtomicInteger(num);
        symbols.entrySet().stream().sorted(
                (e1, e2) -> e2.getKey().compareTo(e1.getKey())
        ).forEach(e -> {
            int count = num2.get() / e.getKey();
            num2.set(num2.get() % e.getKey());
            for (int i = 0; i < count; i++) {
                builder.append(e.getValue());
            }
        });
        return builder.toString()
                .replaceAll("IIII", "IV")
                .replaceAll("VIV", "IX")
                .replaceAll("XXXX", "XL")
                .replaceAll("", ""); // TODO
    }

}