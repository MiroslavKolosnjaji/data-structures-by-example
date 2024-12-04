package stack;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @author Miroslav Kološnjaji
 */
public class LinkedStack<E> {
    // additional exercise: create stack using LinkedList

    private Node<E> first;
    private Node<E> last;
    private int size;

    public LinkedStack() {
    }

    //push
    public void push(E item){
        Node<E> newItem = new Node<>(item);

        if(first == null){
            first  = newItem;
            last = newItem;
            return;
        }

        newItem.setNext(first);
        first = newItem;
        System.out.println("First value: " + first.getValue());
        size++;

    }

    //pop
    public E pop(){

        if(isEmpty()){
            throw new NoSuchElementException();
        }

        E item = first.getValue();
        Node<E> newFirst = first.getNext();

        first = null;
        first = newFirst;
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

    @Override
    public String toString() {
        Node<E> element = first;

        E[] array = (E[]) new Object[size + 1];
        int index = size;
        while(element != null){
            array[index--] = element.getValue();
            element = element.getNext();
        }

        return Arrays.toString(array);
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
