package com.test.udemy.arrays;

import java.util.*;


/**
 * Longest sub string without repeating characters
 * link - https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * Approach -
 * 1. keep on adding to set
 * 2. check for repeating chars
 * 3. if repeating, store the existing chars from set to a older string and make set empty
 * - check an add on condition - if the set chars length is greater than olderString length then only replace/add
 * 4. add new char to set now, and continue iterating
 * 5. repeat the steps
 */
public class LongestSubString {

    private int longestSubString(String str) {
        if (str == null) return 0;
        if (str.length() == 1) return 1;
        //
        char[] charArr = str.toCharArray();
        Set<Character> charSet = new HashSet<>();
        Set<Character> oldercharSet = new HashSet<>();
        int longestStrSize = 0;
        String longestString = "";
        //
        //"abcabcbb"
        //"pwwkew"
        //"dvdf"
        for (char item : charArr) {
            if (!charSet.contains(item)) {
                System.out.println("if - char : " + item);
                charSet.add(item);
            } else {
                System.out.println("else - char : " + item);
                System.out.println("oldercharSet : " + oldercharSet.toString());
                System.out.println("charSet : " + charSet.toString());
                //
                System.out.println("oldercharSet-size : " + oldercharSet.size());
                System.out.println("charSet-size : " + charSet.size());
                //check in the older string variable for any existing string
                if (charSet.size() >= oldercharSet.size()) {
                    oldercharSet.clear();
                    oldercharSet.addAll(charSet);
                    //make set empty
                    charSet.clear();
                    //add new char item
                    charSet.add(item);
                } else {
                    //make set empty
                    charSet.clear();
                    //add new char item
                    charSet.add(item);
                }

                //
                System.out.println("\n");
                System.out.println("oldercharSet : " + oldercharSet.toString());
                System.out.println("charSet : " + charSet.toString());
            }
        }

        //now check set vs older string length
        longestStrSize = oldercharSet.size() > charSet.size()
                ? oldercharSet.size() : charSet.size();

        //init longest string as well
        longestString = oldercharSet.size() > charSet.size()
                ? oldercharSet.toString() : charSet.toString();

        System.out.println("longest string : " + longestString);
        System.out.println("longest string size : " + longestStrSize);

        return longestStrSize;
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int length = i - map.get(s.charAt(i));
                if (length > cur) {
                    cur++;
                } else {
                    cur = length;
                }
            } else {
                cur++;
            }
            map.put(s.charAt(i), i);
            if (cur > res) res = cur;
        }
        return res;
    }

    //14ms solution
    public int lengthOfLongestSubstringBestSolution(String s) {
        int longest = 0, i = 0, j = 0, n = s.length();
        Set<Character> set = new HashSet<>();
        while (i < n && j < n) {
            //this option keeps on removing items until all occurences of the items are removed
            if (set.contains(s.charAt(j))) {
                System.out.println("charAt : " + s.charAt(j));
                System.out.println("set1 : " + set.toString());
                set.remove(s.charAt(i++));
                System.out.println("set1 - aftr remove: " + set.toString());
            } else {
                //now either add a new item or the previously removed repeating item which is no more available
                //in the set
                set.add(s.charAt(j++));
                System.out.println("set2 : " + set.toString());
                longest = Math.max(longest, j - i);
            }
        }

        return longest;
    }

    /**
     * "abcabcbb"
     * "bbbbb"
     * "pwwkew"
     * ""
     *
     * @param args
     */
    public static void main(String[] args) {
        LongestSubString obj = new LongestSubString();
        //obj.longestSubString("abcabcbb");
        //longestSubString("bbbbb");
        //longestSubString("");
        //obj.longestSubString("pwwkew");
        //obj.longestSubString("pwwkewwwwwakesbj");
        obj.longestSubString("dvdf");
    }
}
