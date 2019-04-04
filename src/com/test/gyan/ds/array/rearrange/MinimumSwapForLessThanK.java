package com.test.gyan.ds.array.rearrange;

public class MinimumSwapForLessThanK {

    /**
     *
     Minimum swaps required to bring all elements less than or equal to k together

     Given an array of n positive integers and a number k.
     Find the minimum number of swaps required to bring all the numbers less than or equal to k together.
     * */

    public static void minimumSwapCount(int arr[],int k){
        //first lets count all valid number;which should be together
        int c = 0;
        for(int i = 0; i<arr.length;i++){
            if(arr[i]<=k)c++;
        }

        // we will create a window of length c and calculate swap required for each such window possible
        //minimum swap count among those would be our answer
        //but for this we need to initialize our minSwap with initial value.
        int swap = 0;
        for(int i = 0;i<c;i++){
            if(arr[i] > k)swap++;
        }
        int minSwap = swap;

        for(int i = 0;i<arr.length-c;i++){
            if(arr[i] > k){
                swap--;
            }
            if(arr[(i+c)-1] >k){
                swap++;
            }
            minSwap = Math.min(minSwap,swap);
        }
        System.out.println("Min Swap:"+minSwap);
    }

    public static void main(String[] args) {
        int arr[] = {2, 7, 9, 5, 8, 7, 4};
        int arr1[] = {2, 1, 5, 6, 3};
        minimumSwapCount(arr,5);
    }
}
