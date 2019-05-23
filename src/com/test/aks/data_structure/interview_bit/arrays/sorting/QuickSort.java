package com.test.aks.data_structure.interview_bit.arrays.sorting;

/**
 * This sort works on the principle of divide and conquer algo
 */

public class QuickSort {

    /**
     * The main function that implements QuickSort()
     * arr[] --> Array to be sorted,
     * low  --> Starting index,
     * high  --> Ending index
     * @param arr
     * @param low
     * @param high
     */
    void quickSort(int arr[], int low, int high) {
        if (low < high) {
            /**
             * pivotIndex is partitioning index,
             * arr[pivotIndex] is now at right place
             */
            int pivotIndex = partition(arr, low, high);
            /**
             * Recursively sort elements before partition and after partition
             */
            quickSort(arr, low, pivotIndex  - 1);
            quickSort(arr, pivotIndex  + 1, high);
        }
    }


    /**
     * This function considers last element as pivot,
     * places the pivot element at its correct
     * position in sorted array, and places all
     * smaller to left of pivot and all greater
     * elements to right of pivot
     * @param arr - arr with ow and high index
     * @param low - starting index of arr
     * @param high - last index of arr
     * @return
     */
    int partition(int arr[], int low, int high) {
        int pivotElement = arr[high];
        int indexOfSoFarSorted= (low - 1);

        /**
         * Run loop from first element of arr to
         * second last element of arr as last element is
         * considered as pivot
         */

        for (int index = low; index < high; index++) {
            /**
             * If current element is smaller than or equal to pivot
             * Then,
             *     1.> increase the "indexOfSoFarSorted" by 1 to allow the new smaller
             *     element to be placed at this index.
             *
             *     2.> Replace the arr[indexOfSoFarSorted] with arr[index] if
             *     arr[index is smaller than pivot]
             */
            if (arr[index] <= pivotElement) {
                //increase the indexOfLastSmallerElement by 1
                ++indexOfSoFarSorted;

                //swap the arr[indexOfLastSmallerElement] with arr[index]
                int temp = arr[indexOfSoFarSorted];
                arr[indexOfSoFarSorted] = arr[index];
                arr[index] = temp;
            }
        }

        /**
         * Now place the pivotElement at arr[indexOfLastSmallerElement + 1]
         * to justify the that all elements before pivotElement are smaller
         * than pivotElement
         */

        int temp = arr[indexOfSoFarSorted + 1];
        arr[indexOfSoFarSorted+1] = pivotElement; //or arr[high]
        arr[high] = temp;

        //Now pivot index is indexOfSoFarSorted+1
        int pivotIndex = indexOfSoFarSorted+1;

        //return pivot index now
        return pivotIndex;
    }

}
