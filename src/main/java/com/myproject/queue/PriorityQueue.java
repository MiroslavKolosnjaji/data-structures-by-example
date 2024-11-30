package com.myproject.queue;

import java.util.Arrays;


/**
 * @author Miroslav Kološnjaji
 * @date 27.12.2023
 */
public class PriorityQueue {

    private int[] array;
    private int size;
    private int frontPointer;
    private int rearPointer;


    public PriorityQueue() {
        this.array = new int[10];
    }

    public void add(int item) {
        if(isFull())
            throw new IllegalStateException();

        if (isEmpty()) {
            array[rearPointer] = item;
        }

        sort(item);
        size++;
    }

    private void sort(int item) {
        for (int i = size; i >= 0; i--) {

            if(i + 1 == array.length)
                array[i] = item;

            if(array[array.length - 1] != 0){
                moveItems();
            }

            if (array[i] > item || array[i] == 0) {
                array[i + 1] = array[i];
                array[i] = item;
            }
        }
        rearPointer++;
    }

    private void moveItems() {
        for (int i = 0; i < array.length; i++) {

            if(frontPointer == array.length)
                break;
            array[i] = array[frontPointer++];
        }
        frontPointer = 0;
    }

    public int remove(){

        if(isEmpty())
            throw new IllegalStateException();

        int item = array[frontPointer];
        array[frontPointer++] = 0;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull(){
        return size == array.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(array, 0, array.length));
    }
}

