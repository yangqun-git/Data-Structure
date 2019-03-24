package com.note.trie;

import java.util.TreeMap;

/**
 * @Author 杨群
 * @Date 2019/3/19 10:44
 */
public class Trie {

    private class Node{
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }


    private Node root;
    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }

    // 获取trie中的单词个数
    public int getSize(){
        return size;
    }

    // 向trie中添加一个新的单词
    public void add(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null){
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord){
            cur.isWord = true;
            size ++;
        }
    }

    public boolean contains(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }

        return cur.isWord;
    }

    // 判断trie是否有以前缀prefix开头的
    public boolean isPrefix(String prefix){
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

}
