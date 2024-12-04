package com.myproject.linkedlist;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author Miroslav Kološnjaji
 * @date 27.12.2023
 */
public class DoublyLinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public DoublyLinkedList() {
    }

    public void addFirst(E element) {

        var node = new Node<>(element);

        if (isEmpty()) {
            first = last = node;
        } else {
            node.setNext(first);
            first.setPrevious(node);
            first = node;
        }

        size++;
    }

    public void addLast(E element) {

        if (isEmpty()) {
            addFirst(element);
            return;
        }

        var node = new Node<>(element);
        node.setPrevious(last);
        last.setNext(node);
        last = node;
        size++;
    }

    public void deleteFirst() {

        if (isEmpty())
            throw new NoSuchElementException();

        var newFirst = first.getNext();
        first.setNext(null);
        first = newFirst;
        size--;
    }

    public void deleteLast() {

        if (isEmpty())
            throw new NoSuchElementException();

        last = last.getPrevious();
        last.setNext(null);
        size--;
    }

    public int indexOf(E element) {
        var current = first;
        int index = 0;
        while (current != null) {
            if (current.getValue().equals(element))
                return index;

            current = current.getNext();
            index++;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    public boolean isEmpty() {
        return first == null;
    }

    private E[] getItems() {
        E[] itemArray = (E[]) new Object[size];

        var current = first;
        int index = 0;

        while (current != null) {
            itemArray[index++] = current.getValue();
            current = current.getNext();
        }

        return itemArray;
    }


    @Override
    public String toString() {
        return Arrays.toString(getItems());
    }

    private class Node<E> {

        private E value;
        private Node next;
        private Node previous;

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

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
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
            return Objects.equals(value, node.value) && Objects.equals(next, node.next) && Objects.equals(previous, node.previous);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, next, previous);
        }
    }
}
