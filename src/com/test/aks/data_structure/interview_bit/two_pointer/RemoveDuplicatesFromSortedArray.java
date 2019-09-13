package com.test.aks.data_structure.interview_bit.two_pointer;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicatesFromSortedArray {

    private static int removeDuplicates(ArrayList<Integer> list) {
        int i, j;
        int size = list.size();
        int current = -1;
        for (i = 0, j = 0; j < size; j++) {
            int item = list.get(j);
            if (current == -1
                    || current != item) {
                list.set(i, item);
                current = item;
                i++;
            }
        }

        for (int k = size-1; k>=i; k--) {
            list.remove(k);
        }

        return list.size();
    }

    public static void main(String[] args) {
        //Integer[] arr = {1, 1, 2, 3, 4};
        Integer[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> arrList = Arrays.asList(arr);
        list.addAll(arrList);
        int res = removeDuplicates(list);
        System.out.println(res);
    }

}
