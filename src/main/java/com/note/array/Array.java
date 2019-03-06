package com.note.array;

/**
 * @Author 杨群
 * @Date 2019/3/5 20:22
 */
public class Array<E> {

    private E[] data;

    private int size;

    public Array(int capacity){
        // java不支持直接定义泛型数组(new E[])
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // 无参构造器,默认容量为10
    public Array(){
        this(10);
    }

    // 获取数组中元素个数
    public int getSize(){
        return size;
    }

    // 获取数组容量
    public int getCapacity(){
        return data.length;
    }

    // 返回数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 向数组末添加数据
    public void addLast(E e){
        add(size, e);
    }

    // 向数组首添加数据
    public void addFirst(E e){
        add(0, e);
    }

    // 向指定索引处添加元素e
    public void add(int index, E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index < size!");
        }

        if (size == data.length){
            resize(2 * data.length);
        }

        for (int i = size -1; i >= index; i--){
            data[i + 1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    // 获取指定索引的元素
    public E get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index illegal");
        }
        return data[index];
    }

    // 获取数组末元素
    public E getLast(){
        return get(size - 1);
    }

    // 获取数组首元素
    public E getFirst(){
        return get(0);
    }

    // 将指定索引元素替换成e, 返回被覆盖的元素
    public E set(int index, E e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed. Index illegal");
        }
        E ret = data[index];
        data[index] = e;
        return ret;
    }

    // 数组中包含元素e返回true
    public boolean contails(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    // 如果包含元素e返回对应索引,没有找到则返回-1 (若有重复元素,只会返回第一个)
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    // 删除指定index元素
    public E remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Index illegal");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i ++){
            data[i - 1] = data[i];
        }
        size --;
        // 释放引用
        data[size] = null;
        if (size < data.length / 4){
            resize(data.length / 2);
        }
        return ret;
    }

    // 删除数组头
    public E removeFirst(){
        return remove(0);
    }

    // 删除数组尾
    public E removeLast(){
        return remove(size - 1);
    }

    // 从数组中删除元素e(若有重复元素,只会删除第一个)
    public void removeElement(E e){
        int index = find(e);
        if (index != -1){
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++){
            sb.append(data[i]);
            if (i != size - 1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
