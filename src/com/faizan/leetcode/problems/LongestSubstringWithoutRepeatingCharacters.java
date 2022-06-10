package com.faizan.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;
        Set<Character> set = new HashSet<>();
        int longestSubstring = 0;
        int x = 0;
        for(int i = 0; i < s.length(); i++) {
            if(!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            } else {
                longestSubstring = longestSubstring < set.size() ? set.size() : longestSubstring;
                set.remove(s.charAt(x++));
                --i;
            }
        }
        return longestSubstring < set.size() ? set.size() : longestSubstring;
    }
}
