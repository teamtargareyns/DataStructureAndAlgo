package com.test.aks.data_structure.interview_bit.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortByColor {

    public static void sortColors(ArrayList<Integer> arrayList) {
        int i = 0, j = arrayList.size() - 1;
        final Integer RED = 0;
        final Integer WHITE = 1;
        final Integer BLUE = 2;

        while (i <= j) {
            Integer i_item = arrayList.get(i);
            if (i_item == RED) {
                i++;
            } else {
                if (arrayList.get(j) == RED) {
                    Integer j_item = i_item;
                    i_item = arrayList.get(j);
                    arrayList.set(i, i_item);
                    arrayList.set(j, j_item);
                    i++;
                    j--;
                } else {
                    j--;
                }

            }
        }

        //re-asign
        j = arrayList.size()-1;

        while (i<=j){
            Integer i_item = arrayList.get(i);
            if (i_item == WHITE) {
                i++;
            } else if (i_item != WHITE) {
                if (arrayList.get(j) == WHITE) {
                    Integer j_item = i_item;
                    i_item = arrayList.get(j);
                    arrayList.set(i, i_item);
                    arrayList.set(j, j_item);
                    i++;
                    j--;
                } else {
                    j--;
                }

            }
        }

        System.out.println(arrayList);
    }

    public static void main(String[] args) {
        //Integer[] arr = {0, 1, 1, 1, 2, 0, 0, 0, 1, 1, 2, 2, 2};
        //Integer[] arr = {0, 0, 2, 2, 2, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 2, 1, 1, 1, 0, 1, 1, 2, 2, 2, 2, 1, 1, 1, 0, 2, 0, 2, 2, 1, 2, 1, 1, 1, 2, 0, 2, 0, 0, 0, 1, 2, 0, 1, 0, 1, 1, 1, 2, 0, 2, 1, 2, 1, 2, 0, 1, 2, 2, 0, 2, 0, 2, 2, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 2, 2, 0, 2, 2, 1, 1, 1, 0, 0, 2, 1, 1, 1, 2, 1, 0, 1, 0, 0, 1, 0, 1, 1, 2, 2, 2, 1, 1, 1, 2, 1, 0, 1, 2, 1, 0, 1, 0, 0, 2, 1, 0, 2, 2, 0, 2, 1, 2, 2, 0, 2, 0, 2, 0, 0};
        Integer[] arr = {1, 1, 1, 0, 2, 0, 2, 2, 0, 2, 2, 2, 1, 1, 0, 0, 0, 1, 0, 1, 2, 1, 0, 0, 1, 2, 1, 2, 0, 2, 2, 2, 0, 1, 2, 1, 0, 2, 1, 0, 1, 1, 2, 0, 0, 1, 0, 1, 1, 2, 0, 1, 1, 2, 1, 0, 1, 2, 2, 1, 2, 0, 0, 0, 1, 0, 0, 0, 2, 2, 2, 2, 2, 0, 1, 1, 1, 0, 2, 0, 2, 1, 0, 1, 2, 1, 2, 0, 0, 2, 1, 0, 0, 0, 1, 1, 2, 1, 2, 0, 2, 0, 1, 1, 0, 2, 1, 1, 0, 1, 1, 2, 1, 0, 1, 2, 1, 2, 1, 1, 2, 1, 0, 1, 2, 0, 2, 2, 2, 2, 0, 2, 0, 2, 1, 1, 0, 1, 0, 2, 2, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 2, 0, 1, 2, 2, 1, 0, 2, 2, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 0, 2, 0, 2, 0, 1, 1, 1, 1, 1, 2, 1, 1, 0, 0, 0, 0, 2, 1, 1, 2, 0, 2, 2, 0, 1, 2, 2, 1, 0, 2, 2, 1, 2, 2, 2, 0, 0, 2, 1, 1, 1, 0, 1, 2, 0, 2, 1, 2, 0, 0, 0, 0, 0, 2, 1, 0, 1, 1, 1, 2, 0, 0, 2, 1, 1, 1, 1, 2, 2, 1, 1, 0, 1, 0, 1, 1, 0, 1, 2, 2, 0, 2, 0, 0, 1, 2, 2, 2, 0, 2, 2, 0, 1, 2, 1, 2, 1, 0, 2, 1, 0, 1, 0, 0, 1, 2, 0, 1, 1, 2, 2, 2, 2, 1, 1, 0, 2, 2, 0, 1, 0, 1, 2, 0, 0, 2, 0, 2, 2, 2 };
        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> arrList = Arrays.asList(arr);
        list.addAll(arrList);
        sortColors(list);
        //System.out.println(list);
    }
}
