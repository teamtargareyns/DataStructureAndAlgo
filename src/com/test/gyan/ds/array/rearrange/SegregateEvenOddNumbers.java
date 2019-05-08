package com.test.gyan.ds.array.rearrange;

public class SegregateEvenOddNumbers {

    /**
     *
     Given an array of integers, segregate even and odd numbers in the array.
     All the even numbers should be present first, and then the odd numbers.
     * */



    public static void segregateEvenOdd(int arr[]){

        for(int i = 0,count= -1;i<arr.length;i++){
            if(arr[i]%2 == 0){
                count++;
                int temp = arr[count];
                arr[count] = arr[i];
                arr[i] = temp;
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
        //int arr[] = {-1, 1, 2, 3, 4, -1, 6, -1, -1, 9};
        int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        segregateEvenOdd(arr1);
    }
}
