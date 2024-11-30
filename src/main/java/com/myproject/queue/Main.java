package queue;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Miroslav Kološnjaji
 */
public class Main {

    public static void main(String[] args) {
//        ArrayQueue<Integer> queue = new ArrayQueue<>();
//        queue.add(10);
//        queue.add(20);
//        queue.add(30);
//        queue.add(40);
//        System.out.println(queue);
//        queue.remove();
//        System.out.println(queue);
//        System.out.println(queue.peek());
//        System.out.println(queue);

//        StackQueue<Integer> stackQueue = new StackQueue<>();
//        stackQueue.add(10);
//        stackQueue.add(20);
//        stackQueue.add(30);
//        stackQueue.add(40);
//        System.out.println(stackQueue);
//        stackQueue.remove();
//        System.out.println(stackQueue);

//       Queue priorityQueue = new PriorityQueue();
//        priorityQueue.add(5);
//        priorityQueue.add(3);
//        priorityQueue.add(6);
//        priorityQueue.add(1);
//        priorityQueue.add(4);
//        System.out.println(priorityQueue);

        LinkedListQueue<Integer> listQueue = new LinkedListQueue<>();
        listQueue.add(5);
        listQueue.add(10);
        listQueue.add(15);
        listQueue.add(20);
        listQueue.add(25);
        System.out.println(listQueue);
        System.out.println(listQueue.remove());
        System.out.println(listQueue);
        System.out.println(listQueue.remove());
        System.out.println(listQueue);
        System.out.println(listQueue.remove());
        System.out.println(listQueue);

    }

    public static void reverse(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();

        while(!queue.isEmpty()){
            stack.push(queue.poll());
        }

        while (!stack.isEmpty()){
            queue.add(stack.pop());
        }

        System.out.println("Revesed: " + queue);
    }
}
