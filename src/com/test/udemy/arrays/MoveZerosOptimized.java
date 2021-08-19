package com.test.udemy.arrays;


import com.test.udemy.Util;

/**
 * Title of problem statement : Move Zeroes -
 * Link to problem : https://leetcode.com/problems/move-zeroes/description/
 * <p>
 * Problem statement(In my language) :
 * 1. Move all 0's to the end
 * 2. Maintain the order of elements
 * <p>
 * Input:
 * nums = Array of integers
 * <p>
 * Constraints:
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 *
 * <p>
 * Example 1 :
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * <p>
 * Example 2 :
 * Input: nums = [0]
 * Output: [0]
 *
 * <p>
 * Approach for this problem statement
 * 0. Take low and high two pointers
 * 1. start a loop with condition high<arr.length
 * 2. check following conditions -
 * -   LOW   HIGH   RESULT     INCREASE
 * -   1       1      SKIP         LOW++/HIGH++
 * -   0       0       SKIP        HIGH++
 * -   1       0       SKIP        LOW++/HIGH++
 * -   0       1       SWAP        LOW++/HIGH++
 */
public class MoveZerosOptimized {

    public static void main(String[] args) {
        //int[] nums = {0,0,3,0,5,1};
        int[] nums = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0}; //time limit exceeded - SOLVED WITH 100% best solution - 0ms runtime
        //int[] nums = {0,1,0};
        //int[] nums = {2,1,};
        //int[] nums = {0,1,0,3,12};
        //int[] nums = {0, 1, 0, 3, 12, 14}; //{0,1,3,0,12,14}
        //print array received
        Util.print(moveZerosToEnd(nums));
    }

    private static int[] moveZerosToEnd(int[] arr) {
        if (arr.length == 1) return arr;
        //
        int low = 0; //O(1)
        int high = 1; //O(1)
        int lowValue = 0; //O(1)
        int highValue = 0; //O(1)
        while (high < arr.length) {
            lowValue = arr[low];
            highValue = arr[high];
            //
            if (lowValue != 0 && highValue != 0) {
                //skip
                //LOW++/HIGH++
                low++;
                high++;
            } else if (lowValue == 0 && highValue == 0) {
                //skip
                //HIGH++
                high++;
            } else if (lowValue != 0 && highValue == 0) {
                //skip
                //LOW++/HIGH++
                low++;
                high++;
            } else if (lowValue == 0 && highValue != 0) {
                //swap
                arr = swap(arr, low, high);
                //LOW++
                low++;
                high++;
            }
        }
        return arr;
    }

    //swap without using third variable
    private static int[] swap(int[] arr, int low, int high) {
        arr[low] = arr[low] + arr[high];
        arr[high] = arr[low] - arr[high];
        arr[low] = arr[low] - arr[high];
        return arr;
    }
}
