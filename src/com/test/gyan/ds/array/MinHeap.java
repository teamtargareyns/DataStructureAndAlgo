package com.test.gyan.ds.array;

public class MinHeap {
    private final int capacity;
    private final int[] heapArr;
    private int heapSize;

    public MinHeap(int capacity){
        this.capacity = capacity;
        this.heapArr = new int[capacity];
        this.heapSize = 0;
    }

    public int parentIndex(int i){
        return (i-1)/2;
    }
    public int leftIndex(int i){
        return (i*2)+1;
    }
    public int rightIndex(int i){
        return (i*2)+2;
    }

    public int getMinimumNode(){
        return heapArr[0];
    }


    public void insertNode(int value){
        if(heapSize == capacity){
            System.out.println("Heap overflow!!");
            return;
        }
        heapArr[heapSize++] = value;
        int i = heapSize-1;
        fixHeapPropertyIfVioletedAtUpward(i);
    }

    public void fixHeapPropertyIfVioletedAtUpward(int i){
        //fix minimum heap property if it is violated
        while(i !=0 && heapArr[parentIndex(i)] > heapArr[i]){
           // swap(heapArr[parentIndex(i)],heapArr[i]);
            heapArr[parentIndex(i)] = getItself(heapArr[i], heapArr[i] = heapArr[parentIndex(i)]);
            i = parentIndex(i);
        }
    }

    public void deleteNodeAtIndex(int i){
        decreaseNode(i,Integer.MIN_VALUE);
        extractMinNode();
    }

    public int extractMinNode(){
        if(heapSize <=0){
            return Integer.MAX_VALUE;
        }
        if(heapSize == 1){
            heapSize = 0;
            return heapArr[0];
        }
        int root = heapArr[0];
        heapArr[0] = heapArr[heapSize-1];
        heapSize--;
        minHeapifyAtDownward(0);
        return root;
    }

    public void minHeapifyAtDownward(int i){
        int l = leftIndex(i);
        int r = rightIndex(i);
        int smallest_value_index = i;

        if(l<heapSize && heapArr[l]<heapArr[smallest_value_index]){
            smallest_value_index = l;
        }
        if(r<heapSize && heapArr[r]<heapArr[smallest_value_index]){
            smallest_value_index = r;
        }
        if(smallest_value_index != i){
            //swap(heapArr[smallest_value_index],heapArr[i]);
            heapArr[smallest_value_index] = getItself(heapArr[i],heapArr[i] = heapArr[smallest_value_index]);
            minHeapifyAtDownward(smallest_value_index);
        }
    }

    public void decreaseNode(int i, int new_value){
        heapArr[i] = new_value;
        fixHeapPropertyIfVioletedAtUpward(i);
    }

    public void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }

    public static int getItself(int itself, int dummy)
    {
        return itself;
    }
    public void print() {
     printArray(heapArr);
    }

    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
