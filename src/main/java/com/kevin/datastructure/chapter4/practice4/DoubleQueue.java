package com.kevin.datastructure.chapter4.practice4;

/**
 *  双端队列
 * @author kevin
 * @version 1.0
 * @date 2020-12-18 14:18
 */
public class DoubleQueue<E> {

    private E data[];
    private int size;
    private int front,tail;

    public int getSize() {
        return size;
    }

    //双端队列
    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty() {
        return tail == front;
    }

    public E getFront() {
        return data[front];
    }

    public E removeFirst(){
        if (isEmpty()){
            throw new IllegalArgumentException("队列元素满了,元素不能在出队了");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2);
        }
        return ret;
    }

    public E removeLast(E e){
        if (isEmpty()){
            throw new IllegalArgumentException("队列元素满了,元素不能在出队了");
        }
        tail = tail == 0 ? data.length - 1 : tail - 1;
        E ret = data[tail];
        data[tail] = null;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity()  / 2);
        }
        return ret;
    }

    //对队列进行扩容
    private void resize(int capacity) {
        E[] newData = (E[])new Object[capacity + 1];
        for (int i = 0 ; i < size ;i ++){
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    public void addLast(E e){
        if ((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
    }

    public void addFirst(E e){
        if ((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }
        front = front == 0 ? data.length - 1 : front - 1;
        data[front] = e;
        size ++;
    }
}
