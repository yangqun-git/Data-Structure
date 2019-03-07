package com.note.queue;

/**
 * @Author 杨群
 * @Date 2019/3/7 17:37
 */
public class LoopQueueTest {


    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 12; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
    }
}
