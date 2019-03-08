package com.note.stack;

import com.note.linkedlist.LinkedList;

/**
 * @Author 杨群
 * @Date 2019/3/8 12:05
 */
public class LinkListStack<E> implements Stack<E> {
    private LinkedList<E> stack = new LinkedList<>();

    @Override
    public void push(E e) {
        stack.addFirst(e);
    }

    @Override
    public E pop() {
        return stack.removeFirst();
    }

    @Override
    public E peek() {
        return stack.getFirst();
    }

    @Override
    public int getSize() {
        return stack.getSize();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("linkListStack : top ");
        sb.append(stack);
        return sb.toString();
    }
}
