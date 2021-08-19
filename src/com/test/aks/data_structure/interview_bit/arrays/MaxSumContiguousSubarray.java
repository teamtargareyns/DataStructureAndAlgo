package com.test.aks.data_structure.interview_bit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumContiguousSubarray {

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int maxSubArray(final int[] arr) {
        int size = arr.length;
        int maxResultSum = Integer.MIN_VALUE;
        int maxTilHere = 0;

        //{-2, 1, -3, 4, -1, 2, 1, -5, 4}
        for (int i = 0; i < size; i++) {
           maxTilHere = maxTilHere  +arr[i];//-2//1//-2//4//3//5//6

           //two conditions
            //1.
            if(maxTilHere>maxResultSum){//true//true//false//true//false//true//true
                maxResultSum = maxTilHere;//-2//1//4//5//6
            }


            //2.
            if(maxTilHere<0){//true//false//true//false//false//false//false
                maxTilHere = 0;
            }

        }


        return maxResultSum;

    }


    // Driver code
    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
    }

}
