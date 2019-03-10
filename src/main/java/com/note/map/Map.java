package com.note.map;

/**
 * @Author 杨群
 * @Date 2019/3/10 14:39
 */
public interface Map<K, V> {
    void add(K key, V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key, V value);
    int getSize();
    boolean isEmpty();
}
