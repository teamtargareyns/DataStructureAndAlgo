package com.test.aks.data_structure.interview_bit.linked_list;

public class PalindromeList {

    Node head;

    private int isPalindrome(Node head) {
        // slow advances once per itaration
        // fast advances twice per iteration
        // head is a pointer to the reversed first half of the list
        Node faster = head;
        Node slower = head;
        Node reverseHead = null;
        while (faster!=null){
            Node next = slower.next;
            faster = faster.next;
            if(faster!=null){
                faster = faster.next;
                slower.next = reverseHead;
                reverseHead = slower;
            }

            slower = next;
        }

        // slow is a pointer to the second half of the list
        // head is a pointer to the first half of the list (reversed)
        while (slower != null && reverseHead != null) {
            if (slower.value != reverseHead.value)
                return 0;
            slower = slower.next;
            reverseHead = reverseHead.next;
        }
        return 1;
    }

    public static void main(String[] args) {
        new PalindromeList().initProgram();
    }

    private void initProgram() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(2);
        Node n5 = new Node(1);
        //Node n6 = new Node(1);

        //init next pointer
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        //n6.next = null;
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
