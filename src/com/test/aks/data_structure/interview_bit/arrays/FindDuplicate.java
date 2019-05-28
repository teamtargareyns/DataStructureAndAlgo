package com.test.aks.data_structure.interview_bit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDuplicate {

    // DO NOT MODIFY THE LIST
    public static int repeatedNumber(final List<Integer> a) {

        List<Integer> list = new ArrayList();
        list.addAll(a);

        for (int i = 0; i < a.size(); i++) {
            int value = Math.abs(list.get(i));
            if (list.get(value - 1) > 0) {
                list.set(value - 1, -list.get(value - 1));
            } else {
                System.out.println(value);
                return value;
            }
        }

        return -1;
    }

    // Driver code
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Integer arr[] = {7, 3, 4, 5, 5, 6, 2};
        list.addAll(Arrays.asList(arr));
        repeatedNumber(list);
    }
}
