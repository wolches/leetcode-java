package io.github.wolches.leetcode.solution.first_missing_positive;

import java.util.Arrays;

class Solution {

    public int firstMissingPositive(int[] nums) {
        if (nums.length == 1) {
            return nums[0] != 1 ? 1 : 2;
        }

        Arrays.sort(nums);
        Integer first = null;
        Integer ans = null;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0) {
                if (first == null) {
                    first = nums[i];
                }
                if (nums[i + 1] > (nums[i] + 1)) {
                    ans = nums[i] + 1;
                    break;
                }
            } else if (nums[i + 1] > 0 && first == null) {
                first = nums[i + 1];
            }
        }

        if (first == null || first > 1) {
            return 1;
        } else if (ans == null) {
            return nums[nums.length - 1] + 1;
        } else {
            return ans;
        }
    }
}