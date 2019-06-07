package com.test.aks.data_structure.interview_bit.strings;

public class LengthOfLastWord {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static int lengthOfLastWord(final String str) {
        String localStr = str;
        int size = str.length();
        if(size==0){
            return 0;
        }

        //trim leading and trailing spaces
        //ASCII VALUE OF SPACE - 32
        localStr = localStr.trim();
        int count=0;
        for(int i=localStr.length()-1; i>=0; i--){
            if(localStr.charAt(i) != 32){
                count++;
                continue;
            }else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String myString = "Hello World";
        int result = lengthOfLastWord(myString);
        System.out.println(result);
    }
}
