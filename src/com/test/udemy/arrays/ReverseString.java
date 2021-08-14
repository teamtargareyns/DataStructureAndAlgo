package com.test.udemy.arrays;

import java.util.Arrays;

/**
 *
 * Title of problem statement : Given a String. Reverse it in linear time and constant space
 * <p>
 * Problem statement :
 * Given a String. Reverse it in linear time and constant space
 * <p>
 * Approach for this problem statement
 * 0. CHECK THE INPUT - CHECK FOR null OR 1 CHARACTER STRING AND type string
 * 1. Convert the String into a char array
 * 2. Take a loop
 * 3. start iterating from start and end together
 * 4. loop until condition is true - startIndex < endIndex
 * 3. We will have our reversed array in linear time and constant time.
 */


public class ReverseString {


    public static void main(String[] args) {
        //String str = "I";
        String str = null;
        //String str = "My Name Is Aakash";
        //String str = "!@@#$%^&*()+_)(*&^%$#@!@#$%^&*(_)(*&^%$%^&**&^%$#$%^&*&^%$##$%^&*&^%$";
        //String str = "_sakdkjashdksahkdhjksahdkjakjshdkjahsdkaskdkasdjhasjhckhagcuagskdjkasdjkaskjdhjkashdkjhakjdjkasdkaskjdajksdhjkashdjkahsjkdhjkasckjackhaduihcadlcdjcbkjsbdcjksdjkckjsdcjksdnjkcnjksdhckjsdhjkvsdjvnkjdsbvjkdsvkjdshkhsdkfheklwjfbjkwegfwegfiuwekjfbewjkhfgwejyfguiwejfbwekhfgywegfkjewbhjfgewjfgewhjfjhewgf";

        System.out.println(reverseString(str));
    }

    private static String reverseString(String str){
        //CHECK THE INPUT
        if(str == null
                || str.length() <2){
            return "Hmm...that's not good";
        }
        //
        char [] array = str.toCharArray();
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
        return Arrays.toString(array);
    }

}
