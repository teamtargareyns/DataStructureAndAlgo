package com.test.aks.data_structure.interview_bit.stack;

import java.util.Stack;

/**
 * Rules:
 * 1.)  If immediate pop hits a open parenthesis ‘(‘, then we have found a duplicate parenthesis.
 * For example, (((a+b))+c) has duplicate brackets around a+b. When we reach second “)” after a+b, we have “((” in the stack. Since the top of stack is a opening bracket,
 * we conclude that there are duplicate brackets.
 *
 *
 *
 * 2.) If immediate pop doesn’t hit any operand(‘*’, ‘+’, ‘/’, ‘-‘) then it indicates the presence of unwanted brackets surrounded by expression.
 * For instance, (a)+b contain unwanted () around a thus it is redundant.
 */

public class RedundantBraces {

    public static int braces(String str) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < str.length(); i++) {
            Character chr = str.charAt(i);
            if(chr == '(' || chr == '+' || chr == '-' || chr == '*' || chr == '/') {
                stack.push(chr);
            } else if (chr == ')') {
                boolean isPopped = false;
                while(stack.peek() != '(') {
                    isPopped = true;
                    stack.pop();
                }
                if(!isPopped) return 1;
                stack.pop();
            }
        }

        return 0;
    }


    public static void main(String[] args) {
        String str = "((a+b))";
        braces(str);

        str = "(a+(b)/c)";
        braces(str);

        str = "(a+b*(c-d))";
        braces(str);
    }
}
