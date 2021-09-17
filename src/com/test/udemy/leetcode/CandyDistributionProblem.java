package com.test.udemy.leetcode;

import java.util.Arrays;


/**
 * Candy distribution problem - https://leetcode.com/problems/candy/
 */
public class CandyDistributionProblem {

    public int candy(int[] ratings) {
        int sum = 0;

        //
        int [] leftToRight = new int[ratings.length];
        int [] rightToLeft = new int[ratings.length];

        //
        Arrays.fill(leftToRight, 1);
        Arrays.fill(rightToLeft, 1);

        //traverse left to right and start from 2nd item
        for(int i=1; i<ratings.length; i++){
            if(ratings[i] > ratings[i-1]){
                leftToRight[i] = leftToRight[i-1] + 1;
            }
        }

        //traverse right to left and start from 2nd last item
        for(int i=ratings.length-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                rightToLeft[i] = leftToRight[i+1] + 1;
            }
        }

        //calculate max sum
        for(int i=0; i<ratings.length; i++){
            sum += Math.max(leftToRight[i], rightToLeft[i]);
        }


        return sum;
    }


    public static void main(String[] args) {

    }
}
