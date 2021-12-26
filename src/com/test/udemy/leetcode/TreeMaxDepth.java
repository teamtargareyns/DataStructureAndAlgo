package com.test.udemy.leetcode;


import com.test.udemy.trees.ZigzagTreeTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Leetcode - https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */

public class TreeMaxDepth {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int val) {
            this.value = val;
            this.left = null;
            this.right = null;
        }
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
