package com.test.aks.data_structure.interview_bit.linked_list;

public class MergeTwoSortedLists {

    //
    ListNode headA;
    ListNode headB;

    private void mergeList(ListNode listA, ListNode listB) {
        ListNode currentA = listA;
        ListNode currentB = listB;
        ListNode prev = null;
        int counter = 0;
        while (currentA != null || currentB != null) {
            if (currentA == null) {
                while (currentB != null) {
                    prev.next = currentB;
                    currentB = currentB.next;
                }
                break;
            } else if (currentB == null) {
                while (currentA != null) {
                    //Nothing do here
                }
                break;
            } else if(currentA!=null && currentB!=null){
                int a = currentA.value;
                int b = currentB.value;
                if (a > b) {
                    //
                    counter++;
                    //
                    if (prev != null) {
                        prev.next = currentB;
                    }
                    prev.next = currentB.next;
                    //change head
                    if (counter == 1) {
                        headA = prev;
                    }
                    currentB.next = currentA;
                    //increment
                    currentB = prev.next;
                    prev = currentA;
                    currentA = currentA.next;
                } else {
                    prev = currentA;
                    currentA.next = currentB;
                    currentB = currentB.next;
                    currentB.next = prev.next;
                    prev = currentB;
                    //inc
                    currentA = prev.next;
                }
            }
        }

        printList(headA);
    }

    private void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedLists obj = new MergeTwoSortedLists();
        obj.initProgram();
        obj.callMergeMethod();
    }

    private void callMergeMethod() {
        mergeList(headA, headB);
    }

    private void initProgram() {
        //list 1
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(8);
        ListNode n3 = new ListNode(20);
        //list 2
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(11);
        ListNode n6 = new ListNode(15);
        ListNode n7 = new ListNode(16);

        //list 1
        n1.next = n2;
        n2.next = n3;
        n3.next = null;
        //list 2
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = null;
        //
        headA = n1;
        //
        headB = n4;
    }


    static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
