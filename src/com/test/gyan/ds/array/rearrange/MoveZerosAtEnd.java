package com.test.gyan.ds.array.rearrange;

public class MoveZerosAtEnd {

    /**
     *
     Move all zeroes to end of array

     Given an array of random numbers, Push all the zero’s of a given array to the end of the array.
     For example, if the given arrays is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0},
     it should be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}. The order of all other elements should be same.
     Expected time complexity is O(n) and extra space is O(1).
     * */


    //By Swaping
    //Another aproach is firt count number of zeros, place all non zero element at start of array, fill the remaining array with zero
    public static void moveZeroAtEnd(int arr[]){
        for(int i = 0,j= 0,k=0;k<arr.length;k++){
            if(arr[i] == 0){
                int temp = arr[(arr.length-1)-j];
                arr[(arr.length-1)-j] = arr[i];
                arr[i] = temp;
                j++;
            } else {
                i++;
            }
            printArray(arr);
            System.out.print("\n");
        }

        printArray(arr);
    }


    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    /* Driver program to test above functions */
    public static void main(String[] args) {
        //int arr[] = {-1, 1, 2, 3, 4, -1, 6, -1, -1, 9};
        int arr1[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};
        moveZeroAtEnd(arr1);
    }
}
