package com.test.aks.data_structure.geeksforgeeks.array.rotation;


import java.util.Arrays;

/**
 * Title of problem statement : Given an array A[] and a number x, check for pair in A[] with sum as x
 * <p>
 * Problem statement :
 * Write a program that, given an array A[] of n numbers and another number x,
 * determines whether or not there exist two elements in S whose sum is exactly x.
 * <p>
 * Approach for this problem statement
 * hasArrayTwoCandidates (A[], ar_size, sum)
 * 1) Sort the array in non-decreasing order.(IMPORTANT)
 * 2) Initialize two index variables to find the candidate
 * elements in the sorted array.
 * (a) Initialize first to the leftmost index: l = 0
 * (b) Initialize second  the rightmost index:  r = ar_size-1
 * 3) Loop while l < r.
 * (a) If (A[l] + A[r] == sum)  then return 1
 * (b) Else if( A[l] + A[r] <  sum )  then l++
 * (c) Else if( A[l] + A[r] >  sum ) then r--
 * 4) No candidates in whole array - return 0
 *
 *
 * Ex-
 * Input: arr[] = {11, 15, 6, 8, 9, 10}, x = 16
 * Output: true
 * There is a pair (6, 10) with sum 16
 *
 * Input: arr[] = {11, 15, 26, 38, 9, 10}, x = 35
 * Output: true
 * There is a pair (26, 9) with sum 35
 *
 * Input: arr[] = {11, 15, 26, 38, 9, 10}, x = 45
 * Output: false
 * There is no pair with sum 45.
 */
public class CheckForPairWithSumX {

    // Function to check if array has 2 elements
    // whose sum is equal to the given value
    static boolean hasArrayTwoCandidates(int A[], int arr_size, int sum) {
        int l, r;

        /* Sort the elements */
        Arrays.sort(A);

        /* Now look for the two candidates
        in the sorted array*/
        l = 0;
        r = arr_size - 1;
        while (l < r) {
            if (A[l] + A[r] == sum)
                return true;
            else if (A[l] + A[r] < sum)
                l++;
            else // A[i] + A[j] > sum
                r--;
        }
        return false;
    }

    // Driver code
    public static void main(String args[]) {
        //int A[] = {1, 4, 45, 6, 10, -8};
        int A[] = {11, 15, 6, 8, 9, 10};
        int n = 16;
        int arr_size = A.length;

        // Function calling
        if (hasArrayTwoCandidates(A, arr_size, n))
            System.out.println("Array has two " +
                    "elements with given sum");
        else
            System.out.println("Array doesn't have " +
                    "two elements with given sum");

    }

}
