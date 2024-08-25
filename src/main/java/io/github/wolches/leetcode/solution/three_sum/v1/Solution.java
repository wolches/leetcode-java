package io.github.wolches.leetcode.solution.three_sum.v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return Collections.emptyList();
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int numI = nums[i];
                    int numJ = nums[j];
                    int numK = nums[k];
                    if (numI + numJ + numK == 0) {
                        result.add(Arrays.asList(numI, numJ, numK));
                    }
                }
            }
        }
        filterDuplicates(result);
        return result;
    }

    private void filterDuplicates(List<List<Integer>> source) {
        for (int i = 0; i < source.size(); i++) {
            for (int j = i + 1; j < source.size(); j++) {
                if (equals(source.get(i), source.get(j))) {
                    source.remove(j);
                    j--;
                }
            }
        }
    }

    private boolean equals(List<Integer> a, List<Integer> b) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) != b.get(i)) {
                return false;
            }
        }
        return true;
    }

}