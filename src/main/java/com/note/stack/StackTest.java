package com.note.stack;

import java.util.Random;

/**
 * @Author 杨群
 * @Date 2019/3/8 12:11
 */
public class StackTest {

    public static double testStack(Stack Stack, int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            Stack.push(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            Stack.pop();
        }

        long entTime = System.nanoTime();

        return (entTime - startTime) / 1000000000.0;

    }

    public static void main(String[] args) {

        int opCount = 1000000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("arrayStack time : " + time1); // arrayStack time : 0.078056271

        LinkListStack<Integer> linkListStack = new LinkListStack<>();
        double time2 = testStack(linkListStack, opCount);
        System.out.println("linkListStack time : " + time2); // linkListStack time : 0.205665765


        opCount = 10000000;
        arrayStack = new ArrayStack<>();
        time1 = testStack(arrayStack, opCount);
        System.out.println("arrayStack time : " + time1); // arrayStack time : 4.724630834

        linkListStack = new LinkListStack<>();
        time2 = testStack(linkListStack, opCount);
        System.out.println("linkListStack time : " + time2); // linkListStack time : 7.039119024  new Node()操作太多了
    }

}
