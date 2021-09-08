package com.test.udemy.trees.bfs_dfs;

import com.test.udemy.trees.BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TREE STRUCTURE-
 * 9
 * 4          20
 * 1     6   15      170
 */

public class BreathFirstSearch {

    Node root = null;
    Queue<Node> queue = new LinkedList<>();
    List<Integer> list = new ArrayList<>();

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

    private List<Integer> printBreathFirstSearch() {
        Node currentNode;
        queue.add(root);
        //
        while (queue.size() > 0) {
            currentNode = queue.poll();//4,5,6,7,3
            System.out.println(currentNode.value);
            list.add(currentNode.value);

            //check if the current node has the left child node
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            //check if the current node has the right child node
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }

        return list;
    }

    //V.Imp
    //This function always reads 2 elements from the queue at a time and pass the queue to function
    private List<Integer> printBreathFirstSearchRec(Queue<Node> queue, List<Integer> list) {
        if (queue.isEmpty()) {
            return list;
        }

        //poll the front of the queue
        Node currentNode = queue.poll();
        System.out.println(currentNode.value);
        list.add(currentNode.value);

        //check if the current node has the left child node
        if (currentNode.left != null) {
            queue.add(currentNode.left);
        }

        //check if the current node has the right child node
        if (currentNode.right != null) {
            queue.add(currentNode.right);
        }

        return printBreathFirstSearchRec(queue, list);
    }

    private void callPrintBreathFirstSearchRec() {
        queue.add(root);
        System.out.println(printBreathFirstSearchRec(queue, new LinkedList()));
    }

    //            5
    //      4           6
    //              3       7
    public boolean isValidBST(Node node) {
        if (node == null)
            return true;

        if(node.left != null && node.left.value > node.value)
            return false;

        if(node.right != null && node.right.value < node.value)
            return false;

        return (!isValidBST(node.left) || !isValidBST(node.right));

    }


    public static void main(String[] args) {
        //create 1st node
        BreathFirstSearch tree = new BreathFirstSearch();
        //FOR BFS TRAVERSAL
        /*tree.insert(9);
        tree.insert(4);
        tree.insert(6);
        tree.insert(20);
        tree.insert(170);
        tree.insert(15);
        tree.insert(1);*/

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(15);
        tree.insert(1);

        //[5,4,6,null,null,3,7]
        /*tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        tree.insert(3);
        tree.insert(7);*/

        //BFS Traversal
        System.out.println(tree.printBreathFirstSearch());
        //tree.callPrintBreathFirstSearchRec();

        //validate a BST
        //System.out.println(tree.isValidBST(tree.root));
    }

}
