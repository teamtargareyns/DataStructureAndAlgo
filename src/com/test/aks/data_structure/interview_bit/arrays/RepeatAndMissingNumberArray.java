package com.test.aks.data_structure.interview_bit.arrays;

/**
 * RepeatAndMissingNumberArray
 * <p>
 * Input -  int arr[] = {3, 1, 2, 5, 3};
 * Output - [3,4]
 */

public class RepeatAndMissingNumberArray {

    public int[] repeatedNumber(final int[] A) {

        long minElement = A[0];
        long maxElement = A[A.length - 1];
        long lastElement = 0;
        int currentElement = 0;
        int nextElement = 0;
        long repeatingItem = 0;
        long missingItem = 0;

        for (int index = 0; index < A.length; ++index) {
            if (A[index] <= minElement) {
                minElement = A[index];
            }

            if (A[index] >= maxElement) {
                maxElement = A[index];
            }
        }

        //find missing item
        int currentItem = 1; //as problem statement says arr will be within 1 to n
        boolean itemFound = false;
        for (int index = 0; index < A.length; ++index) {
            for (int next = 0; next < A.length; ++next) {
                if (currentItem == A[next]) {
                    itemFound = true;
                    break;
                }
            }

            if (!itemFound) {
                missingItem = currentItem;
                break;
            }

            ++currentItem;
            itemFound = false;
        }

        //find repeating item
        for (int index = 0; index < A.length; ++index) {
            int item = A[index];
            for (int next = index + 1; next < A.length; ++next) {
                if (item == A[next]) {
                    repeatingItem = item;
                }
            }
        }


        System.out.println("minElement : " + minElement);
        System.out.println("maxElement : " + maxElement);
        System.out.println("missingItem : " + missingItem);
        System.out.println("repeatingItem : " + repeatingItem);

        return null;
    }


    // Driver code
    public static void main(String[] args) {
        //int arr[] = {3, 1, 2, 5, 6, 7, 8, 9, 3};
        //int arr[] = {4, 1, 2, 5, 6, 7, 8, 9, 4};
        int arr[] = {4, 11, 1,2, 5, 6, 7, 8, 9, 10,5};
        new RepeatAndMissingNumberArray().repeatedNumber(arr);
        /*int[] output = new RepeatAndMissingNumberArray().repeatedNumber(arr);
        System.out.println("\n\n''''''''''''''''''OUTPUT'''''''''''''''''''");
        for (int element : output) {
            System.out.println(element);
        }*/
    }
}
