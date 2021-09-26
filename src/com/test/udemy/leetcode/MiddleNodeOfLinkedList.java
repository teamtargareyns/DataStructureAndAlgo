package com.test.udemy.leetcode;

public class MiddleNodeOfLinkedList {

    static class Node {
        int value;
        Node next;

        Node(int val) {
            this.value = val;
            this.next = null;
        }
    }

    public Node middleNodeOfList(Node head) {
        // both pointers set to head initially
        Node slow = head, fast = head;

        // iterate until fast is at last node or become null
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
