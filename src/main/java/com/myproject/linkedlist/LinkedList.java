package com.myproject.linkedlist;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author Miroslav Kološnjaji
 * @date 27.12.2023
 */
public class LinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    //addFirst
    public void addFirst(E element) {
        var currentItem = new Node<>(element);

        if (isEmpty()) {
            first = currentItem;
            last = currentItem;
            return;
        }

        var temp = first;
        first = currentItem;
        first.setNext(temp);
        size++;
    }

    //addLast
    public void addLast(E element) {
        var currentItem = new Node<>(element);

        if (isEmpty()) {
            addFirst(element);
        }

        last.setNext(currentItem);
        last = currentItem;
        size++;
    }

    //deleteFirst
    public void deleteFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            return;
        }

        var nextFirst = first.getNext();
        first.setNext(null);
        first = nextFirst;
        size--;
    }

    //deleteLast
    public void deleteLast() {

        if (isEmpty())
            throw new NoSuchElementException();

        var current = first;

        while (true) {
            if (current.getNext() == last) {
                current.setNext(null);
                last = current;
                size--;
                break;
            }
            current = current.getNext();
        }
    }

    //contains
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    //indexOf
    public int indexOf(E element) {
        int index = 0;
        var current = first;

        while (current != null) {
            if (current.getValue().equals(element))
                return index;

            current = current.getNext();
            index++;
        }
        return -1;
    }

    //size
    public int size() {
        return size + 1;
    }

    //isEmpty
    public boolean isEmpty() {
        return first == null;
    }

    private E[] getItems() {
        E[] itemArray = (E[]) new Object[size + 1];

        var current = first;
        int index = 0;

        while (current != null) {
            itemArray[index++] = current.getValue();
            current = current.getNext();
        }

        return itemArray;
    }

    public E kthNodeFromTheEnd(int distance) {

        if (isEmpty())
            throw new IllegalStateException();

        if (distance > size)
            throw new IllegalArgumentException();

        if (distance == 1)
            return last.getValue();

        int index = 1;
        var firstPointer = this.first;
        var secondPointer = this.first;
        Node<E> result = null;
        while (firstPointer != null) {
            if (index >= distance) {
                if (result == null) {
                    result = secondPointer;
                } else {
                    result = secondPointer.getNext();
                    secondPointer = secondPointer.getNext();
                }

            }
            firstPointer = firstPointer.getNext();
            index++;
        }

        return secondPointer.getValue();
    }

    public void printMiddle() {
        if (isEmpty())
            return;

        var firstPointer = first;
        var secondPointer = first;

        int index = 0;

        while (firstPointer != null) {
            if (index % 2 == 0 && index > 0)
                secondPointer = secondPointer.getNext();

            firstPointer = firstPointer.getNext();
            index++;
        }


        if (index % 2 == 0) {
            System.out.println("[" + secondPointer + ", " + secondPointer.getNext() + "]");
        } else {
            System.out.println("[" + secondPointer + "]");
        }


    }

    public boolean hasLoop() {
        var fastPointer = first;
        var slowPointer = first;

        int index = 0;
        while (fastPointer != null) {

            if (index % 2 == 0 && index > 0)
                slowPointer = slowPointer.getNext();

            if (index > 0) {
                if (fastPointer.equals(slowPointer))
                    return true;
            }

            fastPointer = fastPointer.getNext();
            index++;
        }

        return false;
    }


    @Override
    public String toString() {
        return Arrays.toString(getItems());
    }

    private class Node<E> {
        private E value;
        private Node next;

        public Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return value.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(value, node.value) && Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, next);
        }
    }
}
