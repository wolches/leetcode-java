package io.github.wolches.leetcode.solution.substring_with_concatenation_of_all_words;

import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public List<Integer> findSubstring(String string, String[] words) {
        int wordLength = words[0].length();
        List<Integer> result = new ArrayList<>();

        Map<String, Integer> wordsCount = new HashMap<>();
        for (String word : words) {
            wordsCount.put(word, wordsCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            HashMap<String, Integer> window = new HashMap<>();
            for (int current = i, start = i, l = 1; current + wordLength < string.length(); current += wordLength, l++) {
                String word = string.substring(current, current + wordLength);
                window.put(word, window.getOrDefault(word, 0) + 1);

                if(l == words.length){
                    if(wordsCount.equals(window)){
                        result.add(start);
                    }
                    String remove = string.substring(start, start + wordLength);
                    window.computeIfPresent(remove, (a, b) -> (b > 1) ? b - 1 : null);
                    l--;
                    start = start + wordLength;
                }
            }
        }
        return result;
    }

    /**
     * For different string length
     */
    @Deprecated
    private Integer[][] findEveryWordSubstring(String s, String[] words) {
        List<Integer>[] result = new List[words.length];
        for (int i = 0; i < words.length; i++) {
            String temp = new String(s);
            result[i] = new ArrayList();
            while (temp.contains(words[i])) {
                result[i].add(s.indexOf(words[i]));
                result[i].add(s.indexOf(words[i]) + words[i].length());
                temp.replaceFirst(words[i], "");
            }
        }
        return Arrays.stream(result)
                .map(list -> (Integer[]) list.toArray(new Integer[list.size()]))
                .collect(Collectors.toList())
                .toArray(new Integer[result.length][]);
    }
}