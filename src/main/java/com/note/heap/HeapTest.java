package com.note.heap;

import java.util.Random;

/**
 * @Author 杨群
 * @Date 2019/3/13 14:35
 */
public class HeapTest {

    public static void main(String[] args) {
        int n = 10000;

        MaxHeap<Integer> maxHeap = new MaxHeap<>();

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] ints = new int[n];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < ints.length; i++) {
            if (ints[i] > ints[i - 1]){
                System.out.println("error");
            }
        }
    }
}
