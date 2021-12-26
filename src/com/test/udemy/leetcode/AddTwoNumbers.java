package com.test.udemy.leetcode;

/**
 * Leetcode = https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    static class ListNode {
        int value;
        ListNode next;

        ListNode(int val) {
            this.value = val;
            this.next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode currentNode = dummy;

        ListNode curr1 = l1;
        ListNode curr2 = l2;
        int carry = 0;
        //
        while(curr1!=null || curr2!=null || carry!=0){
            int num1 = curr1.value == 0 ? 0 : curr1.value;
            int num2 = curr2.value == 0 ? 0 : curr2.value;
            //
            int sum = num1 + num2 + carry;
            //calculating reminder
            int newNum = sum%10;
            //calculating divisor
            carry = sum/10;
            //
            currentNode.next = new ListNode(newNum);
            currentNode = currentNode.next;
            //
            curr1 = curr1 == null ? null : curr1.next;
            curr2 = curr2 == null ? null : curr2.next;
        }

        //return next node as head of the list as the first node was -1;
        return dummy.next;
    }
}
