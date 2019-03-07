package com.note.queue;

/**
 * @Author 杨群
 * @Date 2019/3/7 13:20
 */
public class ArrayQueueTest {


    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
    }
}
