package com.myproject.stack;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @author Miroslav Kološnjaji
 */
public class LinkedStack<E> {
    // additional exercise: create stack using LinkedList

    private Node<E> first;
    private int size;

    public LinkedStack() {
    }

    //push
    public void push(E item){
        Node<E> newItem = new Node<>(item);

        if(first == null){
            first  = newItem;
            size++;
            return;
        }

        newItem.setNext(first);
        first = newItem;
        size++;

    }

    //pop
    public E pop(){

        if(isEmpty()){
            throw new NoSuchElementException();
        }

        E item = first.getValue();

        first = first.getNext();
        size--;

        return item;
    }

    //peek
    public E peek(){
        return first.getValue();
    }

    //isEmpty
    public boolean isEmpty(){
        return first == null;
    }

    public int size(){ return size; }

    @Override
    public String toString() {
        return getItems();
    }

    private String getItems() {

        StringBuilder sb = new StringBuilder();
        Node<E> element = first;

        sb.append("[");

        while(element != null){
            sb.append(element.getValue());
            element = element.getNext();

            if(element != null)
                sb.append(", ");
        }

        sb.append("]");

        return sb.toString();
    }

    private class Node<E> {

        private E value;
        private Node<E> next;

        public Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }




}
