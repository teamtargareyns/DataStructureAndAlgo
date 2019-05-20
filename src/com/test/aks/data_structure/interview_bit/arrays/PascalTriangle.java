package com.test.aks.data_structure.interview_bit.arrays;

public class PascalTriangle {


    /**
     * @param n
     * @return
     */
    private static int[][] printPascalTriangle(int n) {
        int arr[][] = new int[n][n];
        for (int row = 0; row < n; ++row) {
            for (int col = 0; col < row + 1; ++col) {
                //first element in the row
                if (col == 0 || col == row) {
                    arr[row][col] = 1;
                } else {
                    //middle elements in the row
                    arr[row][col] = arr[row - 1][col] + arr[row - 1][col - 1];

                    //check if value is more than 10
                    if (arr[row][col] >= 10) {
                        int quotient = arr[row][col] / 10;
                        int remainder = arr[row][col] % 10;
                        arr[row][col] = remainder;
                        arr[row][col - 1] = arr[row][col - 1] + quotient;
                    }

                }
            }
        }

        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr.length; ++j) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }

        return arr;
    }


    // Driver program
    public static void main(String[] args) {
        int n = 7;
        printPascalTriangle(n);
    }
}
