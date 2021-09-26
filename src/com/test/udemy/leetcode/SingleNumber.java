package com.test.udemy.leetcode;

/**
 * Leetcode - https://leetcode.com/problems/single-number/
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i : nums) {
            System.out.println("num - "+i);
            System.out.println("previous result - "+result);
            result = result ^ i;
            System.out.println("result - "+result);
            System.out.println("");
        }
        System.out.println("answer - "+result);
        return result;
    }

    public static void main(String[] args) {
        SingleNumber object = new SingleNumber();
        int [] nums = new int[]{1,2,2,10,4,4,10};
        System.out.println(object.singleNumber(nums));
        //will return 0 if less than divisor
        System.out.println(0/3);
        System.out.println(1/3);
        //will return same number if less than divisor
        System.out.println(0%3);
        System.out.println(1%3);
    }
}
