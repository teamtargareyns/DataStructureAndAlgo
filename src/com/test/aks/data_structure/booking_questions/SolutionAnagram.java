package com.test.aks.data_structure.booking_questions;

import java.util.*;

public class SolutionAnagram {

    public static void main(String[] input) {
        List<String> words = new ArrayList<>();
        List<String> anagramWords = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            words.add(scanner.nextLine());
        }
        //close input stream
        scanner.close();

       /* String[] arr = new String[]{"pear",
                "amleth",
                "dormitory",
                "tinsel",
                "dirty room",
                "hamlet",
                "listen",
                "silnet"};

        words.addAll(Arrays.asList(arr));*/

        //
        String builderString = "";
        String str1 = "", actualStr1 = "";
        String str2 = "", actualStr2 = "";
        int length = Integer.MIN_VALUE, k = -Integer.MIN_VALUE, l = Integer.MIN_VALUE;
        boolean found = Boolean.FALSE;
        boolean not_found = Boolean.FALSE;
        //
        for (int i = 0; i < words.size(); i++) {
            builderString = "";
            for (int j = i + 1; j < words.size(); j++) {
                //reset flag
                //not_found = false;
                actualStr1 = words.get(i);
                str1 = words.get(i).replaceAll("\\s", "");
                actualStr2 = words.get(j);
                str2 = words.get(j).replaceAll("\\s", "");
                length = str1.length() == str2.length() ? str1.length() : -1;
                //
                if (str1.length() == str2.length()) {

                    for (k = 0; k < length; k++) {
                        found = false;
                        for (l = 0; l < length; l++) {
                            str1 = str1.toLowerCase();
                            str2 = str2.toLowerCase();
                            //32 - ASCII VALUE OF SPACE

                            //if char is space increment pointer
                            if (str1.charAt(k) == 32) {
                                k++;
                            }

                            //if char is space increment pointer
                            if (str2.charAt(l) == 32) {
                                l++;
                            }


                            if (str1.charAt(k) == str2.charAt(l)) {
                                found = true;
                                break;
                            }
                        }
                        if (found == false) {
                            not_found = true;
                            break;
                        }
                    }


                    if (found) {
                        //Strings matched
                        if (builderString.isEmpty()) {
                            String res = isSubStringExist(anagramWords, str1, str2);
                            if (null == res) {
                                builderString = actualStr1 + "," + actualStr2;
                            } else if (res.isEmpty()) {
                                builderString = "";
                            } else {
                                builderString = res;
                            }
                        } else {
                            builderString = builderString + "," + actualStr2;
                        }

                        //sort strings
                        builderString = sortBuilderString(builderString);
                    }

                }

            }

            if (!not_found && found == false) {
                //This space is intensionally left blank
                //System.out.print("Strings are not Anagram to Each Other..!!");
                anagramWords.add(actualStr1);
            } else {
                if (!builderString.isEmpty()) anagramWords.add(builderString);
            }

            //reset flag
            not_found = false;
        }

        //
        Collections.sort(anagramWords);

        //print
        for (String str : anagramWords) {
            System.out.println(str);
            System.out.println("\n");
        }
    }

    private static String sortBuilderString(String builerString) {

        String[] arr = builerString.split(",");
        List<String> tempList = new ArrayList<>();
        tempList.addAll(Arrays.asList(arr));
        Collections.sort(tempList);

        String sortedString = "";

        for (int i = 0; i < tempList.size(); i++) {
            if (i < tempList.size()-1) {
                if (sortedString.isEmpty()) {
                    sortedString = tempList.get(i) + ",";
                } else {
                    sortedString = sortedString + tempList.get(i) + ",";
                }
            } else {
                sortedString = sortedString + tempList.get(i);
            }
        }

        return sortedString;
    }


    private static String isSubStringExist(List<String> anagramWords, String str1, String str2) {
        String builderText = "";
        String temp = "";
        for (int i = 0; i < anagramWords.size(); i++) {
            if (anagramWords.get(i).contains(str1) && anagramWords.get(i).contains(str2)) {
                return "";
            } else if (anagramWords.get(i).contains(str1)) {
                temp = anagramWords.get(i);
                builderText = temp + "," + str2;
                return builderText;
            } else if (anagramWords.get(i).contains(str2)) {
                temp = anagramWords.get(i);
                builderText = temp + "," + str1;
                return builderText;
            }
        }

        return null;
    }
}
