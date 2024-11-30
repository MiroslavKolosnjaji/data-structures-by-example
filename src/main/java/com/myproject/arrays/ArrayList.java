package com.myproject.arrays;

import java.util.Arrays;

/**
 * @author Miroslav Kološnjaji
 * @date 27.12.2023
 */
public class ArrayList<E> {

    private E[] array;
    private int size;

    public ArrayList() {
        this.array = (E[]) new Object[10];
    }

    public ArrayList(int size) {
        this.array = (E[]) new Object[size];
    }

    //insert
    public void insert(E element) {

        if(element == null)
            throw new IllegalArgumentException();


        extend();
        array[size++] = element;
    }


    //removeAt
    public void removeAt(int index) {

        if(index < 0 || index >= size)
            throw new IllegalArgumentException();

        for (int i = 0; i < size; i++) {
            if (i == index) {
                array[i] = null;
                break;
            }
        }

        shrink();
        moveElements(index);

    }


    //indexOf
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (array[i] == element)
                return i;
        }
        return -1;
    }

    //max
//    public E max(){
//        if(E instanceof Integer){
//            E max = array[0];
//
//            for (int i = 0; i < size; i++) {
//                if((int) array[i] > (int) max){
//                    max = array[i];
//                }
//            }
//            return max;
//        }
//
//        return null;
//    }


    private void moveElements(int index) {

        if (index == size) return;

        for (int i = index; i < size; i++) {
            E temp = array[i];
            array[i] = array[i + 1];
            array[i + 1] = temp;
        }

        size--;
    }

    //extend
    private void extend() {
        if (size == array.length)
            createNewArray(size * 2);
    }

    //shrink
    private void shrink() {
        if (getPercentage() < 30)
            createNewArray(array.length / 2);
    }

    private void createNewArray(int s) {
        E[] newArray = (E[]) new Object[s];

        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    private double getPercentage() {
        return ((double) size / array.length) * 100;
    }

    @Override
    public String toString() {
        E[] items = Arrays.copyOfRange(array, 0, size);
        System.out.println("Actual length: " + array.length);
        System.out.println("Size: " + size);
        return Arrays.toString(items);
    }
}
