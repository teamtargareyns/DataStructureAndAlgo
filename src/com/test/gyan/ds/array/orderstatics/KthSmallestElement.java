package com.test.gyan.ds.array.orderstatics;

import com.test.gyan.ds.array.MinHeap;

public class KthSmallestElement {

    /**
     *
     Given an array and a number k where k is smaller than size of array,
     we need to find the k’th smallest element in the given array.
     It is given that all array elements are distinct.
     * */



    public static void KthSmallestElement(int arr[], int k){
        MinHeap heap = new MinHeap(arr.length);
        for(int i = 0;i<arr.length;i++){
            heap.insertNode(arr[i]);
        }

        heap.print();
        for(int i = 0; i<k;i++){
            int smallest = heap.extractMinNode();
            if(i == k-1) {
                System.out.print("Kth Smallest :"+smallest);
            }
        }
    }


    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    /* Driver program to test above functions */
    public static void main(String[] args) {
        //int arr[] = {-1, 1, 2, 3, 4, -1, 6, -1, -1, 9};
        int arr1[] = {7, 10, 4, 3, 20, 15};
        int k = 4;
        KthSmallestElement(arr1,k);
    }
}
