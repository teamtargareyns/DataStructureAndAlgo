package com.test.aks.data_structure.interview_bit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeros {

    static void setZeroes(ArrayList<ArrayList<Integer>> a) {

    }

    public static void main(String[] args) {
        Integer arr2D[][] = {{1,0,1,1},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,1}};
        int size = arr2D.length;

        ArrayList<ArrayList<Integer>> arrayListOuter2D = new ArrayList<>();
        ArrayList<Integer> arrayListInner;

        for(int i=0;i<size;i++){
            arrayListInner = new ArrayList<>();
            arrayListInner.addAll(Arrays.asList(arr2D[i]));
            arrayListOuter2D.add(arrayListInner);
        }

        System.out.println(arrayListOuter2D);
    }

}
