package com.test.udemy.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagTreeTraversal {

    Node root = null;
    List<Integer> list = new ArrayList();
    Queue<Node> queue = new LinkedList<>();

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


    //use two stacks and one list to return the result
    /*private List<Integer> printZigZagTree(Queue<Node> queue, List<Integer> list) {

    }*/

    public static void main(String[] args) {
        //create 1st node
        ZigzagTreeTraversal tree = new ZigzagTreeTraversal();
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
