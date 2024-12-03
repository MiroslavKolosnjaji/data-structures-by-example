package com.myproject.linkedlist;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author Miroslav Kološnjaji
 * @date 27.12.2023
 */
public class LinkedList<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    public LinkedList() {
    }

    public void addFirst(T item) {

        Node<T> newItem = new Node<>(item);

        if (isEmpty()) {
            first = last = newItem;
            size++;
            return;
        }

        Node<T> next = first;
        first = newItem;
        first.setNext(next);
        size++;

    }

    public void addLast(T item) {

        if (isEmpty()) {
            addFirst(item);
            return;
        }

        last.setNext(new Node<>(item));
        last = last.getNext();
        size++;
    }

    public void deleteFirst() {

        if (isEmpty())
            throw new NoSuchElementException();

        if (hasOneElement()) {
            remove();
            return;
        }

        Node<T> next = first.getNext();
        first.setNext(null);
        first = next;
        size--;
    }

    public void deleteLast() {

        if (isEmpty())
            throw new NoSuchElementException();

        Node<T> item = first;

        if (hasOneElement()) {
            remove();
            return;
        }


        while (item != null) {

            if (item.getNext() == last)
                break;

            item = item.getNext();
        }

        item.setNext(null);
        last = item;
        size--;
    }

    public int indexOf(T item) {
        int index = 0;

        Node<T> current = first;

        while (current != null) {
            if (current.getItem().equals(item))
                return index;

            current = current.getNext();
            index++;
        }

        return -1;
    }

    public boolean contains(T item) {
        return indexOf(item) != -1;
    }

    public T[] toArray() {
        T[] array = (T[]) new Object[size];

        var current = first;
        int index = 0;

        while (current != null) {
            array[index++] = current.getItem();
            current = current.getNext();
        }

        return array;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return getElements();
    }

    private String getElements() {
        StringBuilder sb = new StringBuilder();

        var current = first;

        sb.append("[");
        while (current != null) {


            sb.append(current.getItem());
            current = current.getNext();

            if (current != null)
                sb.append(", ");

        }

        sb.append("]");

        return sb.toString();
    }

    private boolean hasOneElement() {
        return first == last;
    }

    private void remove() {
        first = last = null;
        size--;
    }

    //EXERCISE - find the Kth node from the end of a linked list in one pass
    public T getKthFromTheEnd(int k) {

        if (isEmpty())
            throw new NoSuchElementException();

        if (k < 0 || k > size)
            throw new IllegalArgumentException();

        var firstPointer = first;
        var secondPointer = first;

        int index = 0;
        while (firstPointer != null) {

            if (index >= k)
                secondPointer = secondPointer.getNext();

            firstPointer = firstPointer.getNext();
            index++;
        }
        return secondPointer.getItem();
    }


    //EXERCISE
    public String printMiddle() {

        if (isEmpty())
            return "EMPTY";

        var firstPointer = first;
        var secondPointer = first;

        int index = 0;

        while (firstPointer != null) {
            if (index % 2 == 0 && index > 0)
                secondPointer = secondPointer.getNext();

            firstPointer = firstPointer.getNext();
            index++;
        }

        if (index % 2 == 0)
            return "[" + secondPointer.getItem() + ", " + secondPointer.getNext().getItem() + "]";

        return "[" + secondPointer.getItem() + "]";


    }

    //EXERCISE
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

    private static class Node<T> {

        private T item;
        private Node<T> next;

        public Node(T item) {
            this.item = item;
        }

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        @Override
        public final boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node<?> node)) return false;

            return Objects.equals(item, node.item);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(item);
        }
    }
}
