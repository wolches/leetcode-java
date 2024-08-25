package io.github.wolches.leetcode.solution.median_sorted_arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        for(int i = 0, j = 0; i < nums1.length || j < nums2.length;) {
            if (i == nums1.length) {
                arr[i + j] = nums2[j];
                j++;
            } else if (j == nums2.length) {
                arr[i + j] = nums1[i];
                i++;
            } else if (nums1[i] < nums2[j]) {
                arr[i + j] = nums1[i];
                i++;
            } else {
                arr[i + j] = nums2[j];
                j++;
            }
        }
        if (arr.length == 0) {
            return 0.0;
        }
        if (arr.length == 1) {
            return (double) arr[0];
        }
        if (arr.length % 2 == 0) {
            int median = arr.length / 2; // 6 - 3, 4 - 2
            return (arr[median] + arr[median - 1]) / 2.0;
        } else {
            return arr[arr.length / 2]; // 5 - 2, 3 - 1
        }
    }
}