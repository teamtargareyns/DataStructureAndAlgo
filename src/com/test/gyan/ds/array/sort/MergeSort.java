package com.test.gyan.ds.array.sort;

public class MergeSort {
    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] arg) {
        int arr[] = {198, 76, 544, 123, 154, 675};
        mergeSort(arr, 0, arr.length - 1);
        printArray(arr);
    }

    private static void mergeSort(int[] arr, int start, int end) {
        int mid = (start + end) / 2;
        if (start < end) {
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int tempArr[] = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                tempArr[k] = arr[i];
                i++;
                k++;
            } else {
                tempArr[k] = arr[j];
                j++;
                k++;
            }
        }

        while (i <= mid) {
            tempArr[k] = arr[i];
            i++;
            k++;
        }
        while (j <= end) {
            tempArr[k] = arr[j];
            j++;
            k++;
        }

        for (int x = start; x <= end; x++) {
            arr[x] = tempArr[x - start];
        }
    }
}
