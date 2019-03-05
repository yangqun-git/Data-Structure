package com.note.array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author 杨群
 * @Date 2019/3/5 20:53
 */
public class ArrayTest {

    Array<Integer> arr = new Array(12);

    @Before
    public void init(){
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
    }

    @After
    public void print(){
        System.out.println(arr);
    }

    @Test
    public void addLast(){
        arr.addLast(15);
    }

    @Test
    public void add(){
        arr.add(1, 100);
    }

    @Test
    public void addFirst(){
        arr.addFirst(-1);
    }

    @Test
    public void remove(){
        arr.remove(5);
        arr.remove(3);
    }

    @Test
    public void removeFirst(){
        arr.removeFirst();
    }

    @Test
    public void removeLast(){
        arr.removeLast();
    }

    @Test
    public void removeElement(){
        arr.removeElement(4);
    }

    @Test
    public void resize(){
        System.out.println("---" + arr);
        arr.addLast(7);
        arr.addLast(7);
        arr.addLast(7);
        System.out.println("---" + arr);

        arr.removeFirst();
        arr.removeFirst();
        arr.removeFirst();
        System.out.println("---" + arr);
    }
}
