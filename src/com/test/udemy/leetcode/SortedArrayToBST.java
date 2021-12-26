package com.test.udemy.leetcode;

public class SortedArrayToBST {

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.value = val;
            this.left = null;
            this.right = null;
        }
    }

    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }
        TreeNode root = helper(num, 0, num.length - 1);
        return root;
    }

    public TreeNode helper(int[] num, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = (low + high) / 2;
        int value = num[mid];
        //
        TreeNode node = new TreeNode(value);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }
}
