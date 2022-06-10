package com.faizan.leetcode.problems;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array = mergeTwoSortedArray(nums1, nums2);
        int n = nums1.length + nums2.length;
        if (n%2 == 0) {
            return (array[n/2] + array[n/2-1])/2.0;
        }
        return array[n/2];
    }
    private int[] mergeTwoSortedArray(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int[] array = new int[n];
        int i = 0, j = 0;
        for (int k=0; k<n; k++) {
            int a = i<nums1.length ? nums1[i] : Integer.MAX_VALUE;
            int b = j<nums2.length ? nums2[j] : Integer.MAX_VALUE;
            if (a<b) {
                array[k] = a;
                i++;
            } else {
                array[k] = b;
                j++;
            }
        }
        return array;
    }
}
