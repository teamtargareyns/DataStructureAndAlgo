package com.test.aks.data_structure.booking_questions;

import java.util.Scanner;

public class SolutionDelta {

    private static final int ESCAPE_TOKEN = -128;

    public static void main(String[] args) {
        //declare scanner
        Scanner in = new Scanner(System.in);
        //read from stdin
        String str = in.nextLine();
        //split array with "space" as delimiter
        String[] nums = str.split(" ");
        //
        int[] deltaArray = new int[nums.length];
        int i = 0;
        deltaArray[0] = Integer.parseInt(nums[0]);
        for (i = 1; i < nums.length; i++) {
            deltaArray[i] = Integer.parseInt(nums[i]) - Integer.parseInt(nums[i - 1]);
        }

        System.out.print(deltaArray[0] + " ");
        for (i = 1; i < nums.length; i++) {
            if (deltaArray[i] < -127 || deltaArray[i] > 127)
                System.out.print("-128 " + deltaArray[i] + " ");
            else System.out.print(deltaArray[i] + " ");

        }

        in.close();
    }




}
