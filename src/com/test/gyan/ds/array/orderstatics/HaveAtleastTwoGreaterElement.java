package com.test.gyan.ds.array.orderstatics;

/**
 * Find all elements in array which have at-least two greater elements
 * Given an array of n distinct elements, the task is to find all elements
 * in array which have at-least two greater elements than themselves.
 */
public class HaveAtleastTwoGreaterElement {
    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    /* Driver program to test above functions */
    public static void main(String[] args) {
        int arr1[] = {7, -2, 3, 4, 9, -1};
        haveAtleastTwoGreaterElement(arr1);
    }

    /**
     Efficient Approach is to find second maximum Element
     Each element Smaller than this qualifies the condition.
    */

    private static void haveAtleastTwoGreaterElement(int[] arr) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int i = 0; i< arr.length;i++){
            if(arr[i] > firstMax){
                secondMax = firstMax;
                firstMax = arr[i];
            } else if(arr[i]>secondMax){
                secondMax = arr[i];
            }
        }

        for(int i = 0; i< arr.length;i++){
            if(arr[i]<secondMax){
                System.out.println(arr[i]);
            }
        }
    }
}
