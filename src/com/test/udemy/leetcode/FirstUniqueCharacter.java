package com.test.udemy.leetcode;

import java.util.HashMap;

/**
 * Leetcode - https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
