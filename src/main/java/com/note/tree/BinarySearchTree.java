package com.note.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author 杨群
 * @Date 2019/3/9 10:00
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left, right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E e){
        root = add(root, e);
    }

    public boolean contains(E e){
        return contains(root, e);
    }

    // 前序遍历
    public void preOrder(){
        preOrder(root);
    }

    // 前序遍历非递归实现
    public void preOrderNF(){
        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);


            if (cur.right != null){
                stack.push(cur.right);
            }

            if (cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    private void preOrder(Node node){
        if (node == null){
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 后序遍历
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if (node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public void leavelOrder(){
        LinkedList<Node> queue = new LinkedList<>();
        if (root == null){
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);

            if (cur.left != null){
                queue.add(cur.left);
            }

            if (cur.right != null){
                queue.add(cur.right);
            }
        }
    }

    // 中序遍历
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if (node == null){
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public E mininum(){
        if (size == 0){
            throw new IllegalArgumentException("tree is empty");
        }
        return mininum(root).e;
    }

    public E maxinum(){
        if (size == 0){
            throw new IllegalArgumentException("tree is empty");
        }

        return maxinum(root).e;
    }

    public E removeMin(){
        E ret = mininum();
        root = removeMin(root);
        return ret;
    }

    public E removeMax(){
        E ret = maxinum();
        root = removeMax(root);
        return ret;
    }

    public void remove(E e){
        root = remove(root, e);
    }

    private Node remove(Node node, E e){
        // 未找到e元素
        if (node == null){
            return null;
        }

        if (e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
            return node;
        }
        else if (e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);
            return node;
        }
        else { // e == node.e

            // 要删除的节点只有左子树的情况
            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            // 要删除的节点只有右子树的情况
            else if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            // 删除的节点有左右子树, 找出待删除节点的后继节点替换待删除节点
            else {
                Node successor = mininum(node.right);
                successor.right = removeMin(node.right);
                successor.left = node.left;

                node.left = node.right = null;
                return successor;
            }
        }
    }

    // 删除以node为根的树的最大元素, 返回删除节点后当前树的根
    private Node removeMax(Node node){
        if (node.right== null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = removeMin(node.right);
        return node;
    }

    // 删除以node为根的树的最小元素, 返回删除节点后当前树的根
    private Node removeMin(Node node){
        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    private Node maxinum(Node node){
        if (node.right == null){
            return node;
        }

        return maxinum(node.right);
    }

    private Node  mininum(Node node){
        if (node.left == null){
            return node;
        }

        return mininum(node.left);
    }

    private boolean contains(Node node, E e){
        if (node == null){
            return false;
        }

        if (e.compareTo(node.e) == 0){
            return true;
        }
        else if (e.compareTo(node.e) < 0){
            return contains(node.left, e);
        }
        else {
            return contains(node.right, e);
        }
    }


    private Node add(Node node, E e){
        if (node == null){
            size ++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0){
            node.left = add(node.left, e);
        }
        else if (e.compareTo(node.e) > 0){
            node.right = add(node.right, e);
        }

        return node;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        genBSTString(root, 0, sb);
        return sb.toString();
    }

    private void genBSTString(Node node, int depth, StringBuilder sb) {
        if (node == null){
            sb.append(genDepthString(depth) + "null\n");
            return;
        }
        sb.append(genDepthString(depth) + node.e + "\n");
        genBSTString(node.left, depth + 1, sb);
        genBSTString(node.right, depth + 1, sb);
    }

    private String genDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }
}
