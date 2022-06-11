package com.faizan.leetcode.problems;

public class ImplementStrstr {
    public int strStr(String haystack, String needle) {
        if(haystack.length()<needle.length()) return -1;
        return strStr(haystack, needle, 0);
    }
    private int strStr(String haystack, String needle, int i) {
        if (i>haystack.length()) return -1;
        for(int j = 0; j<needle.length(); j++) {
            if((i+j)>=haystack.length() || haystack.charAt(i+j) != needle.charAt(j)) {
                return strStr(haystack, needle, i+1);
            }
        }
        return i;
    }
}
