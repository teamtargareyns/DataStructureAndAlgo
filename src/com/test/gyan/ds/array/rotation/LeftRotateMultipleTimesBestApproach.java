package com.test.gyan.ds.array.rotation;

public class LeftRotateMultipleTimesBestApproach {

    /**
     *
     Print left rotation of array in O(n) time and O(1) space

     Given an array of size n and multiple values around which we need to left rotate the array. How to quickly print multiple left rotations?
     * */

    public static void leftRotate(int arr[], int n, int k){
        int mod = k%n;
        for(int i = 0; i<n;i++){
            System.out.print(arr[(i+mod)%n]+" ");
        }
    }

    public static void main (String[] args)
    {
        int arr[] = { 1, 3, 5, 7, 9 };
        int n = arr.length;

        int k = 2;
        leftRotate(arr, n, k);

        k = 3;
        leftRotate(arr, n, k);

        k = 4;
        leftRotate(arr, n, k);
    }
}
