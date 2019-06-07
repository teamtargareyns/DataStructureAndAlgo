package com.test.aks.data_structure.interview_bit.arrays;

import java.util.*;

public class LargestNumber {

    static String printLargestNumber(int[] A) {


        String[] strArr = new String[A.length];

        for (int i = 0; i < A.length; i++) {
            strArr[i] = String.valueOf(A[i]);
        }

        Arrays.sort(strArr, new Comparator<String>() {
            public int compare(String a, String b) {

                // first append b at the end of a
                String ab = a + b;

                // then append a at the end of b
                String ba = b + a;

                //CONDITION FOR DESCENDING ORDER
                //compare and sort numbers in descending order
                return ba.compareTo(ab);
                //return ab.compareTo(ba) > 0 ? -1:1;

                //BOTH CONDITIONS FOR ASCENDING ORDER
                //return ab.compareTo(ba) > 0 ? 1:-1
                //return ab.compareTo(ba);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s : strArr) {
            sb.append(s);
        }

        if (sb.charAt(0) == '0') {     //check if all zeroes are there
            return String.valueOf(0);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] arr = {3, 30, 34, 5, 9};
        //int[] arr = {33333333, 30, 34, 5, 9};
        //int[] arr = {9, 99, 999, 9999, 9998 };
        //int[] arr = {0, 0, 0, 0, 00000 };
        //int[] arr = {0};
        System.out.println(printLargestNumber(arr));
    }

    /*// The main function that prints the
    // arrangement with the largest value.
    // The function accepts a vector of strings
    static void printLargest(Vector<String> arr){

        Collections.sort(arr, new Comparator<String>(){

            // A comparison function which is used by
            // sort() in printLargest()
            @Override
            public int compare(String X, String Y) {

                // first append Y at the end of X
                String XY=X + Y;

                // then append X at the end of Y
                String YX=Y + X;

                // Now see which of the two formed numbers
                // is greater
                //CONDITION FOR DESCENDING ORDER
                //return XY.compareTo(YX) > 0 ? -1:1;
                return YX.compareTo(XY);

                //BOTH CONDITIONS FOR ASCENDING ORDER
                //return XY.compareTo(YX) > 0 ? 1:-1;
                //return XY.compareTo(YX);
            }
        });

        Iterator it = arr.iterator();

        while(it.hasNext())
            System.out.print(it.next());

    }

    // driver program
    public static void main (String[] args) {

        Vector<String> arr;
        arr = new Vector<>();

        //output should be 6054854654
        arr.add("54");
        arr.add("546");
        arr.add("548");
        arr.add("60");

       *//* arr.add("E");
        arr.add("G");
        arr.add("A");
        arr.add("B");*//*
        printLargest(arr);

       *//* // output should be 777776
         arr.add("7");
        arr.add("776");
        arr.add("7");
        arr.add("7");


        //output should be 998764543431
        arr.add("1");
        arr.add("34");
        arr.add("3");
        arr.add("98");
        arr.add("9");
        arr.add("76");
        arr.add("45");
        arr.add("4");*//*

    }*/


}
