package com.test.aks.data_structure.interview_bit.linked_list;

public class PalindromeList {

    Node head;

    private int isPalindrome(Node head) {
        //slower and faster
        //move faster pointer two times and then move slower pointer only one time
        if (head.next == null) {
            return 0;
        }

        Node faster = head.next;
        Node slower = head;

        //reverse list
        Node reverseHead = reverseList(head);
        return checkPalindromeUtil(head, reverseHead, faster, slower);
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
        Node current = head;
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
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(2);
        Node n6 = new Node(1);

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

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

       /* public Node(Node head) {
            if (head != null) {
                this.value = head.value;
                this.next = new Node(head.next);
            }
        }*/
    }

}
