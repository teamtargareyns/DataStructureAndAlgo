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


    //2147483647 is the maximum integer value. The code is written to say the node must have a value less than whatever is passed as the max of the range, which is good because we want to be sure the same value isn't in the tree twice. However, any possible int value should be allowed, so setting the max to 2147483647 (Integer.MAX_VALUE)
    //at the start doesn't work because then we get a failure for a tree that has the value 2147483647.
    //If you use a long for the max and min that are passed around, you can use Long.MAX_VALUE instead (which will be larger)
    //as well as Long.MIN_VALUE. Alternatively, you can use an Integer instead of int and set the initial value to null,
    // then write some conditional logic that if max is set to null you don't need to do the comparison.
    public boolean isValidBST(Node node) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    //Basically what I am doing is recursively iterating over the tree while defining interval <minVal, maxVal> for each node which value must fit in.
    public boolean isValidBST(Node root, long minVal, long maxVal) {
        if (root == null) return true;

        if (root.value >= maxVal || root.value <= minVal) return false;

        return isValidBST(root.left, minVal, root.value) && isValidBST(root.right, root.value, maxVal);
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
        //System.out.println(tree.printBreathFirstSearch());
        tree.callPrintBreathFirstSearchRec();

        //validate a BST
        //System.out.println(tree.isValidBST(tree.root));
    }

}
