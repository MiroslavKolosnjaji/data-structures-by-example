package com.myproject.stack;

import java.util.Arrays;

/**
@author Miroslav Kološnjaji
*/public class Stack <T>{

    private final T[] array;
    private int size;

    public Stack() {
        this.array = (T[]) new Object[5];
    }

    public Stack(int size) {
        this.array = (T[]) new Object[size];
    }

    public void push(T item){
        if(isFull())
            throw new StackOverflowError();

        array[size++] = item;
    }

    public T pop(){

        if(isEmpty())
            throw new IllegalStateException();

        T value = array[size - 1];
        size--;

        return value;
    }

    public T peek(){
        if(isEmpty())
            throw new IllegalStateException();

        return array[size - 1];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private boolean isFull(){
        return size == array.length;
    }

    @Override
    public String toString() {
        return getItems();
    }

    private String getItems(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < size; i++) {
            sb.append(array[i]);

            if(i + 1 < size)
                sb.append(", ");
        }

        sb.append("]");

        return sb.toString();
    }
}
