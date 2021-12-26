package com.test.udemy.leetcode;

/**
 * Longest Palindrome substring - Leetcode
 * https://leetcode.com/problems/longest-palindromic-substring/
 * Explanation - https://iq.opengenus.org/longest-palindromic-substring-dp/
 *
 * Cases -
 * 1> for single char - i==j
 * 2> for two char - j-i==1
 * 3> for more than two char - j-i>=2
 */
public class LongestPalindrome {

    private int lo, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            System.out.println("s.charAt(j="+j+") = "+s.charAt(j));
            System.out.println("s.charAt(k="+k+") = "+s.charAt(k));
            //
            j--;
            k++;
        }
        System.out.println("break");
        //handling extra increment for k index when while became false
        //And handing extra j decrement while when became false
        //that's why extra minus from k and extra addition into j;
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
            System.out.println("j="+j);
            System.out.println("lo="+lo);
            System.out.println("maxLen="+maxLen);
        }
    }
}
