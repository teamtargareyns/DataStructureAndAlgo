package com.test.aks.data_structure.interview_bit.arrays;


/**
 * This problem will be solved in three phases
 */
public class MaximumUnsortedSubarray {

    static int[] findMaximumUnsortedSubarray(int[] arr) {
        boolean isIdenticalEle = true;
        int length = arr.length;
        int indexLeft = -1, numLeft = -1;
        int indexRight = -1, numRight = -1;


        /**
         * Phase 1st of Approach
         */
        for (int i = 0; i < length - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                continue;
            } else {
                indexLeft = i;
                numLeft = arr[i];
                break;
            }
        }

        for (int i = length - 1; i > 0; i--) {
            if (arr[i] >= arr[i - 1]) {
                continue;
            } else {
                indexRight = i;
                numRight = arr[i];
                break;
            }
        }


        System.out.println("indexLeft: " + indexLeft);
        System.out.println("indexRight: " + indexRight);
        System.out.println("numLeft: " + numLeft);
        System.out.println("numRight: " + numRight);


        for (int i = 0; i < length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                continue;
            } else {
                isIdenticalEle = false;
            }
        }

        if (isIdenticalEle) return new int[]{-1};


        if (indexLeft < 0 && indexRight < 0) {
            return new int[]{-1};
        }


        /**
         * Now goto phase 2nd
         */
        //First find the number smaller than numLeft which is available at the right most towards arr length
        int smallestMost = -1;
        int smallestMostIndex = -1;
        int largestMost = -1;
        int largestMostIndex = -1;
        for (int index = indexLeft + 1; index < length; index++) {
            /*if ((arr[index] < numLeft && arr[index] < smallestMost) || (smallestMost == -1)) {
                smallestMost = arr[index];
            }*/

            if (arr[index] < numLeft) {
                smallestMost = arr[index];
                smallestMostIndex = index;
            }
        }

        //Second find the number larger than numRight which is available at the left most towards zero index
        for (int index = indexRight - 1; index >= 0; index--) {
            if (arr[index] > numRight) {
                largestMost = arr[index];
                largestMostIndex = index;
            }
        }

        System.out.println("smallestMost: " + smallestMost);
        System.out.println("smallestMostIndex: " + smallestMostIndex);
        System.out.println("largestMost: " + largestMost);
        System.out.println("largestMostIndex: " + largestMostIndex);


        //Now proceed to 3rd phase of the solution
        int actualLeftIndex = -1, actualRightIndex = -1;
        for (int index = 0; index < smallestMostIndex; index++) {
            if(arr[index]>=smallestMost){
                actualLeftIndex = index;
                break;
            }
        }

        for (int index = length-1; index > largestMostIndex; index--) {
            if(arr[index]<=largestMost){
                actualRightIndex = index;
                break;
            }
        }

        System.out.println("actualLeftIndex: " + actualLeftIndex);
        System.out.println("actualRightIndex: " + actualRightIndex);

        return new int[]{actualLeftIndex, actualRightIndex};
    }

    public static void main(String[] args) {
        //int arr[] = {1,3,2,4,5};//[1,2]
        //int arr[] = {1,2,3};//[-1]
        //int arr[] = {1,1};//[-1]
        //int arr[] = {1, 1, 1, 1};//[-1]
        //int arr[] = {4,15,4,4,15,18,20};//[1,3]
        int arr[] = {1, 1, 10, 10, 15, 10, 15, 10, 10, 15, 10, 15};//[4,10]
        //int arr[] = {1, 1, 2, 3, 3, 4, 8, 9, 11, 9, 11, 12, 12, 11, 9, 14, 19, 20, 20};//[8,14]

        //by gyan
        //int arr[] = {1, 2, 3, 7, 5, 6, 4, 8, 9, 10};//[3,6]
        //int arr[] = {1, 2, 3, 5, 6, 7, 4, 8, 9, 10};//[3,6]
        //int arr[] = {10, 20, 30, 50, 60, 70, 40, 80, 35, 90, 75, 100};//[3,6]
        //int arr[] = {1, 2, 3, 5, 6, 13, 15, 16, 17, 13, 13, 15, 17, 17, 17, 17, 17, 19, 19};//Correct value - [6, 11], Wrong REturn VAlue - [7,10]
        //int arr[] = {1, 1, 10, 10, 15, 10, 15, 10, 10, 15, 10, 15 };//Correct value - [4, 10], Wrong REturn VAlue - [2 ,11]
        findMaximumUnsortedSubarray(arr);
    }
}
