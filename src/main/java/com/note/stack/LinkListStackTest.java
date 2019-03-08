package com.note.stack;

/**
 * @Author 杨群
 * @Date 2019/3/8 12:07
 */
public class LinkListStackTest {

    public static void main(String[] args) {
        LinkListStack linkListStack = new LinkListStack();

        for (int i = 0; i < 5; i++) {
            linkListStack.push(i);
            System.out.println(linkListStack);
        }
        linkListStack.pop();
        System.out.println(linkListStack);
    }


}
