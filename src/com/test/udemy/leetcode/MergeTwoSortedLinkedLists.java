package com.test.udemy.leetcode;


/**
 * Leetcode - https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLinkedLists {
    static class Node {
        int value;
        Node next;

        Node(int val) {
            this.value = val;
            this.next = null;
        }
    }

    public Node mergeTwoLists(Node l1, Node l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        //
        if(l1.value < l2.value){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /*public Node mergeTwoListsOld(Node l1, Node l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        //
        if(l1.value < l2.value){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }*/
}
