package com.test.aks.data_structure.interview_bit.linked_list;

public class PalindromeList {

    Node head;

    private int isPalindrome(Node head) {
        //slower and faster
        //move faster pointer two times and then move slower pointer only one time
        if (head.next == null) {
            return 0;
        }

        Node newHead = new Node(head.value, head.next);
        Node faster = head.next;
        Node slower = head;

        //reverse list
        Node reverseHead = reverseList(newHead);
        return checkPalindromeUtil(newHead, reverseHead, faster, slower);
    }

    private int checkPalindromeUtil(Node head, Node reverseHead, Node faster, Node slower) {
        int val1 = head.value;
        int val2 = reverseHead.value;
        //
        if (val1 != val2) {
            return 0;
        }

        //increase faster and slower pointer
        if (faster.next == null || faster.next.next == null) {
            return 1;
        } else {
            faster = faster.next.next;
            slower = slower.next;
        }


        // If there are more than
        // two characters, check if
        // middle substring is also
        // palindrome or not.
        if (faster.next != null) {
            return checkPalindromeUtil(head.next, reverseHead.next, faster, slower);
        }
        return 1;
    }

    private Node reverseList(Node head) {
        Node prev = null;
        Node current = new Node(head.value, head.next);
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        /*head = prev;
        return head;*/

        return prev;
    }

    public static void main(String[] args) {
        new PalindromeList().initProgram();
    }

    private void initProgram() {
        Node n1 = new Node(1, null);
        Node n2 = new Node(2, null);
        Node n3 = new Node(3, null);
        Node n4 = new Node(4, null);
        Node n5 = new Node(2, null);
        Node n6 = new Node(1, null);

        //init next pointer
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;
        //
        head = n1;

        System.out.println(isPalindrome(head));
    }


    static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
