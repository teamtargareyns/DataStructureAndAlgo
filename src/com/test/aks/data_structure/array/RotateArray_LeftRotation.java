package com.test.aks.data_structure.array;

/**
 * Title of problem statement : Reversal algorithm for array rotation(left rotation)
 *
 * Approach for this problem statement
 * <p>
 * Let the array be arr[] = [1, 2, 3, 4, 5, 6, 7], d =2(element position) and n = 7
 * A = [1, 2] and B = [3, 4, 5, 6, 7]
 * <p>
 * Reverse A, we get ArB = [2, 1, 3, 4, 5, 6, 7]
 * Reverse B, we get ArBr = [2, 1, 7, 6, 5, 4, 3]
 * Reverse all, we get (ArBr)r = [3, 4, 5, 6, 7, 1, 2]
 */

public class RotateArray_LeftRotation {

    /* Function to left rotate arr[] of size n by d */
    static void leftRotate(int arr[], int d) {
        int n = arr.length;
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    }

    /*Function to reverse arr[] from index start to end*/
    static void reverse(int arr[], int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    /*UTILITY FUNCTIONS*/
    /* function to print an array */
    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    /* Driver program to test above functions */
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        leftRotate(arr, 2); //Left Rotate array by 2(element position)
        printArray(arr);
    }

}
