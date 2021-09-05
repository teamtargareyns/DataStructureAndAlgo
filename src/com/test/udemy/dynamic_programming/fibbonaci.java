package com.test.udemy.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class fibbonaci {
    static Map<Integer, Integer> map = new HashMap<>();

    private static int fibonacciMaster(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        if (n < 2) {
            return n;
        } else {
            map.put(n, fibonacciMaster(n - 1) + fibonacciMaster(n - 2));
            return map.get(n);
        }
    }

    public static void main(String[] args) {
        System.out.println(fibonacciMaster(20));
    }
}
