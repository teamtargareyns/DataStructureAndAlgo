package com.test.aks.data_structure.array;


import java.util.Scanner;

/**
 * Title of problem statement : Program to cyclically rotate an array by one
 * <p>
 * Problem statement :
 * Given an array, cyclically rotate the array clockwise by one.
 * <p>
 * Approach for this problem statement
 * Following are steps.
 * 1) Store last element in a variable say x.
 * 2) Shift all elements one position ahead.
 * 3) Replace first element of array with x.
 */

public class RotateCyclicByOne {


    private static void rotateByOne(int arr[]) {

        int lastEle = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = lastEle;
    }


    public static void main(String[] args) {
        int size = 0;
        System.out.print("Enter no. of elements you want in array:");

        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        int arr[] = new int[size];

        System.out.println("Enter array elements");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        //rotate  by one now
        rotateByOne(arr);

        System.out.println("Cyclically Rotated array:");

        //print
        printArray(arr);

    }

    /*UTILITY FUNCTIONS*/
    /* function to print an array */
    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

}
