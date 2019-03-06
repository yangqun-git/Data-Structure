package com.note.stack;

public interface Stack<E> {

    // 压栈
    void push(E e);

    // 出栈
    E pop();

    // 查看栈首
    E peek();

    // 元素个数
    int getSize();

    // 是否为空
    boolean isEmpty();
}
