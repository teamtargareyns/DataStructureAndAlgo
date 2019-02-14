package com.test.app.grab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestOne {

    public int solution(int[] a, int k, int l){
        int totalOfKAndL = 0;

        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        int[] maxAndStartingIndex = getMaxContiguosFromArray(list, k);
        totalOfKAndL+=maxAndStartingIndex[0];
        System.out.println(maxAndStartingIndex[0]);
        int[] leadingElements = Arrays.copyOfRange(a, 0, maxAndStartingIndex[1]);
        int[] trailingElements = Arrays.copyOfRange(a, (maxAndStartingIndex[1]+k), a.length);

        List<Integer> mergedLeadingAndTrailingElements = new ArrayList(Arrays.asList(leadingElements));
        //mergedLeadingAndTrailingElements.addAll(Arrays.asList(trailingElements));
        mergedLeadingAndTrailingElements.addAll(Arrays.asList(Arrays.stream( trailingElements ).boxed().toArray( Integer[]::new )));
        Integer[] mergedLeadingAndTrailingElementsArray =  mergedLeadingAndTrailingElements.toArray(new Integer[0]);

        maxAndStartingIndex = getMaxContiguosFromArray(Arrays.asList(mergedLeadingAndTrailingElementsArray), l);
        System.out.println(maxAndStartingIndex[0]);
        totalOfKAndL+=maxAndStartingIndex[0];
        System.out.println(totalOfKAndL);
        return totalOfKAndL;
    }

    static int[] getMaxContiguosFromArray(List<Integer> a, int numberOrElements){
        int sumForFirst = 0;
        int sumForFirstPrev = 0;
        int startingIndexForK = 0;
        int[] maxAndStartingIndex = new int[2];
        for(int i = 0; i < a.size(); i++){
            if(i <= a.size() - numberOrElements) {
                for (int j = i; j < i + numberOrElements; j++) {
                    sumForFirst += a.get(i);
                }
            }

            if(sumForFirst >  sumForFirstPrev) {
                sumForFirstPrev = sumForFirst;
                startingIndexForK = i;

            }
            sumForFirst = 0;
        }
        maxAndStartingIndex[0] = sumForFirstPrev;
        maxAndStartingIndex[1] = startingIndexForK;
        return maxAndStartingIndex;
    }

    public static void main(String[] args) {
        int a[] = {6, 1, 3, 4, 5, 6, 8, 2, 7};
        new TestOne().solution(a, 3,2);

    }
}