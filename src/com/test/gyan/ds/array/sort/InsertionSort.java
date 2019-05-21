package com.test.gyan.ds.array.sort;

import java.util.LinkedList;

public class InsertionSort {
    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    /* Driver program to test above functions */
    public static void main(String[] args) {
        int arr[] = {198, 76, 544, 123, 154, 675};
        insertionSort(arr);
    }

    private static void insertionSort(int[] arr) {
        int n = arr.length;
        for(int marker = 1;marker<n;marker++){//unsorted array range
            int j = marker-1;
            int key = arr[marker];
            while (j >=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        printArray(arr);
    }
}
