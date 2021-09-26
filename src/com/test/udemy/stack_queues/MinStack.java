package com.test.udemy.stack_queues;

import java.util.Stack;


/**
 * GeeksForGeeks - https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
 */
public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack();
        minStack = new Stack();
    }

    public void push(int element) {
        stack.push(element);
        if (minStack.isEmpty()) {
            minStack.push(element);
        } else if (minStack.peek() >= element) {
            minStack.push(element);
        }
    }

    public void pop(){
        int poppedElement = stack.pop();
        if(!minStack.isEmpty() && minStack.peek() == poppedElement){
            minStack.pop();
        }
    }

    public int getMin(){
        return minStack.peek();
    }
}

