package com.test.udemy.leetcode;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int left = 0;
        int right = actual.toCharArray().length-1;
        while (left<right){
            if(actual.charAt(left) != actual.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
