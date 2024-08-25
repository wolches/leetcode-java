package io.github.wolches.leetcode.solution.container_with_most_water;

class Solution {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int curHeight = height[left] > height[right] ? height[right] : height[left];
            maxArea = Math.max(maxArea, curHeight * (right - left));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return maxArea;
    }
}