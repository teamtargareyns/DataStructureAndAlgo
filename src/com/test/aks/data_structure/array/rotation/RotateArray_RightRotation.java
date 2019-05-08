package com.test.aks.data_structure.array.rotation;

/**
 * Title of problem statement : Reversal algorithm for array rotation(Right rotation)
 *
 * Approach for this problem statement
 * <p>
 * Let the array be arr[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], d = 3(element position) and n = 10
 * Output = [8 9 10 1 2 3 4 5 6 7]
 * Steps:
 * A = [8, 9, 10] and B = [1, 2, 3, 4, 5, 6, 7]
 * <p>
 * Reverse all, we get (AB)r = [10 9 8 7 6 5 4 3 2 1]
 * Reverse A, we get (ArB)r = [8 9 10 7 6 5 4 3 2 1]
 * Reverse B, we get (ArBr)r = [8, 9, 10, 1, 2, 3, 4, 5, 6, 7]
 */

public class RotateArray_RightRotation {

    /* Function to left rotate arr[] of size n by d */
    static void rightRotate(int arr[], int d) {
        int n = arr.length;
        reverseArray(arr, 0, n - 1);
        reverseArray(arr, 0, d - 1);
        reverseArray(arr, d, n - 1);
    }

    /*Function to reverse arr[] from index start to end*/
    static void reverseArray(int arr[], int start, int end) {
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
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8 ,9, 10};
        rightRotate(arr, 3); //Right Rotate array by 3(element position)
        printArray(arr);
    }

}
