package com.test.aks.data_structure.interview_bit.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ValidIpAddress {

    public static void main(String[] args) {
        String ipSample = "25525511135";
        List<String> result = restoreIpAddresses(ipSample);
        System.out.println(result);
    }

    private static List<String> restoreIpAddresses(String str) {
        if (str.length() < 3 || str.length() > 12)
            return new ArrayList<>();
        return convert(str);
    }

    private static ArrayList<String> convert(String str) {
        ArrayList<String> ipAddList = new ArrayList<>();
        int size = str.length();
        String snew = str;

        for (int i = 1; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {
                    snew = snew.substring(0, k) +
                            "." + snew.substring(k);
                    snew = snew.substring(0, j) +
                            "." + snew.substring(j);
                    snew = snew.substring(0, i) +
                            "." + snew.substring(i);

                    if (isValid(snew)) {
                        ipAddList.add(snew);
                    }
                    snew = str;
                }
            }
        }

        //compare two objects and return
        Collections.sort(ipAddList, new Comparator<String>() {
            public int compare(String o1, String o2) {
                String a1[] = o1.split("[.]");
                String a2[] = o2.split("[.]");

                int result = -1;
                for (int i = 0; i <= 3 && result != 0; i++) {
                    System.out.println("result-bfr : "+result);
                    result = a1[i].compareTo(a2[i]);
                    System.out.println("result-aftr : "+result);
                }
                return result;
            }
        });

        return ipAddList;

    }

    private static boolean isValid(String ip) {
        String a[] = ip.split("[.]");
        for (String s : a) {
            int i = Integer.parseInt(s);
            //chk length
            if (s.length() > 3 || i < 0 || i > 255) {
                return false;
            }

            //chk for zero at the begining of ip
            if (s.length() > 1 && i == 0)
                return false;

            //chek for zero at the begining of any section of IP address
            if (s.length() > 1 && i != 0 &&
                    s.charAt(0) == '0')
                return false;
        }

        return true;
    }

}
