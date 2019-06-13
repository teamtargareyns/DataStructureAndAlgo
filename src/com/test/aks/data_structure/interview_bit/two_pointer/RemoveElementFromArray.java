package com.test.aks.data_structure.interview_bit.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveElementFromArray {

    private static int removeElement(List<Integer> list, Integer element) {
        int size = list.size();
        int i, j;

        for (i = 0, j = 0; j < size; j++) {
            Integer item = list.get(j);
            if (item != element) {
                list.set(i,item);
                i++;
            }
        }

        return i;
    }


    public static void main(String[] args) {
        Integer[] arr = {4, 1, 1, 2, 1, 3};
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(arr));
        int res = removeElement(list, 1);
        System.out.println(res);
    }
}
