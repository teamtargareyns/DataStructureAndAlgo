package com.test.aks.data_structure.interview_bit.strings;

import java.math.BigInteger;

public class CompareVersion {

    private final static Integer GREATER = 1;
    private final static Integer SMALLER = -1;
    private final static Integer EQUAL = 0;

    private static int compareVersion(String versionA, String versionB) {
        Integer finalResultValue = 0;
        String valA = "";
        String valB = "";
        String[] versionA_arr = versionA.split("\\.");
        String[] versionB_arr = versionB.split("\\.");
        int smallerArrLen = 0;


        if (versionA_arr.length < versionB_arr.length) {
            smallerArrLen = versionA_arr.length;
        } else {
            smallerArrLen = versionB_arr.length;
        }

        for (int i = 0; i < smallerArrLen; i++) {
            valA = versionA_arr[i];
            valB = versionB_arr[i];

            //CHECK FOR CORNER CASE SCENARIO SUCH AS 01 and 1
            //should be equal
            //remove leading zero from string using regex
            valA = valA.replaceFirst("^0+(?!$)", "");
            valB = valB.replaceFirst("^0+(?!$)", "");

            if (valA.length() > valB.length()) {
                return 1;
            } else if (valA.length() < valB.length()) {
                return -1;
            } else {
                for (int j = 0; j < valA.length(); j++) {
                    Integer result = compareUtil(valA.charAt(j), valB.charAt(j));
                    //System.out.println("result : " + result);
                    //System.out.println("\n");
                    if (result == GREATER) {
                        finalResultValue = 1;
                        return 1;
                    } else if (result == SMALLER) {
                        finalResultValue = -1;
                        return -1;
                    } else if (result == EQUAL) {
                        finalResultValue = 0;
                        continue;
                    }
                }
            }
        }

        //further check for length of versions if they are equal
        //48 - ASCII VALUE OF ZERO
        if (finalResultValue == 0 && versionA_arr.length > versionB_arr.length
                && versionA_arr[smallerArrLen].charAt(0) > 48) {
            return 1;
        } else if (finalResultValue == 0
                && versionA_arr.length < versionB_arr.length
                && versionB_arr[smallerArrLen].charAt(0) > 48) {
            return -1;
        } else {
            return 0;
        }
    }

    private static Integer compareUtil(char a, char b) {
        if (a > b) {
            return 1;
        } else if (a < b) {
            return -1;
        } else {
            return 0;
        }

    }

    /*private static Integer compareUtil(String a, String b) {
        BigInteger intA = new BigInteger(a);
        BigInteger intB = new BigInteger(b);
        int res = intA.compareTo(intB);
        return res;
    }*/

    public static void main(String[] args) {
        String versionA = "4753.8";
        String versionB = "4359.29";

         /*String versionA = "1.0";
        String versionB = "1";*/


         /*String versionA = "01";
        String versionB = "1";*/

        /*String versionA = "444444444444444444444444";
        String versionB = "4444444444444444444444444";*/

        /*String versionA = "4444371174137455";
        String versionB = "5.168";*/

        /**
         * A : "4444371174137455"
         * B : "5.168"
         */

        /*String versionA = "1.5.20";
        String versionB = "1.5.20.26";*/
        System.out.println("Method_return_value : " + compareVersion(versionA, versionB));
    }
}
