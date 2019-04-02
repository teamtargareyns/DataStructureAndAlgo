package com.test.aks.data_structure.array;

/**
 * Title of problem statement : Find the Rotation Count in Rotated Sorted array(ascending order)
 * <p>
 * Problem statement :
 * Consider an array of distinct numbers sorted in increasing order.
 * The array has been rotated (clockwise) k number of times. Given such an array, find the value of k.
 * <p>
 * Approach for this problem statement
 * 1. Using linear search
 * 2. Using Binary Search
 * Let the array be arr[] = [15, 18, 2, 3, 6, 12] and Initial array must be {2, 3, 6, 12, 15, 18}
 * <p>
 * If we take closer look at examples, we can notice that the number of rotations is equal to index of minimum element.
 * A simple linear solution is to find minimum element and returns its index.
 */

public class RotationCount {

    // Returns count of rotations for an
    // array which is first sorted in
    // ascending order, then rotated
    static int countRotations(int arr[]) {
        // We basically find index of minimum element
        int min_ele = arr[0], min_index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (min_ele > arr[i]) {
                min_ele = arr[i];
                min_index = i;
                break;
            }
        }

        return min_index;
    }


    // Driver program to test above functions
    public static void main(String[] args) {
        //int arr[] = {15, 18, 2, 3, 6, 12};
        int arr[] = {7, 9, 11, 12, 5};
        System.out.println(countRotations(arr));
    }

}
