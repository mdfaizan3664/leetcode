package com.faizan.leetcode.problems;


public class IntegerToRoman {

    public String intToRoman(int num) {
        String roman = "";
        int rev = num, ten = 1;
        while(rev != 0) {
            int pop = rev % 10;
            if(pop == 9 || pop == 4) {
                roman =  getRomanSymbol(ten) + getRomanSymbol((pop+1)*ten) + roman;
            } else if (pop >=1 && pop <= 3) {
                for(int i=0; i<pop; i++) {
                    roman = getRomanSymbol(ten) + roman;
                }
            } else if(pop >=5 && pop <= 8) {
                for(int i=0; i<pop-5; i++) {
                    roman = getRomanSymbol(ten) + roman;
                }
                roman = getRomanSymbol(5*ten) + roman;
            }
            rev /= 10;
            ten *= 10;
        }
        return roman;
    }

    public String getRomanSymbol(int num) {
        switch (num) {
            case 1:
                return "I";
            case 5:
                return "V";
            case 10:
                return "X";
            case 50:
                return "L";
            case 100:
                return "C";
            case 500:
                return "D";
            case 1000:
                return "M";
        }
        return null;
    }
}
