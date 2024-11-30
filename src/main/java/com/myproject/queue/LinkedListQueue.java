package com.myproject.queue;


/**
 * @author Miroslav Kološnjaji
 * @date 27.12.2023
 */
public class LinkedListQueue<E> {

    private Node<E> first;
    private Node<E> last;

    private int size;

    public LinkedListQueue() {
    }

    public void add(E element){
        var node = new Node<>(element);

        if(isEmpty())
            first = last = node;

        last.setNext(node);
        last = node;
        size++;
    }

    public E remove(){
        var node = first;
        var newFirst = first.getNext();
        first.setNext(null);
        first = newFirst;
        size --;
        return node.getValue();
    }

    public E peek(){
        return first.getValue();
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return first == null;
    }

    private String getItems(){
        var current = first;
        StringBuffer sb = new StringBuffer();

        sb.append("[");
        while(current != null){
            sb.append(current.getValue());

            if(current.getNext() != null)
                sb.append(", ");

            current = current.getNext();
        }
        sb.append("]");

        return sb.toString();
    }

    @Override
    public String toString() {
        return getItems();
    }

    private class Node<E>{
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
    }
}
