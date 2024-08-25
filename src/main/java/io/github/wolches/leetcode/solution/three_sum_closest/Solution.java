package io.github.wolches.leetcode.solution.three_sum_closest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class Solution {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        Integer result = null;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (result != null) {
                    int diff = calcDiff(sum, target);
                    int oldDiff = calcDiff(result, target);
                    if (diff < oldDiff) {

                    }
                } else {
                    result = sum;
                }
            }
        }
        return result;
    }

    private int calcDiff(int sum, int target) {
        return sum > target ? sum - target : target - sum;
    }

}