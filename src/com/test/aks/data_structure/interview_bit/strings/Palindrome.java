package com.test.aks.data_structure.interview_bit.strings;

public class Palindrome {

    private static int checkPalindrome(String str) {
        //replace all special chars and white spaces from string
        str = str.toLowerCase();
        str = str.replaceAll(",", "");
        str = str.replaceAll(" ", "");
        str = str.replaceAll(":", "");

        //init start and end index
        int startingIndex = 0;
        int endingIndex = str.length()-1;

        // An empty string is
        // considered as palindrome
        if (str.length() == 0)
            return 1;

        // If there is only one character
        if (startingIndex == endingIndex)
            return 1;

        return isPalindrome(str, startingIndex, endingIndex);

    }

    private static int isPalindrome(String str,int startingIndex, int endingIndex) {

        System.out.println("startingIndex : "+startingIndex);
        System.out.println("endingIndex : "+endingIndex);
        System.out.println("--------------------------------");
        System.out.println("\n");

        if(str.charAt(startingIndex) != str.charAt(endingIndex))
            return 0;

        // If there are more than
        // two characters, check if
        // middle substring is also
        // palindrome or not.
        if (startingIndex < endingIndex+1)
            return isPalindrome(str, startingIndex + 1, endingIndex - 1);


        return 1;
    }

    public static void main(String[] args) {

        String str = "A man, a plan, a canal: Panama";
        str = str.toLowerCase();
        int res = checkPalindrome(str);

        if(res==0){
            System.out.println("String is not Palindrome");
            return;
        }

        System.out.println("Hurray...!!! String is Palindrome");
    }
}
