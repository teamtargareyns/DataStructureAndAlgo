package com.test.aks.data_structure.interview_bit.stack;

import java.util.ArrayList;
import java.util.List;

public class GetMinFromStack {

    List<Integer> stack = new ArrayList<>();
    Integer minOfStack = -1;

    void push(int item) {
        stack.add(item);
        updateMinOfStack(item);
    }

    int pop() {
        if (stack.size() == 0) {
            return -1;
        }
        System.out.println("Popping stack now");
        int deletingItem = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        System.out.println("Deleting item : " + deletingItem);
        return deletingItem;
    }

    void updateMinOfStack(int item) {
        if (minOfStack == -1 || item < minOfStack) {
            minOfStack = item;
        }
    }

    void printStack() {
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }
        System.out.println("\n");
    }

    Integer getMin() {
        return minOfStack;
    }

    public static void main(String[] args) {
        GetMinFromStack caller = new GetMinFromStack();
        caller.push(3);
        caller.push(4);
        caller.push(5);
        caller.push(6);
        caller.push(2);

        //print stack
        caller.printStack();

        //pop
        caller.pop();

        //print stack
        caller.printStack();
    }
}
