package com.test.udemy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList();
        for (int i=1; i<=n; i++){
            //check for divisible by 3 & 5
            if(i%3 == 0 && i%5 ==0){
                answer.add("FizzBuzz");
                continue;
            }

            //check for divisible by 3
            if(i%3 == 0){
                answer.add("Fizz");
                continue;
            }

            //check for divisible by 5
            if(i%5 ==0){
                answer.add("Buzz");
                continue;
            }

            //else
            answer.add(String.valueOf(i));
        }

        return answer;
    }



    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.fizzBuzz(3));
        //will return 0 if less than divisor
        System.out.println(0/3);
        System.out.println(1/3);
        //will return same number if less than divisor
        System.out.println(0%3);
        System.out.println(1%3);
    }
}
