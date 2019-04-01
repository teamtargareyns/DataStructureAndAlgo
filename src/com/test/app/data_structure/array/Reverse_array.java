package com.test.app.data_structure.array;

public class Reverse_array {

    /*Function to reverse arr[] from index start to end*/
    private void reverse(int arr[], int start, int end){

        while(start<end){

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;

        }

    }

}
