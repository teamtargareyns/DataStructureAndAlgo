package com.test.gyan.ds.array.rotation;

public class RightRotateByK {

    /**
    * Reversal algorithm for right rotation of an array:
    * Given an array, right rotate it by k elements.
    * */

    public  static void reverse(int arr[],int start,int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotateRight(int arr[],int k){
        reverse(arr,0,arr.length-1);
        reverse(arr,0,k-1);
        reverse(arr,k,arr.length-1);

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
        rotateRight(arr, 2); //Left Rotate array by 2(element position)
        printArray(arr);
    }

}
