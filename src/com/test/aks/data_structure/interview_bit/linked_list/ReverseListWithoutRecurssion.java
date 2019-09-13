package com.test.aks.data_structure.interview_bit.linked_list;

public class ReverseListWithoutRecurssion {

    Node head;

    private PalindromeList.Node reverseList(PalindromeList.Node head) {
        PalindromeList.Node prev = null;
        PalindromeList.Node current = head;
        PalindromeList.Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        return head;

        //return prev;
    }

    public static void main(String[] args) {
        new ReverseListWithoutRecurssion().initProgram();
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

    }


    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
