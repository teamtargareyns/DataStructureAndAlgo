package com.test.aks.data_structure.interview_bit.arrays;

/**
 * RepeatAndMissingNumberArray
 * <p>
 * Input -  int arr[] = {3, 1, 2, 5, 3};
 * Output - [3,4]
 *
 */

public class RepeatAndMissingNumberArray_On {



    private static void printTwoElements(int arr[], int size) {
        int i;
        System.out.print("The repeating element is ");

        for (i = 0; i < size; i++) {
            int value = Math.abs(arr[i]);
            if (arr[value - 1] > 0)
                arr[value - 1] = -arr[value - 1];
            else
                System.out.println(value);
        }

        System.out.print("And the missing element is ");
        for (i = 0; i < size; i++) {
            if (arr[i] > 0)
                System.out.println(i + 1);
        }
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = {7, 3, 4, 5, 5, 6, 2};
        /*int a= 1;
        int b = 2;
        int [] arr1 = new int[]{a,b};*/
        int n = arr.length;
        printTwoElements(arr, n);
    }
}