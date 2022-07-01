package com.faizan.leetcode.problems;

import java.util.*;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int first = binarySearch(nums, target);
        if(first<0) return new int[] {-1,-1};
        int second = first;
        while(first>0 && nums[first-1] == target) --first;
        while(second<nums.length-1 && nums[second+1] == target) ++second;
        return new int[] {first, second};
    }

    private int binarySearch(int[] nums, int target) {
        if(nums == null) return -1;
        int l = 0, r = nums.length-1, mid;
        while(l>=0 && r>=0 && l<=r) {
            mid = (r+l)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid]<target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }

}
