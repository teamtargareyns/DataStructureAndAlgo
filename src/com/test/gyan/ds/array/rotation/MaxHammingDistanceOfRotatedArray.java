package com.test.gyan.ds.array.rotation;

public class MaxHammingDistanceOfRotatedArray {

    /**
     * Given an array of n elements, create a new array which is a rotation of given array and hamming distance between both the arrays is maximum.
     * Hamming distance between two arrays or strings of equal length is the number of positions at which the corresponding character(elements) are different.
     *
     * Note: There can be more than one output for the given input.
     *
     * **/

    public static int maxHammingDistance(int array[]){
        int maxHamming = 0;
        int rotation = 0;
        int arrayDouble[] = new int[array.length*2];
        for(int i = 0;i<array.length;i++){
            arrayDouble[i] = array[i];
        }
        for(int i = 0;i<array.length;i++){
            arrayDouble[array.length +i] = array[i];
        }

        //observe left rotation one by one
        for(int i = 1;i <array.length;i++){
            int currHam = 0;
            for(int j = i,k=0;j<i+array.length; j++,k++){
                if(arrayDouble[j] != array[k]){
                    currHam++;
                }
            }
            if(currHam == array.length){
                maxHamming = currHam;
                rotation = i;
                break;
            }
            if(maxHamming < currHam){
                maxHamming = currHam;
                rotation = i;
            }
        }
        printArray(array);
        //print rotated array
        System.out.println("Rotation:"+rotation+"\n");
        for(int i = rotation;i<rotation+array.length;i++){
            System.out.print(arrayDouble[i]+" ");
        }
        return maxHamming;
    }

    /*UTILITY FUNCTIONS*/
    /* function to print an array */
    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    /* Driver program to test above functions */
    public static void main(String[] args) {
        int arr[] = {1, 1, 1,2};
        int maxHamming = maxHammingDistance(arr);
        System.out.println("\nMax Hamming:"+maxHamming);
       // printArray(arr);
    }
}
