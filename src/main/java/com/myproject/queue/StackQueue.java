package com.myproject.queue;

import java.util.Stack;

/**
 * @author Miroslav Kološnjaji
 * @date 27.12.2023
 */
public class StackQueue<E> {

    private final Stack<E> firstStack = new Stack<>();
    private final Stack<E> secondStack = new Stack<>();

    public void add(E element) {
        firstStack.add(element);
    }

    public E remove() {

        moveElements();

        return secondStack.pop();
    }

    public int size(){
        return firstStack.size() + secondStack.size();
    }

    public boolean isEmpty(){
        return firstStack.isEmpty() && secondStack.isEmpty();
    }

    private void moveElements() {
        if (secondStack.isEmpty() && !firstStack.isEmpty()) {
            while (!firstStack.isEmpty()) {
                secondStack.push(firstStack.pop());
            }
        }
    }

    private String getItems(boolean populated, Stack<E> stack){

        moveElements();

        Stack<E> tempStack = populated ? stack : new Stack<>();

        while(!secondStack.isEmpty())
            tempStack.push(secondStack.pop());

        if(!firstStack.isEmpty())
            getItems(true, tempStack);

        String toString = tempStack.toString();

        while (!tempStack.isEmpty())
                secondStack.push(tempStack.pop());

        return toString;
    }

    private String getItems(){
        return getItems(false, null);
    }

    @Override
    public String toString() {
        return getItems();
    }
}
