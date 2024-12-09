package com.myproject.queue;

import java.util.Arrays;

/**
 * @author Miroslav Kološnjaji
 * @date 27.12.2023
 */
public class ArrayQueue<E> {

    private final E[] array;
    private int size;
    private int frontPointer;
    private int rearPointer;

    public ArrayQueue() {
        this.array = (E[]) new Object[10];
    }

    public void add(E element) {
        if (isFull())
            throw new IllegalStateException();

        array[rearPointer] = element;
        rearPointer = (rearPointer + 1) % array.length;
        size++;
    }

    public E remove() {
        if (isEmpty())
            throw new IllegalStateException();

        var element = array[frontPointer++];
        frontPointer = (frontPointer + 1) % array.length;
        size--;
        return element;
    }

    public E peek() {
        if (isEmpty())
            throw new IllegalStateException();
        return array[frontPointer];
    }

    public boolean isEmpty() {
        return size == 0 && frontPointer == rearPointer;
    }

    private boolean isFull() {
        return size == array.length;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(array, frontPointer, rearPointer));
    }
}
