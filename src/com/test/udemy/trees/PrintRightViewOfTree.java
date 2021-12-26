package com.test.udemy.trees;

import com.test.udemy.trees.bfs_dfs.BreathFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * Printing the right view of the binary search tree
 * link to problem -
 * 1.https://www.geeksforgeeks.org/print-right-view-binary-tree-2/
 * 2.https://leetcode.com/problems/binary-tree-right-side-view/submissions/
 */
public class PrintRightViewOfTree {

    List<Integer> list = new ArrayList();
    MaxLevel mxLvl = new MaxLevel(0);

    //
    Node root = null;
    Queue<Node> queue = new LinkedList<>();

    //
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

    //
    static class MaxLevel {
        int maxLevelSoFar;
        MaxLevel(int initalValue) {
            this.maxLevelSoFar = initalValue;
        }
    }

    private void insert(int value) {
        Node newNode = new Node(value);
        //check if root node is empty
        if (root == null) {
            root = newNode;
        } else {
            //root node is not empty
            Node currentNode = root;
            while (true) {
                if (value < currentNode.value) {
                    //LEFT NODE
                    //the above if block will execute if the value is
                    //less than currentNode. initially root node.
                    if (currentNode.left == null) {
                        currentNode.left = newNode;
                        return;
                    }
                    //else keep traversing through the left node of the current node
                    currentNode = currentNode.left;
                } else {
                    //RIGHT NODE
                    if (currentNode.right == null) {
                        currentNode.right = newNode;
                        return;
                    }
                    //else keep traversing through the right node of the current node
                    currentNode = currentNode.right;
                }
            }
        }
    }


    private List<Integer> printRightViewOfBinaryTree(Node root) {
        //list.addAll(rightViewUtil(root, 1, mxLvl));
        rightViewUtil(root, 1, mxLvl);
        //System.out.println("maxLength = "+mxLvl.maxLevelSoFar);
        return list;
    }

    // Recursive function to print right view of a binary tree.
    private void rightViewUtil(Node node, int level, MaxLevel maxLevel) {
        // Base Case
        if (node == null)
            return;

        // If this is the last Node of its level
        if (maxLevel.maxLevelSoFar < level) {
            list.add(node.value);
            maxLevel.maxLevelSoFar = level;
        }

        // Recur for right subtree first, then left subtree
        rightViewUtil(node.right, level + 1, maxLevel);
        rightViewUtil(node.left, level + 1, maxLevel);
    }

    public static void main(String[] args) {
        //create 1st node
        BreathFirstSearch tree = new BreathFirstSearch();
        //inputs
        //[1,2,3,null,5,null,4]
        //[1,null,3]
        //[]
        /*tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(null);
        tree.insert(5);
        tree.insert(null);
        tree.insert(4);*/
    }
}



