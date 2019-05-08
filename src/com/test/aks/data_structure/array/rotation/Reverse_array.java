package com.test.aks.data_structure.array.rotation;

public class Reverse_array {

    /*Function to reverse arr[] from index start to end*/
    static void reverse(int arr[], int start, int end){

        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;

        }
    }

    /*UTILITY FUNCTIONS*/
    /* function to print an array */
    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    /* Driver program to test above functions */
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        reverse(arr,0,arr.length-1); // Rotate array by 2(element position)
        printArray(arr);
    }

}
