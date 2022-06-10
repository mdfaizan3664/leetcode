package com.faizan.leetcode.problems;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        return reverse(x) == x;

    }
    public int reverse(int x) {
        int rev = 0;
        while(x != 0) {
            int pop = x % 10;
            rev = rev * 10 + pop;
            x /= 10;
        }
        return rev;
    }
}
