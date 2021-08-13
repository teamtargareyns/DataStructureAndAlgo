package com.test.udemy.arrays;

/**
 *
 * Title of problem statement : Given a String. Reverse it in linear time and constant space
 * <p>
 * Problem statement :
 * Given a String. Reverse it in linear time and constant space
 * <p>
 * Approach for this problem statement
 * 1. Convert the String into a char array
 * 2. Take a loop
 * 3. start iterating from start and end together
 * 4. loop until condition is true - startIndex < endIndex
 * 3. We will have our reversed array in linear time and constant time.
 */


public class ReverseString {


    public static void main(String[] args) {
        String str = "My Name Is Aakash";
        char [] charArray = str.toCharArray();
        System.out.println(reverseString(charArray));
    }

    private static char [] reverseString(char [] array){
        int startIndex = 0; //0(1) SPACE
        int endIndex = array.length-1; //O(1) SPACE
        char temp; //0(1) SPACE
        while(startIndex<endIndex){
            temp = array[startIndex];
            array[startIndex] = array[endIndex];
            array[endIndex] = temp;
            //
            startIndex++;
            endIndex--;
        }
        return array;
    }

}
