package com.test.udemy.arrays;


import com.test.udemy.Util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Title of problem statement : Two Sum -
 * Link to problem : https://leetcode.com/problems/two-sum/description/
 * <p>
 * Problem statement :
 * Given an array of integers "nums" and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * <p>
 * Problem statement(In my language) :
 * Solve this problem considering variable form of inputs such that
 * 1. Sorted array - using two pinter approach and mainting low and high pointer and keep on moving pinters basis LOW+HIGH is less/greater than target
 * 2. Unsorted array - using hashset approach and check if the complement exists in the set.
 * Input:
 *  nums = Array of integers
 *  target = An integer to Sum equals to two elements present in array
 *
 * Output:
 *  indices of two numbers adding up to target
 *
 * Constraints:
 *  2 <= nums.length <= 10^4
 *  -10^9 <= nums[i] <= 10^9
 *  -10^9 <= target <= 10^9
 *  Only one valid answer exists.
 * <p>
 * Example 1 :
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2 :
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Example 3 :
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * <p>
 * Approach for this problem statement
 * 0.Take input as arr & arr.length >=2
 * 1.Take target as an int variable
 * 2.Take map to store the key and values
 * 3.Key  = the complement of the value present at any index such that (target - valueAtIndex)
 * 4.Value = index of the value stored
 * 5.Now run a loop and check for each value if the valueAtIndex is already present in the map
 * 6.Return the array with indices stored.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {-2,9,11,15,8,7}; //answer - //11//0//11-found
        //int[] nums = {2,9,11,15,8,7}; //answer - //7//0//-4//-6//1//7-found
        int target = 9;
        //print array received
        Util.print(findTwoSum(nums, target));
    }

    private static int[] findTwoSum(final int[] nums, final int target){
        int [] indicesArr = new int[2];
        Map complementMap = new HashMap<Integer, Integer>();
        for (int i=0; i< nums.length; i++){
            if(complementMap.containsKey(nums[i])){
                indicesArr[0] = (int) complementMap.get(nums[i]);
                indicesArr[1] = i;
                break;
            }else {
                complementMap.put(target - nums[i], i);
            }
        }
        return indicesArr;
    }
}
