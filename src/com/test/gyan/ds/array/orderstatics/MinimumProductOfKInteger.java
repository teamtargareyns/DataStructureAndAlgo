package com.test.gyan.ds.array.orderstatics;

import com.test.gyan.ds.array.MinHeap;

/**
 * Given an array of n positive integers. We are required to write a program to print
 * the minimum product of k integers of the given array.
 *
 * Examples:
 *
 * Input : 198 76 544 123 154 675
 *          k = 2
 * Output : 9348
 * We get minimum product after multiplying
 * 76 and 123.
 */
public class MinimumProductOfKInteger {
    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    /* Driver program to test above functions */
    public static void main(String[] args) {
        int arr[] = {198, 76, 544, 123, 154, 675};
        int k = 2;
        minimumProductOfKInteger(arr,k);
    }

    /**
     * Approach is to find smallest K elements in an Array.
     */
    private static void minimumProductOfKInteger(int[] arr,int k) {
        MinHeap heap = new MinHeap(arr.length);
        for(int i = 0;i<arr.length;i++){
            heap.insertNode(arr[i]);
        }

        int product = 1;
        for(int i = 0;i<k;i++){
            int min = heap.extractMinNode();
            product = product*min;
        }
        System.out.print("Minimum Product: "+product);
    }
}
