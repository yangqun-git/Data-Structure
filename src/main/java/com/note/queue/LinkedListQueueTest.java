package com.note.queue;

/**
 * @Author 杨群
 * @Date 2019/3/8 12:39
 */
public class LinkedListQueueTest {


    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue();
        for (int i = 0; i < 10; i++) {
            linkedListQueue.enqueue(i);
            System.out.println(linkedListQueue);
        }

        linkedListQueue.dequeue();
        System.out.println(linkedListQueue);
        linkedListQueue.dequeue();
        System.out.println(linkedListQueue);
    }
}
