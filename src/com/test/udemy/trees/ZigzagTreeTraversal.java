package com.test.udemy.trees;

import java.util.*;

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

    public List<List<Integer>> zigzagTraversalUsingQueue(Node root) {

        List<List<Integer>> answer = new ArrayList<List<Integer>>();

        if(root == null) return answer;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean flag = true;

        while(!q.isEmpty()) {

            int count = q.size();
            List<Integer> temp = new ArrayList<>();

            while(count-- >0) {

                Node front = q.poll();

                if(flag) temp.add(front.value);
                else temp.add(0,front.value);

                if(front.left != null) q.add(front.left);
                if(front.right != null) q.add(front.right);
            }

            answer.add(temp);

            if(flag) flag = false;
            else flag = true;
        }

        return answer;
    }


    public List<List<Integer>> zigzagTraversalUsingStacks(Node root) {

        List<List<Integer>> answer = new ArrayList<List<Integer>>();

        if(root == null) return answer;

        Stack<Node> first = new Stack<>();
        Stack<Node> second = new Stack<>();

        first.push(root);

        while(!first.empty()){

            List<Integer> temp = new ArrayList<>();

            while(!first.empty()){

                Node a = first.pop();
                temp.add(a.value);
                if(a.left != null) second.push(a.left);
                if(a.right != null) second.push(a.right);
            }

            answer.add(temp);

            if(second.empty()) return answer;

            temp = new ArrayList<>();

            while(!second.empty()){

                Node b = second.pop();
                temp.add(b.value);
                if(b.right != null) first.push(b.right);
                if(b.left != null) first.push(b.left);
            }

            answer.add(temp);
        }

        return answer;
    }

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
