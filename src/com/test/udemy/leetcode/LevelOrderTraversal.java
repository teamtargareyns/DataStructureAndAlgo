package com.test.udemy.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Leetcode - https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class LevelOrderTraversal {

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

    public List<List<Integer>> levelOrder(Node root) {
        Node currentNode;
        Queue<Node> queue = new LinkedList();
        List<List<Integer>> resultList = new ArrayList();
        List<Integer> subList = null;
        //check if root is null
        if(root == null) return resultList;
        //add root to queue
        queue.offer(root);
        //loop through queue
        while(!queue.isEmpty()){
            //read level from queue current size
            int level = queue.size();
            //initialize a sub list
            subList = new ArrayList();
            for(int i=0; i<=level; i++){
                //read current node from queue
                currentNode = queue.poll();
                //check for it's left and right child
                if(currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
                //add current node to the sub list
                subList.add(currentNode.value);
            }
            resultList.add(subList);
        }

        return resultList;
    }

}
