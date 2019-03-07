package com.note.queue;

import java.util.Random;

/**
 * @Author 杨群
 * @Date 2019/3/7 17:51
 */
public class QueueTest {

    public static double testQueue(Queue queue, int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }

        long entTime = System.nanoTime();

        return (entTime - startTime) / 1000000000.0;

    }

    public static void main(String[] args) {

        int opCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue time : " + time1);

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue time : " + time2);
    }

}
