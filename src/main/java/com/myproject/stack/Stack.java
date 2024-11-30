package com.myproject.stack;

import java.util.Arrays;

/**
@author Miroslav Kološnjaji
*/public class Stack <E>{

    private E[] array;
    private int size;

    public Stack() {
        this.array = (E[]) new Object[10];
    }

    public void push(E element){
        if(isFull())
            throw new StackOverflowError();

        array[size++] = element;
    }

    public E pop(){

        if(isEmpty())
            throw new IllegalStateException();

        var element = array[size - 1];
        array[size - 1] = null;
        size--;
        return element;
    }

    public E peek(){
        if(isEmpty())
            throw new IllegalStateException();
        return array[size - 1];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private boolean isFull(){
        return size == array.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(array,0,size));
    }
}
