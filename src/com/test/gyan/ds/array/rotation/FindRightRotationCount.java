package com.test.gyan.ds.array.rotation;

public class FindRightRotationCount {

    /**
     * Consider an array of distinct numbers sorted in increasing order. The array has been rotated (clockwise)
     * k number of times. Given such an array, find the value of k.
     * */

    public static int rightRotationCount(int arr[]){
        int k = 0;
        for(int i = 0; i<arr.length-1;i++){
            if(arr[i] > arr[i+1]){
                return ++k;
            }
            ++k;
        }
        return 0;
    }

    /* Driver program to test above functions */
    public static void main(String[] args) {
        int arr[] = {15, 18, 2, 3, 6, 12};
        int rotationCount = rightRotationCount(arr);
        System.out.println("\nRotation Count:"+rotationCount);
    }
}
