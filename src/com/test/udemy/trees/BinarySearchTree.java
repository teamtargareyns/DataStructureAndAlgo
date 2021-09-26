package com.test.udemy.trees;


/**
 * Use visual go for understanding the tree traversal
 */
//TREE -
//        9
//   4          20
//1     6   15      170
public class BinarySearchTree {

    Node root = null;

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

    public Node getRoot(){
        return root;
    }

    public void insert(int value) {
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

    private boolean lookup(int value){
        //check empty root
        if(root == null) {
            return false;
        }
        //
        Node currentNode = root;
        while (currentNode!=null){
            if(value < currentNode.value){
                currentNode = currentNode.left;
            } else if(value > currentNode.value){
                currentNode = currentNode.right;
            }else if(currentNode.value == value){
                return true;
            }
        }
        return false;
    }

    public void printPostorder(Node node) {
        //always have the base case first to break recusion and avoid stack over flow
        if (node == null)
            return;

        // first recur on left subtree
        printPostorder(node.left);

        // then recur on right subtree
        printPostorder(node.right);

        // now deal with the node
        System.out.print(node.value + " ");
    }

    /* Given a binary tree, print its nodes in inorder*/
    public void printInorder(Node node) {
        //always have the base case first to break recursion and avoid stack over flow
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.value + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    /* Given a binary tree, print its nodes in preorder*/
    public void printPreorder(Node node) {
        //always have the base case first to break recusion and avoid stack over flow
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.value + " ");

        /* then recur on left sutree */
        printPreorder(node.left);

        /* now recur on right subtree */
        printPreorder(node.right);
    }

    public static void main(String[] args) {
        //create 1st node
        BinarySearchTree tree = new BinarySearchTree();
        //
        tree.insert(9);
        tree.insert(4);
        tree.insert(6);
        tree.insert(20);
        tree.insert(170);
        tree.insert(15);
        tree.insert(1);
        //lookup
        //System.out.println(tree.lookup(170));

        //print
        //System.out.println("printInorder");
        //tree.printInorder(tree.root);

        //System.out.println("\n\nprintPreorder");
        //tree.printPreorder(tree.root);

        //System.out.println("\n\nprintPostorder");
        //tree.printPostorder(tree.root);
    }


}
