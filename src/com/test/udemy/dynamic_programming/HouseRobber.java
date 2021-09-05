package com.test.udemy.dynamic_programming;

/**
 * Link: https://leetcode.com/problems/house-robber/
 */
public class HouseRobber {
    private static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        //
        int amount = 0;
        //
        int dp[] = new int[nums.length];
        //INTIALIZE THE DP
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        //
        if (nums.length == 2) return dp[1];
        //
        for (int i = 2; i < nums.length; i++) {
            //KEEPING TRACK OF THE HIGHEST POSSIBLE TILL I AND USING THAT IN
            //NEXT ITERATION
            dp[i] = dp[i - 2] + nums[i];
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }
        amount = Math.max(dp[nums.length - 1], dp[nums.length - 2]);
        return amount;
    }

    public static void main(String[] args) {
        //int[] nums = {2,7,9,3,1};
        int[] nums = {2,9,3};
        System.out.println(rob(nums));
    }

    //index-2 => dp[2] = dp[0] + nums[2] => 2 + 9 = 11
}
