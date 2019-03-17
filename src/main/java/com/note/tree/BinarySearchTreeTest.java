package com.note.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Author 杨群
 * @Date 2019/3/9 11:18
 */
public class BinarySearchTreeTest {

    public static void main(String[] args) {
        int[] nums = {5, 3, 6, 8, 4, 2};

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        for (int num : nums) {
            bst.add(num);
        }

        //////////////////
        //       5      //
        //     /   \    //
        //    3     6   //
        //   / \     \  //
        //  2   4     8 //
        //////////////////

        System.out.println(bst);

        bst.remove(3);

        System.out.println(bst);

//        tree.preOrder();
//
//        System.out.println();
//
//        tree.preOrderNF();
//
//        System.out.println();
//
//
//        tree.inOrder();
//
//        System.out.println();
//
//
//        tree.postOrder();
//
//        System.out.println();
//
//
//        tree.leavelOrder();


//        System.out.println(tree);
    }

    @Test
    public void removeMin(){
        int n = 1000;
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            tree.add(random.nextInt(10000));
        }

        System.out.println(tree);

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < tree.getSize(); i++) {
            arrayList.add(tree.removeMin());
        }

        System.out.println(arrayList);

        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i) < arrayList.get(i - 1)){
                System.out.println("error");
            }
        }
    }
}
