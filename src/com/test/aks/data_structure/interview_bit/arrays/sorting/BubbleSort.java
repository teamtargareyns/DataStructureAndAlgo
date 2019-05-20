package com.test.aks.data_structure.interview_bit.arrays.sorting;

public class BubbleSort {

    private static void sortArray(int arr[]) {
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr.length-1; ++j) {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for (int a: arr){
            System.out.print(a+" ");
        }
    }

    public static void main(String[] args) {
        //int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr = {10, 3, 5, 1, 8, 6, 7, 2, 9, 4};
        sortArray(arr);
    }
}
