package com.test.udemy.arrays;

/**
 * Title of problem statement : Max SubArray Sum -
 * Link to problem : https://leetcode.com/problems/maximum-subarray/description/
 * <p>
 * Problem statement(In my language) :
 * Input:
 * nums = Array of integers
 * <p>
 * Output:
 * find contigous subarray  = maxSum
 * <p>
 * Constraints:
 * 1 <= nums.length <= 3 * 10^4
 * -10^5 <= nums[i] <= 10^5
 * <p>
 * Example 1 :
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * <p>
 * Example 2 :
 * Input: nums = [1]
 * Output: 1
 * <p>
 * Example 3 :
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * <p>
 * Approach for this problem statement
 * 0. Take two integer variables to store the maximum sum & maximum sum so far
 * 1. keep both the variables as 0 initially
 * 2. now loop through array and keep on adding the value present at each index to the maxSumSoFar variable
 * 3. Check if maxSumSoFar > maxSubArraySum => maxSubArraySum = maxSumSoFar
 * 4. Check if maxSumSoFar < 0 => maxSumSoFar = 0
 */

public class MaxSubArray {

    public static void main(String[] args) {
        //int[] nums = {-2,1,-3,4,-1,2,1,-5,4}; //6
        //int[] nums = {1}; //1
        int[] nums = {5, 4, -1, 7, 8}; //23
        int target = 9;
        //print array received
        System.out.println("Max sub array sum: " + maxSubArray(nums));
        ;
    }

    //input = [-2,-1] ==>> output = [-1]
    private static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        //loop through it
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0)
                sum = nums[i];
            else {
                sum += nums[i];
            }


            if (sum > max)
                max = sum;
        }
        return max;
    }
}

    /*private static int maxSubArraySum(final int[] nums){
        if(nums.length ==1) return nums[0];

        int maxSumSoFar = 0;
        int maxSubArraySum = 0;

        for(int value : nums){
            maxSumSoFar += value;

            if(maxSumSoFar>maxSubArraySum)
                maxSubArraySum = maxSumSoFar;

            if(maxSumSoFar<0)
                maxSumSoFar = 0;
        }

        return maxSubArraySum;
    }*/
