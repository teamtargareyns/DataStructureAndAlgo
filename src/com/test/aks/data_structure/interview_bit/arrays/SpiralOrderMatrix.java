package com.test.aks.data_structure.interview_bit.arrays;

public class SpiralOrderMatrix {


    /**
     * @param n
     * @return
     */
    private static int[][] printSpiralMatrix(int n) {

        /**
         * k - starting row index - rs
         * m - ending row index - re
         * l - starting column index - cs
         * n - ending column index - ce
         * i - iterator - i
         */

        int arr[][] = new int[n][n];
        int valueCounter = 1;

        int row_start_index = 0; //k
        int col_start_index = 0; //l

        int row_end_index = n - 1; //m
        int col_end_index = n - 1; //n

        int index;

        if (row_end_index == 0 && col_end_index == 0) {
            arr[row_end_index][col_end_index] = 1;
            return arr;
        }

        //-------------------------------------------------------------------
        while (row_start_index < row_end_index
                && col_start_index < col_end_index) {

            //
            for (index = row_start_index; index <= col_end_index; ++index) {
                arr[row_start_index][index] = valueCounter++;
            }
            row_start_index++;


            //
            for (index = row_start_index; index <= row_end_index; ++index) {
                arr[index][col_end_index] = valueCounter++;
            }
            col_end_index--;

            //
            for (index = col_end_index; index >= col_start_index; --index) {
                arr[row_end_index][index] = valueCounter++;
            }
            row_end_index--;

            //
            for (index = row_end_index; index >= row_start_index; --index) {
                arr[index][col_start_index] = valueCounter++;
            }
            col_start_index++;
        }
        //-------------------------------------------------------------------

        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr.length; ++j) {
                System.out.println(arr[i][j]);
            }
        }

        return arr;
    }


    // Driver program
    public static void main(String[] args) {
        int n = 4;
        int a[][] = {{1, 2, 3, 4,},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}};

        printSpiralMatrix(21);
    }
}
