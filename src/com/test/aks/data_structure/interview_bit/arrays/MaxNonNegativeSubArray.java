package com.test.aks.data_structure.interview_bit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxNonNegativeSubArray {

    // Function that returns the longest
    // subarray of non-negative integers
    private static ArrayList<Integer> longestSubarry(Integer arr[], int n) {
        List<Integer> inputArr = Arrays.asList(arr);
        ArrayList<Integer> maxArray = new ArrayList<Integer>();
        ArrayList<Integer> newArray = new ArrayList<Integer>();

        // Initialize result
        int maxSum = 0;
        int newSum = 0;

        for (Integer ele : inputArr) {
            if (ele >= 0) {
                newSum += ele;
                newArray.add(ele);
                if (newSum > maxSum) {
                    maxSum = newSum;
                    maxArray.clear();
                    maxArray.addAll(newArray);
                }
            } else {
                //reset new sum and new arr
                newSum = 0;
                newArray.clear();
            }
        }

        System.out.print("\n'''''''maxSum : " + maxSum + "\n");
        System.out.print("\n'''''''maxArray'''''\n");
        for (Integer i : maxArray) {
            System.out.println(i + ", ");
        }

        System.out.print("\n'''''''newSum : " + newSum + "\n");
        System.out.print("\n'''''''newArray'''''\n");
        for (Integer i : newArray) {
            System.out.println("\n");
            System.out.print(i + ", ");
        }

        if (maxSum > newSum) {
            return maxArray;
        } else if (newSum > maxSum) {
            return newArray;
        }else if (newSum == maxSum) {
           if(maxArray.size()>newArray.size()){
               return maxArray;
           }else {
               return newArray;
           }
        }

        return null;
    }

    // Driver code
    public static void main(String[] args) {
        //Integer arr[] = {1, 0, 4, 0, 1, -1, -1, 0, 0, 1, 0};
        Integer arr[] = {1, 2, 5, -7, 2, 3};
        int n = arr.length;
        List<Integer> returnArr = longestSubarry(arr, n);
        System.out.println("\n");
        System.out.println("Returned Arr");
        System.out.println(returnArr);
    }
}
