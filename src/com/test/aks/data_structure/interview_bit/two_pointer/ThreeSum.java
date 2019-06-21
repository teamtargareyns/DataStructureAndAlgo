package com.test.aks.data_structure.interview_bit.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {

    public static int threeSumClosest(ArrayList<Integer> list, int num) {
        Collections.sort(list);
        int sum = Integer.MIN_VALUE;
        int minDiff = Integer.MAX_VALUE;
        int min = 0;
        int left = 1;
        int right = list.size()-1;
        while(left<list.size()-2){
            int temp = list.get(min) + list.get(left) + list.get(right);
            int diff = Math.abs(temp - num);
            if(diff == 0 ){
                return 0;
            }

            if(diff<minDiff){
                minDiff = diff;
                sum = temp;
            }

            if(temp < num){
                left++;
            }else {
                right--;
            }
        }

        return sum;

    }

    public static void main(String[] args) {
        Integer[] arr = {-5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3 };
        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> arrList = Arrays.asList(arr);
        list.addAll(arrList);
        System.out.println(threeSumClosest(list, -1));
    }
}
