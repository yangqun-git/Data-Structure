package com.note.map;

/**
 * @Author 杨群
 * @Date 2019/3/10 14:54
 */
public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key){
            this(key, null, null);
        }

        public Node(){
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + ":" + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public Node getNode(K key){
            Node cur = dummyHead.next;
            while (cur != null){
                if (cur.key.equals(key)){
                    return cur;
                }
                cur = cur.next;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null){
            dummyHead.next = new Node(key, value, dummyHead.next);
            size ++;
        }
        else {
            node.value = value;
        }
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if (node == null){
            throw new IllegalArgumentException(key + " doesn't exist");
        }
        node.value = value;
    }

    @Override
    public V remove(K key) {
        Node pre = dummyHead;
        while (pre.next != null){
            if (pre.next.key.equals(key)){
                break;
            }
            pre = pre.next;
        }

        if (pre.next != null){
            Node delNode = pre.next;
            pre.next = delNode.next;
            delNode.next = null;
            size --;
            return delNode.value;
        }
        return null;
    }
}
