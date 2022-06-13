package com.faizan.leetcode.problems;

import java.util.Arrays;
import java.util.Collections;

public class TwoSum {
    public  int[] twoSum(int[] nums, int target) {
        int[] array = nums.clone();
        Arrays.sort(array);
        for(int i=0; i<array.length-1; i++) {
            int j = Arrays.binarySearch(array, target - array[i]);
            if(j>=0) return getIndex(nums, array[i], array[j]);
        }
        return new int[2];
    }

    private int[] getIndex(int[] nums, int first, int second) {
        int[] result = new int[]{-1, -1};
        for(int i = 0; i<nums.length; i++) {
            if(result[0] != -1 && result[1] != -1) return result;
            if(result[0] == -1 && nums[i] == first) {
                result[0] = i;
                continue;
            }

            if(result[1] == -1 && nums[i] == second) result[1] = i;
        }
        return result;
    }
}
