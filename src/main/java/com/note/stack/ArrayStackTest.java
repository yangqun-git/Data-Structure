package com.note.stack;

/**
 * @Author 杨群
 * @Date 2019/3/6 22:06
 */
public class ArrayStackTest {

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(10);

        for (int i = 0; i < 12; i++) {
            stack.push(i);
        }
        System.out.println(stack);

        System.out.println(stack.peek());

        stack.pop();

        System.out.println(stack);
    }
}
