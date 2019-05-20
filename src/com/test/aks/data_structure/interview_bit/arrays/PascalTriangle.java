package com.test.aks.data_structure.interview_bit.arrays;

import java.util.ArrayList;

public class PascalTriangle {



    /**
     * Solution perfect for jdk7 but the issue is we are having extra zeros at the end of each row
     * with this solution
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

    /**
     * Solution perfectly suitable for INterviewBIt.com
     * @param n
     * @return
     */
    private static ArrayList<ArrayList<Integer>> printPascalTriangleArraylist(int n) {
        ArrayList<ArrayList<Integer>> outerArraylist = new ArrayList<>();
        ArrayList<Integer> innerList;

        for (int row = 0; row < n; ++row) {
            innerList = new ArrayList<>();
            outerArraylist.add(innerList);

            for (int col = 0; col < row + 1; ++col) {
                //first and last element in the row
                if (col == 0 || col == row) {
                    //arr[row][col] = 1;
                    innerList.add(1);
                } else {
                    //middle elements in the row
                    //arr[row][col] = arr[row - 1][col] + arr[row - 1][col - 1];

                    //middle elements in the row
                    outerArraylist.get(row).add(col,outerArraylist.get(row - 1).get(col - 1) + outerArraylist.get(row - 1).get(col));

                    //check if value is more than 10
                    /*if (arr[row][col] >= 10) {
                        int quotient = arr[row][col] / 10;
                        int remainder = arr[row][col] % 10;
                        arr[row][col] = remainder;
                        arr[row][col - 1] = arr[row][col - 1] + quotient;
                    }*/

                    /**
                     * v.IMP.
                     */
                    //FOR MAKING IT PERFECT EXPONENT OF 11 SOLUTION
                    //check if value is more than 10
                    /*if (outerArraylist.get(row).get(col) >= 10) {
                        Integer quotient = outerArraylist.get(row).get(col) / 10;
                        Integer remainder = outerArraylist.get(row).get(col) % 10;
                        outerArraylist.get(row).set(col,remainder);
                        outerArraylist.get(row).set(col-1,outerArraylist.get(row).get(col-1)+quotient);
                    }*/

                }
            }

            //outerArraylist.add(innerList);
        }


        for (int i = 0; i < outerArraylist.size(); i++) {
            for (int j = 0; j < outerArraylist.get(i).size(); j++) {
                System.out.print(outerArraylist.get(i).get(j) + " ");
            }
            System.out.println();
        }

        return outerArraylist;
    }


    // Driver program
    public static void main(String[] args) {
        int n = 9;
        printPascalTriangleArraylist(n);
    }
}
