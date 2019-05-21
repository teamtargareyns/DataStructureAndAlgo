package com.test.gyan.ds.array.sort;

public class QuickSort {
    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
    public static void main(String[] arg){
        int arr[] = new int[]{34,12,-16,13,-50,24,48,35};
        quickSort(arr,0,arr.length-1);
        printArray(arr);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low < high){
            int pivotIndex = partition(arr,low,high);
            quickSort(arr,low,pivotIndex-1);
            quickSort(arr,pivotIndex+1,high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int settled = low-1;

        for(int j = low;j<high;j++){
            if(arr[j]<= pivot){
                settled++;
                int smallValue = arr[j];
                arr[j] = arr[settled];
                arr[settled] = smallValue;
            }
        }

        int temp = arr[settled+1];
        arr[settled+1] = arr[high];
        arr[high] = temp;
        return settled+1;
    }

}
