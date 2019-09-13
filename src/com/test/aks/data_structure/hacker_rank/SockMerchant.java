package com.test.aks.data_structure.hacker_rank;

import java.util.HashMap;

public class SockMerchant {

    public static void main(String[] args) {
        int[] num = new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20};
        int res = sockMerchant(num.length, num);
        System.out.println("Number of pairs are : "+res);
    }


    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int pairCount = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer item : ar) {
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
        }

        for (int item : ar) {
            if (map.get(item) != 0) {
                int tempValue = map.get(item);
                pairCount += tempValue / 2;
                map.put(item, 0);
            }else {
                //this item has already been considered
            }
        }

        return pairCount;
    }
}
