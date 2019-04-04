package com.test.gyan.ds.array.rearrange;

public class IthElementMustBeI {

    /**
     *
     Rearrange an array such that arr[i] = i

     Given an array of elements of length N, ranging from 0 to N – 1. All elements may not be present in the array.
     If element is not present then there will be -1 present in the array.
     Rearrange the array such that A[i] = i and if i is not present, display -1 at that place.
     * */

    public static void rearrange(int arr[]){
        for(int i = 0; i<arr.length;){
            if(arr[i]>=0 && arr[i] != i){
                int temp = arr[arr[i]];
                arr[arr[i]] = arr[i];
                arr[i] = temp;
            } else {
                i++;
            }
        }
        printArray(arr);
    }

    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    /* Driver program to test above functions */
    public static void main(String[] args) {
        int arr[] = {-1, 1, 2, 3, 4, -1, 6, -1, -1, 9};
        int arr1[] = {19, 7, 0, 3, 18, 15, 12, 6, 1, 8,
                11, 10, 9, 5, 13, 16, 2, 14, 17, 4};
        rearrange(arr1);
    }
}
