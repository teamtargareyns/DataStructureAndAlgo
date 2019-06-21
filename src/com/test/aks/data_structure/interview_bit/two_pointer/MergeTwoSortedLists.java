package com.test.aks.data_structure.interview_bit.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedLists {

    private static void mergeArray(ArrayList<Integer> listA, ArrayList<Integer> listB){
        int i=0;
        int j=0;

        while(i<listA.size() && j<listB.size()){
            int itemA = listA.get(i);
            int itemB = listB.get(j);

            if(itemA>itemB){
                listA.add(i,itemB);
                i++;
                j++;
            }else{
                i++;
            }

            if(i==listA.size()){
                listA.add(i,itemB);
                j++;
            }
        }

        System.out.println(listA);
    }

    public static void main(String[] args) {
        Integer[] arr1 = {1, 5, 8};
        Integer[] arr2 = {6, 9};
        ArrayList<Integer> list1 = new ArrayList<>();
        List<Integer> arrList1 = Arrays.asList(arr1);
        list1.addAll(arrList1);
        //
        ArrayList<Integer> list2 = new ArrayList<>();
        List<Integer> arrList2 = Arrays.asList(arr2);
        list2.addAll(arrList2);
        //
        mergeArray(list1, list2);
    }
}
