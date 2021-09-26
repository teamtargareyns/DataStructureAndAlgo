package com.test.udemy.leetcode;

/**
 * Leetcode - https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {

    static class Node {
        int value;
        Node next;

        Node(int val) {
            this.value = val;
            this.next = null;
        }
    }

    public boolean hasCycle(Node head) {
        if(head == null) return false;

        //
        Node slow = head;
        Node fast = head.next;

        //
        while(slow != fast){
            if(fast == null || fast.next == null){
                return false;
            }

            //increment pointers
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
