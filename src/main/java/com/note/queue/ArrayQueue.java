package com.note.queue;

import com.note.array.Array;

/**
 * 用{@link com.note.array.Array}实现栈结构
 * 缺点: 出栈操作时间复杂度为O(n),因为涉及到了元素前移操作
 * @Author 杨群
 * @Date 2019/3/7 13:15
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayQueue(){
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Queue : front [");
        for (int i = 0; i < array.getSize(); i++){
            sb.append(array.get(i));
            if (i != array.getSize() - 1){
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}
