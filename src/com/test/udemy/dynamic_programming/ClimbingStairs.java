package com.test.udemy.dynamic_programming;

/**
 * Link: https://leetcode.com/problems/climbing-stairs
 *
 *
 * Approach
 * 1. n = 3
 * 2. to climb step 1 = d[0] = 1
 * 3. to climb step 2 = d[1] = d[0] + 1
 * 4. to climb step 3 = d[2] = d[1] + 1
 */
public class ClimbingStairs {
    private static int wayOfClimbingStairs(int n) {
        // base case when n=0 and n=1 = these cases only have 1 way
        if(n<2) return 1;

        // initialize the first variables of the sequence
        // Sequence of steps follows fibbionaci sequence (1,1,2,3,5 etc...)
        int x=1;
        int y=1;

        // go through each step
        for(int i=2; i <= n; i++) {
            // set temp to y -- saving y value
            int temp = y;
            // set y to be sum of itself and prev number
            y = y + x;
            // move temp to X -- copying saved y value
            x = temp;
        }
        // by end of loop; y contains num of ways
        return y;
    }

    public static void main(String[] args) {
        System.out.println(wayOfClimbingStairs(50));
    }
}
