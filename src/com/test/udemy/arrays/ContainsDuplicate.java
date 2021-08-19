package com.test.udemy.arrays;


import com.test.udemy.Util;

import java.util.*;

/**
 * Title of problem statement : Contains Duplicate -
 * Link to problem : https://leetcode.com/problems/contains-duplicate/description/
 * <p>
 * Problem statement(In my language) :
 * 1. Return "true" if any value appears ATLEAST TWICE
 * 2. Return "false" if every element is distinct
 * <p>
 * Input:
 * nums = Array of integers
 *
 * <p>
 * Example 1 :
 * Input: nums = [1,2,3,1]
 * Output: true
 * <p>
 * Example 2 :
 * Input: nums = [1,2,3,4]
 * Output: false
 * <p>
 * Example 3 :
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * <p>
 * Approach for this problem statement
 * 0. Use map
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        //[1,2,3,1]
        //[1,2,3,4]
        //[1,1,1,3,3,4,3,2,4,2]
        //print array received
        System.out.println(isContainDuplicate(nums));
    }

    //solution -

    //3ms Answer
    /**
     *  if(nums.length==1)
     *             return false;
     *         Arrays.sort(nums);
     *         for(int i=0;i<nums.length-1;i++)
     *             if(nums[i]==nums[i+1])
     *                 return true;
     *         return false;
     */

    /**
     * //3ms Answer
     * Arrays.sort(nums);
     * <p>
     * int mid = (int) Math.floor(nums.length / 2);
     * int prevPtr = 0;
     * int nextPtr = prevPtr + 1;
     * <p>
     * while (nextPtr < nums.length) {
     * if (nums[prevPtr] == nums[nextPtr])
     * return true;
     * <p>
     * prevPtr++;
     * nextPtr++;
     * }
     * return false;
     */

    //6ms Answer
    private static boolean isContainDuplicate(int[] arr) {
        if (arr.length == 1)
            return false;

        Set set = new HashSet();
        for (int item : arr) {
            if (set.contains(item)) {
                return true;
            } else {
                set.add(item);
            }
        }
        return false;
    }

    /*public boolean containsDuplicate(int[] nums) {
        if (nums.length == 1)
            return false;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] == nums[i + 1])
                return true;
        return false;
    }*/
}
