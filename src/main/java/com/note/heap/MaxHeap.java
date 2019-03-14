package com.note.heap;

import com.note.array.Array;

/**
 * @Author 杨群
 * @Date 2019/3/12 20:34
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }

    public int getSize(){
        return data.getSize();
    }

    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i --){
            siftDown(i);
        }
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    // 返回完全二叉树中一个索引所表示的元素父节点的索引
    private int parent(int index) {
        if (index == 0){
            throw new IllegalArgumentException("index 0 doesn't have parent");
        }
        return (index - 1) / 2;
    }

    // 返回完全二叉树中一个索引所表示的元素左孩子的索引
    private int leftChild(int index){
        return index * 2 + 1;
    }

    // 返回完全二叉树中一个索引所表示的元素右孩子的索引
    private int rightChild(int index){
        return index * 2 + 2;
    }

    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {

        while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
            data.swap(k, parent(k));
            k = parent(k);
        }

    }

    public E findMax(){
        if (data.getSize() == 0){
            throw new IllegalArgumentException("heap is empty");
        }
        return data.get(0);
    }

    public E extractMax(){
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    public E replase(E e){
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }


    private void siftDown(int k) {

        while (leftChild(k) < data.getSize()){
            int j = leftChild(k);
            if(rightChild(k) < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0){
                j = rightChild(k);
            }
            if (data.get(k).compareTo(data.get(j)) >= 0){
                break;
            }
            data.swap(j, k);
            k = j;
        }
    }

}
