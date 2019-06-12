package com.test.aks.data_structure.interview_bit.strings;


/**
 * I             1
 * IV            4
 * V             5
 * IX            9
 * X             10
 * XL            40
 * L             50
 * XC            90
 * C             100
 * CD            400
 * D             500
 * CM            900
 * M             1000
 */
public class RomanToInteger {

    // This function returns value of a Roman symbol
    int value(char r) {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }

    private int getRomanToInteger(String str) {
        int res = 0;

        for (int currentIndex = 0; currentIndex < str.length(); currentIndex++) {
            int s1 = value(str.charAt(currentIndex));
            if (currentIndex + 1 < str.length()) {

                int s2 = value(str.charAt(currentIndex + 1));
                if (s1 >= s2) {
                    res = res +s1;
                } else {
                    res = res + s2 - s1;
                    currentIndex++;
                }

            } else {
                res = res + s1;
                currentIndex++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String sampleInput = "XIV";
        int result = new RomanToInteger().getRomanToInteger(sampleInput);
        System.out.println(result);
    }
}
