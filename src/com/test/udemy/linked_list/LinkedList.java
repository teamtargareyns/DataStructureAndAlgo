package com.test.udemy.linked_list;

public class LinkedList {

    Node head = null;
    Node tail = null;

    static class Node {
        int value;
        Node next;

        Node(int val) {
            this.value = val;
            this.next = null;
        }
    }

    private void append(int value) {
        Node newNode = new Node(value);
        //check if head is null, it means it is the first node
        if (head == null) {
            head = newNode;
            //also set the tail as head as this is the first node
            tail = newNode;
            return;
        }

        //append the node to the end of the LL
        tail.next = newNode;
        tail = newNode;
    }

    public Node mergeTwoLists(Node l1, Node l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.value < l2.value){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        //create 1st node
        LinkedList list = new LinkedList();
        //
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);
        //
        printList(list);
    }

    // Method to print the LinkedList.
    public static void printList(LinkedList list) {
        Node currNode = list.head;
        //
        System.out.print("LinkedList: ");
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.value + " ");
            // Go to next node
            currNode = currNode.next;
        }
    }

}
