package com.note.tree;

/**
 * @Author 杨群
 * @Date 2019/3/17 15:43
 */
public class SegmentTreeTest {

    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);

        Integer query = segmentTree.query(0, 2);
        System.out.println(query);
        query = segmentTree.query(2, 5);
        System.out.println(query);
        query = segmentTree.query(0, 5);
        System.out.println(query);
    }
}
