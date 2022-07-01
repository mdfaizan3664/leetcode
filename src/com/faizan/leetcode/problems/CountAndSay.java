package com.faizan.leetcode.problems;

public class CountAndSay {
    public String countAndSay(int n) {
        if(n == 0) return "";
        if(n == 1) return "1";
        String x = countAndSay(n-1);
        return countAndSay(x);
    }

    private String countAndSay(String x) {
        StringBuilder str = new StringBuilder();
        int count = 0;
        for(int i = 0; i<x.length(); i++) {
            count++;
            if(i == (x.length() - 1) || x.charAt(i) != x.charAt(i+1)){
                str.append(count).append(x.charAt(i));
                count = 0;
            }
        }
        return str.toString();
    }
}
