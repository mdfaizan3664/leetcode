package com.faizan.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    final String[] order = new String[]{"","","abc","def","ghi", "jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        String key = order[Integer.parseInt(""+digits.charAt(0))];
        List<String> result = Arrays.asList(key.split(""));
        return letterCombinations(digits, 1, result);
    }
    private List<String> letterCombinations(String digits, int i, List<String> result) {
        if(i>=digits.length()) return result;
        List<String> key = Arrays.asList(order[Integer.parseInt(""+digits.charAt(i))].split(""));
        return letterCombinations(digits, i+1, getAllCombination(result, key));
    }

    private List<String> getAllCombination(List<String> first, List<String> second) {
        List<String> result = new ArrayList<>(first.size()*second.size());
        for(String f: first) {
            for (String s: second) {
                result.add(f+s);
            }
        }
        return result;
    }
}
