package com.test.aks.data_structure.interview_bit.arrays;

public class MissingNumber {

    private static void printMissingNumber(int arr[], int size) {
        int i;

        for (i = 0; i < size; i++) {
            int value = Math.abs(arr[i]);
            int index = value - 1;
            if (index < arr.length) {
                if (arr[index] > 0)
                    arr[index] = -arr[index];

            }
        }

        System.out.print("And the missing element is ");
        for (int index = 0; index < size; index++) {
            if (arr[index] > 0)
                System.out.println(index + 1);
        }
    }


    // Driver code
    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 5};
        /*int a= 1;
        int b = 2;
        int [] arr1 = new int[]{a,b};*/
        int n = arr.length;
        printMissingNumber(arr, n);
    }
}
