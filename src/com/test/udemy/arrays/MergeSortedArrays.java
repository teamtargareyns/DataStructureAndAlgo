package com.test.udemy.arrays;


import com.test.udemy.Util;

/**
 * Title of problem statement : Given two sorted integer arrays. Merge them in sorted manner
 * <p>
 * Problem statement :
 * Given two sorted integer arrays. Merge them in sorted manner
 * <p>
 * Approach for this problem statement
 * 0. CHECK THE INPUT - CHECK FOR EMPTY ARRAYS OR HANDLE ONE ITEM IN ARRAY SITUATION, IF ANY
 * 1. TAKE TWO INDEX VARIABLES - EACH FOR BOTH THE ARRAYS
 * 2. START LOOPING THROUGH THE BOTH THE ARR
 * 3. CHECK CONDITION IF ANY OF THE INDEX VARIABLE REACHES TO THE LENGTH OF IT'S RESPECTIVE ARRAY
 * 4. TERMINATE THE LOOP IF CONDITION IS MET AND APPEND THE REMAINING ARRAY ITEMS INTO THE MERGED ARRAY
 */
public class MergeSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {0, 3, 4, 31};
        int[] arr2 = {4, 6, 30, 32};
        Util.print(mergeSortedArrays(arr1, arr2));
    }

    private static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        //check for empty arrays
        if (arr1 == null
                || arr2 == null
                || arr1.length == 0
                || arr2.length == 0) {
            return new int[]{-1};
        }

        int[] mergedArr = new int[arr1.length + arr2.length];
        int lengthOfArrOne = arr1.length;
        int lengthOfArrTwo = arr2.length;
        int indexForFirstArr = 0;
        int indexForSecondArr = 0;
        int indexForMergedArr = 0;
        while (indexForFirstArr < lengthOfArrOne
                && indexForSecondArr < lengthOfArrTwo) {
            if (arr1[indexForFirstArr] < arr2[indexForSecondArr]) {
                mergedArr[indexForMergedArr++] = arr1[indexForFirstArr++];
            } else {
                mergedArr[indexForMergedArr++] = arr2[indexForSecondArr++];
            }

            //increase index counter
            //indexForFirstArr++;
            //indexForSecondArr++;
        }

        //append the remaining array
        if(indexForFirstArr == lengthOfArrOne
                && indexForSecondArr < lengthOfArrTwo){
            for(int index = indexForSecondArr; indexForSecondArr<lengthOfArrTwo; indexForSecondArr++){
                mergedArr[indexForMergedArr++] = arr2[index];
            }
        }else if(indexForFirstArr < lengthOfArrOne
                && indexForSecondArr == lengthOfArrTwo){
            for(int index = indexForFirstArr; indexForFirstArr<lengthOfArrOne; indexForFirstArr++){
                mergedArr[indexForMergedArr++] = arr1[index];
            }
        }

        //decrease the extra space in the last index
        --indexForMergedArr;

        return mergedArr;
    }
}
