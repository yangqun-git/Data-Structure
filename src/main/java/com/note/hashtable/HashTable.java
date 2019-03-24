package com.note.hashtable;

import java.util.TreeMap;

/**
 * @Author 杨群
 * @Date 2019/3/24 15:13
 */
public class HashTable<K, V> {

    private final int[] capacity = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593, 49157, 98317,
    196613, 393241, 786433, 1572869, 3145739, 6291469, 12582917, 25165843, 50331653, 100663319, 201326611,
    402653189, 805306457, 1610612741};

    private static final int UPPER_TOL = 10;
    private static final int LOWER_TOL = 2;
    private int capacityIndex = 0;

    private TreeMap<K, V>[] hashTable;
    private int m;
    private int size;

    public HashTable() {
        this.m = capacity[capacityIndex];
        hashTable = new TreeMap[m];
        size = 0;
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public void add(K key, V value){
        TreeMap<K, V> map = hashTable[hash(key)];
        if (map.containsKey(key)){
            map.put(key, value);
        }
        else {
            map.put(key, value);
            size ++;

            if (size >= UPPER_TOL * m && capacityIndex + 1 < capacity.length){
                capacityIndex ++;
                resize(2 * m);
            }
        }
    }

    public V remove(K key){
        TreeMap<K, V> map = hashTable[hash(key)];
        V ret = null;
        if (map.containsKey(key)){
            ret = map.remove(key);
            size --;

            if (size < LOWER_TOL * m && capacityIndex - 1 >= 0){
                capacityIndex --;
                resize(m / 2);
            }
        }

        return ret;
    }

    public void set(K key, V value){
        TreeMap<K, V> map = hashTable[hash(key)];
        if (!map.containsKey(key)){
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        map.put(key, value);
    }

    public boolean contails(K key){
        return hashTable[hash(key)].containsKey(key);
    }

    public V get(K key){
        return hashTable[hash(key)].get(key);
    }

    private void resize(int newM){
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newHashTable.length; i++) {
            newHashTable[i] = new TreeMap<>();
        }

        int oldM = m;
        m = newM;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> map = hashTable[i];
            for (K k : map.keySet()) {
                newHashTable[hash(k)].put(k, map.get(k));
            }
        }


    }
}
