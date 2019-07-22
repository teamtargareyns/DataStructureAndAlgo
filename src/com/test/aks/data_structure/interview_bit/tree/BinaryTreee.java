package com.test.aks.data_structure.interview_bit.tree;

public class BinaryTreee {

    Node root;

    BinaryTreee(int data) {
        root = new Node(data);
    }

    BinaryTreee() {
    }

    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(Node node) {
        if (node == null)
            //root node is null i.e. tree is empty
            return;

        /* first print data of node */
        System.out.print(node.data + " ");

        /* then recur on left sutree */
        printPreorder(node.leftChild);

        /* now recur on right subtree */
        printPreorder(node.rightChild);
    }

    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(Node node) {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.leftChild);

        /* then print the data of node */
        System.out.print(node.data + " ");

        /* now recur on right child */
        printInorder(node.rightChild);
    }

    /* Given a binary tree, print its nodes according to the
     "bottom-up" postorder traversal. */
    void printPostorder(Node node) {
        if (node == null)
            return;

        // first recur on left subtree
        printPostorder(node.leftChild);

        // then recur on right subtree
        printPostorder(node.rightChild);

        // now deal with the node
        System.out.print(node.data + " ");
    }

    // Wrappers over above recursive functions
    void printPostorder() {
        printPostorder(root);
    }

    void printInorder() {
        printInorder(root);
    }

    void printPreorder() {
        printPreorder(root);
    }

    public static void main(String[] args) {
        //create tree and root
        BinaryTreee tree = new BinaryTreee(1);

        //create left and right child
        tree.root.leftChild = new Node(2);
        tree.root.rightChild = new Node(3);
        tree.root.leftChild.leftChild = new Node(4);
        tree.root.leftChild.rightChild = new Node(5);

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder();

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder();

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder();
    }


}

class Node {
    int data;
    Node leftChild = null;
    Node rightChild = null;

    Node(int item) {
        data = item;
    }
}
