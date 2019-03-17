package com.note.tree;

/**
 * @Author 杨群
 * @Date 2019/3/14 10:52
 */
public class SegmentTree<E> {

    // 将data转成线段树
    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger){
        this.merger = merger;

        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }

        // 推出数组转成线段树，需要4倍数组的容量才可以装下转成树后的所有元素
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0 , arr.length - 1);
    }

    // 在treeIndex的位置创建表示区间【l ... r】的线段树
    public void buildSegmentTree(int treeIndex, int l, int r){
        if (l == r){
            tree[treeIndex] = data[l];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        // l和r的中间值
        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex, l , mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if (index < 0 || index >= data.length){
            throw new IllegalArgumentException("index is illegal");
        }
        return data[index];
    }

    private int leftChild(int index){
        return 2 * index + 1;
    }

    private int rightChild(int index){
        return 2 * index + 2;
    }

    // 返回区间【l 。。。 r】之间的值
    public E query(int queryL, int queryR){
        if (queryL < 0 || queryL >= data.length ||
                queryR < 0 || queryR >= data.length || queryL > queryR){
            throw new IllegalArgumentException("index is illegal");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    // 在以treeIndex为根的线段树中【l。。。r】的范围里， 搜索区间【queryL 。。。 queryR】的值
    private E query(int treeIndex, int l, int r, int queryL, int queryR){
        if (l == queryL && r == queryR){
            return tree[treeIndex];
        }

        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (queryL >= mid + 1){
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        }
        else if (queryR <= mid){
            return query(leftTreeIndex, l, mid, queryL, queryR);
        }

        E leftReturn = query(leftTreeIndex, l, mid, queryL, mid);
        E rightReturn = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
        return merger.merge(leftReturn, rightReturn);
    }

    public void set(int index, E e){
        if (index < 0 || index >= tree.length){
            throw new IllegalArgumentException("index is illegal");
        }

        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    private void set(int treeIndex, int l,int r, int index, E e){
        if (l == r){
            tree[treeIndex] = e;
            return;
        }

        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (index >= mid + 1){
            set(rightTreeIndex, mid + 1, r, index, e);
        }
        else{
            set(leftTreeIndex, l, mid, index, e);
        }

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null){
                sb.append(tree[i]);
            }
            else {
                sb.append("null");
            }

            if (i != tree.length - 1){
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
