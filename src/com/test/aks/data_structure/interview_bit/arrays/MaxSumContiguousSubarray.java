package com.test.aks.data_structure.interview_bit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumContiguousSubarray {

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxSubArray(final int[] arr) {
        int size = arr.length;
        int maxResultSum = Integer.MIN_VALUE;
        int maxTilHere = 0;

        for (int i = 0; i < size; i++) {
           maxTilHere = maxTilHere  +arr[i];

           //two conditions
            //1.
            if(maxResultSum>maxTilHere){
                maxResultSum = maxTilHere;
            }


            //2.
            if(maxTilHere<0){
                maxTilHere = 0;
            }

        }


        return maxResultSum;

    }


    // Driver code
    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new MaxSumContiguousSubarray().maxSubArray(arr));
    }

}
