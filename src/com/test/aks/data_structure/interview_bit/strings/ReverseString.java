package com.test.aks.data_structure.interview_bit.strings;

public class ReverseString {

    private static String reverseString(String str) {
        //trim leading and trailing space
        str = str.trim();
        String[] strArr = str.split("\\s");
        String newString = "";
        for (int i = strArr.length - 1; i >= 0; i--) {
            newString = newString.concat(strArr[i]);
            if(i>0){
                newString = newString.concat(" ");
            }
        }
        return newString;
    }

    public static void main(String[] args) {
        String str = "My name is Aakash";
        System.out.println(reverseString(str));
    }
}
