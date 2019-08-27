package com.test.aks.data_structure.hacker_rank;

import java.util.HashMap;

public class CountPairsWithGivenSum {

    //static int arr[] = new int[]{1, 5, 7, -1, 5} ;
    //static int arr[] = new int[]{7, 7, 5, 6, 3, 11, -1, 2};
    //static int arr[] = new int[]{7, 7, 5,5, 5,3};
    //static int arr[] = new int[]{7,5,5,5,6,3};
    static int arr[] = new int[]{7,7,5,6,3,3};

    // Returns number of pairs in arr[0..n-1] with sum equal
    // to 'sum'
    static int getPairsCount(int n, int sum) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        // Store counts of all elements in map hm
        for (int i = 0; i < n; i++) {

            // initializing value to 0, if key not found
            if (!hm.containsKey(arr[i]))
                hm.put(arr[i], 0);

            //storing frquency of element
            hm.put(arr[i], hm.get(arr[i]) + 1);
        }
        int twice_count = 0;

        // iterate through each element and increment the
        // count (Notice that every pair is counted twice)
        for (int i = 0; i < n; i++) {
            if (hm.get(sum - arr[i]) != null)
                twice_count += hm.get(sum - arr[i]);

            // if (arr[i], arr[i]) pair satisfies the condition,
            // then we need to ensure that the count is
            // decreased by one such that the (arr[i], arr[i])
            // pair is not considered
            if (sum - arr[i] == arr[i])
                twice_count--;
        }

        // return the half of twice_count
        return twice_count / 2;
    }

    // Driver method to test the above function
    public static void main(String[] args) {

        int sum = 10;
        System.out.println("Count of pairs is " +
                getPairsCount(arr.length, sum));

    }
}
