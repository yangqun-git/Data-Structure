package com.note.map;

/**
 * @Author 杨群
 * @Date 2019/3/10 15:31
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {
    private class Node{
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public void add(K key, V value){
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value){
        if (node == null){
            size ++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0){
            node.left = add(node.left, key, value);
        }
        else if (key.compareTo(node.key) > 0){
            node.right = add(node.right, key, value);
        }
        else {
            node.value = value;
        }

        return node;
    }

    // 返回以node为根的二分搜索树中key所在的节点
    private Node getNode(Node node, K key){
        if (node == null){
            return null;
        }

        if (node.key.compareTo(key) == 0){
            return node;
        }
        else if (node.key.compareTo(key) < 0){
            return getNode(node.left, key);
        }
        else {
            return getNode(node.right, key);
        }
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);

        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if (null == node){
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        node.value = value;
    }

    @Override
    public V remove(K key) {
        if (getNode(root, key) != null){
            root = remove(root, key);
            return root.value;
        }

        return null;
    }

    private Node remove(Node node, K key){
        // 未找到e元素
        if (node == null){
            return null;
        }

        if (key.compareTo(node.key) < 0){
            node.left = remove(node.left, key);
            return node;
        }
        else if (key.compareTo(node.key) > 0){
            node.right = remove(node.right, key);
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

    private Node  mininum(Node node){
        if (node.left == null){
            return node;
        }

        return mininum(node.left);
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
}
