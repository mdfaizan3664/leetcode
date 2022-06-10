package com.faizan.leetcode.problems;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null) return "";
        int i = strs[0].length();
        return longestCommonPrefix(strs, i, 0);
    }

    public String longestCommonPrefix(String[] strs, int i, int j) {
        if(j  == strs.length-1) return strs[0].substring(0, i);
        int n = Math.min(strs[j + 1].length(), i);
        for(int k = 0; k < n; k++) {
            if(strs[0].charAt(k) != strs[j+1].charAt(k)) {
                n = k;
                break;
            }
        }
        return longestCommonPrefix(strs, n, j+1);
    }
}
