package com.myproject.queue;

import java.util.Stack;

/**
 * @author Miroslav Kološnjaji
 * @date 27.12.2023
 */
public class StackQueue<E> {

    private Stack<E> firstStack = new Stack<>();
    private Stack<E> secondStack = new Stack<>();

    public void add(E element) {
        firstStack.add(element);
    }

    public E remove() {
        if (secondStack.isEmpty() && !firstStack.isEmpty()) {
            moveElements();
        }
        return secondStack.pop();
    }

    private void moveElements() {
        while (!firstStack.isEmpty()) {
            secondStack.push(firstStack.pop());
        }
    }

    @Override
    public String toString() {

        if (secondStack.isEmpty() && !firstStack.isEmpty())
            moveElements();
        return secondStack.toString();
    }
}
