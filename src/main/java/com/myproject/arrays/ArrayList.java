package com.myproject.arrays;

import java.util.NoSuchElementException;

/**
 * @author Miroslav Kološnjaji
 * @date 27.12.2023
 */
public class ArrayList<T> {

    private T[] array;
    private int size;

    public ArrayList() {
        this.array = (T[]) new Object[5];
    }

    public ArrayList(int size) {
        this.array = (T[]) new Object[size];
    }

    public void insert(T value) {
        expand();
        array[size++] = value;
    }

    public void removeAt(int index) {

        if (size() == 0)
            throw new NoSuchElementException("List is empty.");

        if (index < 0 || index >= size())
            throw new IllegalArgumentException("Index is out of range.");

        for (int i = index; i < size(); i++) {

            if (i + 1 >= size()){
                array[i] = null;
                break;
            }

            array[i] = array[i + 1];
        }

        size--;
        shrink();
    }

    public int indexOf(T item) {
        for (int i = 0; i < size(); i++)
            if (array[i].equals(item))
                return i;

        return -1;
    }

    public int lastIndexOf(T item) {

        int index = -1;

        for (int i = 0; i < size(); i++)
            if (array[i].equals(item))
                index = i;

        return index;
    }

    public boolean contains(T item) {
        return indexOf(item) != -1;
    }


    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return getElements();
    }

    private String getElements() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");

        for (int i = 0; i < size; i++) {

            stringBuilder.append(array[i].toString());

            if (i + 1 < size)
                stringBuilder.append(", ");
        }

        stringBuilder.append("]");

        return stringBuilder.toString();

    }

    private void shrink() {

        if (percentage() < 35 && size > 2)
            updateNewLength(ExpandingFunction.DIVIDE);

    }

    private void expand() {

        if (size == array.length)
            updateNewLength(ExpandingFunction.MULTIPLY);

    }

    private void updateNewLength(ExpandingFunction expandingFunction) {

        int newSize = 0;

        switch (expandingFunction) {
            case MULTIPLY -> newSize = array.length * 2;
            case DIVIDE -> newSize = array.length / 2;
        }


        T[] newArray = (T[]) new Object[newSize];

        for (int i = 0; i < size; i++)
            newArray[i] = array[i];

        array = newArray;
    }

    private double percentage() {
        return ((double) size / array.length) * 100;
    }

    private enum ExpandingFunction {
        DIVIDE, MULTIPLY
    }

}
