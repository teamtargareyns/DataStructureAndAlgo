package com.test.aks.data_structure.interview_bit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxNonNegativeSubArray {

    public int[] maxset(int[] A) {
        Integer[] arr = new Integer[A.length];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = A[i];
        }

        //Integer arr[] = {1, 0, 4, 0, 1, -1, -1, 0, 0, 1, 0};
        //Integer arr[] = {1, 2, 5, -7, 2, 3};
        int n = arr.length;
        List<Integer> returnArr = longestSubarry(arr, n);

        int size = returnArr.size();
        int[] result = new int[size];

        for (int i = 0; i < size; ++i) {
            result[i] = returnArr.get(i);
        }

        return result;
    }

    // Function that returns the longest
    // subarray of non-negative integers
    private static ArrayList<Integer> longestSubarry(Integer arr[], int n) {
        List<Integer> inputArr = Arrays.asList(arr);
        ArrayList<Integer> maxArray = new ArrayList<Integer>();
        ArrayList<Integer> newArray = new ArrayList<Integer>();

        // Initialize result
        long maxSum = 0;
        long newSum = 0;

        for (Integer ele : inputArr) {
            if (ele >= 0) {
                newSum = newSum + ele;
                newArray.add(ele);
                if (newSum > maxSum || (newSum == maxSum && newArray.size()>maxArray.size())) {
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
            System.out.print(i);
        }

        System.out.println("\n'''''''''''''''''''''''''''''''''''''");

        System.out.print("\n'''''''newSum : " + newSum + "\n");
        System.out.print("\n'''''''newArray'''''\n");
        for (Integer i : newArray) {
            System.out.print(i);
        }

        System.out.println("\n'''''''''''''''''''''''''''''''''''''");

        if (maxSum > newSum) {
            return maxArray;
        } else if (newSum > maxSum) {
            return newArray;
        } else if (newSum == maxSum) {
            if (maxArray.size() > newArray.size()) {
                return maxArray;
            } else {
                return newArray;
            }
        }

        return null;
    }

    // Driver code
    public static void main(String[] args) {
        //Integer arr[] = {1, 0, 4, 0, 1, -1, -1, 0, 0, 1, 0};
        //Integer arr[] = {1, 2, 5, -7, 2, 3};
        /*Integer arr[] = { 1, 2, 3, -5, 1, 1 };
        int n = arr.length;
        List<Integer> returnArr = longestSubarry(arr, n);
        System.out.println("\n");
        System.out.println("Returned Arr");
        System.out.println(returnArr);*/

        //int arr[] = {1, 2, 5, -7, 2, 3};
        //int arr[] = {1, 2, 3, -5, 1, 1};
        //int arr[] = {0, 0, -1, 0 };
        //int arr[] = {2,3, -1, 5};
        int arr[] = {1967513926, 1540383426, -1303455736, -521595368 };
        int[] output = new MaxNonNegativeSubArray().maxset(arr);
        System.out.println("\n\n''''''''''''''''''OUTPUT'''''''''''''''''''");
        for (int element : output) {
            System.out.println(element);
        }
    }
}
