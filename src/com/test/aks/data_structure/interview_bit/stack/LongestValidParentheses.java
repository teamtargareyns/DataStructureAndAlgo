package com.test.aks.data_structure.interview_bit.stack;

import java.util.Stack;

public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }


    public static void main(String[] args) {
        //String str = "))))())()()((((()()()(()(((((())()";
        String str = "((()))";
        //int[] arr = {33333333, 30, 34, 5, 9};
        //int[] arr = {9, 99, 999, 9999, 9998 };
        //int[] arr = {0, 0, 0, 0, 00000 };
        //int[] arr = {0};
        System.out.println(longestValidParentheses(str));
    }

}
