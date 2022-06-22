package com.faizan.leetcode.problems;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        findKthLargest(new int[]{3,2,1,5,6,4}, 2);
    }
    public static int findKthLargest(int[] nums, int k) {
        if(k> nums.length) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<nums.length; ++i) {
            if(i>=k) {
                if(pq.peek() >= nums[i]) continue;
                pq.poll();
            }
            pq.add(nums[i]);
        }
        return pq.peek();
    }
}
