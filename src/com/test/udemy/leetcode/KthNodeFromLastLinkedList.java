package com.test.udemy.leetcode;

public class KthNodeFromLastLinkedList {

    static class Node {
        int value;
        Node next;

        Node(int val) {
            this.value = val;
            this.next = null;
        }
    }

    public Node kthNodeFromLast(Node head, int kthNodeFromLast) {
        // both pointers set to head initially
        Node slow = head, fast = head;
        // move the fast pointer k nodes from slow.
        while(kthNodeFromLast > 0) {
            fast = fast.next;
            kthNodeFromLast--;
        }

        // iterate until fast is at last node or become null
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
