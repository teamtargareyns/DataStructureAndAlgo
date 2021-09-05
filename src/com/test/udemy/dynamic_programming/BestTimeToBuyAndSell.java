package com.test.udemy.dynamic_programming;

/**
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 *
 * Approach -
 * 0. BREAK THE PROBLEM INTO 3 SUB-PROBLEMS
 * 1. figure out the min price first
 * 2. figure out the max price then
 * 3. return the diff
 */
public class BestTimeToBuyAndSell {
    private static int maxProfit(int[] prices) {
        //
        if(prices.length<2) return 0;
        //
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        //
        for (int i=0; i<prices.length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else {
                if((prices[i] - minPrice) > maxProfit){
                    maxProfit = prices[i] - minPrice;
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        //
        System.out.println(maxProfit(prices));
    }
}
