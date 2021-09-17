package com.test.udemy;

import java.util.HashMap;

/**
 * Link to solution - https://www.geeksforgeeks.org/design-a-data-structure-for-lru-cache/
 */

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    private HashMap<Integer, Node> map;
    private final int CACHE_SIZE;
    private Node head;
    private Node tail;

    LRUCache(int capacity) {
        CACHE_SIZE = capacity;
        map = new HashMap();
        //
        head = new Node(0, 0);
        tail = new Node(0, 0);
        //
        head.next = tail;
        tail.prev = head;
        //
        head.prev = null;
        tail.next = null;
    }

    private void deleteNode(Node node){
        //if node to be deleted is the first node
        if(head==node)
            head = node.next;
        //if node to be deleted is the last node
        if(tail==node)
            tail = node.prev;
        //boundary condition for start
        if(node.prev!=null)
            node.prev.next = node.next;
        //boundary condition for end
        if(node.next!=null)
            node.next.prev = node.prev;
    }

    private void addToHead(Node node){
        //these steps are very important below
        //don't consider head and tail as an actual node instead consider them as pointers to
        //first and the last nodes in the doubly linkedlist
        if(map.size()==0){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public Integer get(int key){
        if(map.containsKey(key)){
            Node node = map.get(key);
            int result = node.value;
            //delete from cache
            deleteNode(node);
            //now, add to cache
            addToHead(node);
            //return result
            return result;
        }

        //key doesn't exist
        return -1;
    }

    public void set(int key, int value){
        System.out.println("Going to set the (key, "
                + "value) : (" + key + ", "
                + value + ")");
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            //create node
            Node node = new Node(key, value);
            //add to map
            map.put(key, node);
            //check cache size
            if (map.size() < CACHE_SIZE) {
                addToHead(node);
            } else {
                //perform LRU eviction by removing tail item
                map.remove(tail.key);
                //delete from linkedlist
                deleteNode(tail);
                //now add to head
                addToHead(node);
            }
        }
    }

}
