package com.test.aks.data_structure.geeksforgeeks.array.rotation;

/**
 * Title of problem statement : Print left rotation of array in O(n) time and O(1) space
 * <p>
 * Problem statement :
 * Given an array of size n and multiple values around which we need to left rotate the array.
 * How to quickly print multiple left rotations?
 * <p>
 * Approach for this problem statement
 */

public class PrintLeftRotationOfArray {

    // Function to leftRotate array multiple
    // times
    static void leftRotate(int arr[], int n,
                           int k) {
        /* To get the starting point of
        rotated array */
        int mod = k % n;

        // Prints the rotated array from
        // start position
        for (int i = 0; i < n; ++i)
            System.out.print(arr[(i + mod) % n]
                    + " ");

        System.out.println();
    }

    // Driver program
    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 7, 9};
        int n = arr.length;

        int k = 2;
        leftRotate(arr, n, k);

        k = 3;
        leftRotate(arr, n, k);

        k = 4;
        leftRotate(arr, n, k);

        k = 14;
        leftRotate(arr, n, k);

        k = 15;
        leftRotate(arr, n, k);

        k = 26;
        leftRotate(arr, n, k);

    }
}
