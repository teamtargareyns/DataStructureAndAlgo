package com.test.aks.data_structure.interview_bit.strings;

public class LongestCommonPrefix {

    static void findCommonPrefix(String[] strArr) {
        int lenOfShortestString = -1;
        String shortestString = "";

        //find shortest string length
        for (String item : strArr) {
            if (lenOfShortestString == -1
                    || item.length() < lenOfShortestString) {
                lenOfShortestString = item.length();
                shortestString = item;
            }
        }

        //now find prefix
        StringBuilder commonPrefix = new StringBuilder(shortestString);
        for (String item : strArr) {
            lenOfShortestString = commonPrefix.length();
            for (int i = lenOfShortestString-1; i >=0; i--) {
                if (commonPrefix.charAt(i) == item.charAt(i)) {
                    System.out.println("character matched");
                    System.out.println("commonPrefix.charAt("+i+") : " +commonPrefix.charAt(i) );
                    System.out.println("item.charAt("+i+") : " +item.charAt(i) );
                    System.out.println("\n");
                } else {
                    System.out.println("character un-matched");
                    System.out.println("commonPrefix.charAt("+i+") : " +commonPrefix.charAt(i) );
                    System.out.println("remove this character");
                    commonPrefix.deleteCharAt(i);
                    System.out.println("\n");
                }
            }

            System.out.println("commonPrefix : After item completion - "+commonPrefix);
        }

    }

    public static void main(String[] args) {
        String[] strArr = new String[]{"abcdefgh", "aefghijk", "abcefgh"};
        findCommonPrefix(strArr);
    }
}
