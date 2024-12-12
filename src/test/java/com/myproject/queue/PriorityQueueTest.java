package com.myproject.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Miroslav Kološnjaji
 */
class PriorityQueueTest {

    private PriorityQueue priorityQueue;

    @BeforeEach
    void setUp() {
        priorityQueue = new PriorityQueue();
    }

    @DisplayName("Priority Queue - add")
    @Test
    void testAdd_whenValidArgumentsProvided_thenPopulatePriorityQueue() {

        priorityQueue.add(3);
        priorityQueue.add(8);
        priorityQueue.add(2);

        assertNotNull(priorityQueue, "Priority Queue should not be null.");
        assertEquals(3, priorityQueue.size(), "Priority Queue size should be 3.");
    }

    @DisplayName("Priority Queue - add - full queue")
    @Test
    void testAdd_whenPriorityQueueIsFull_throwsIllegalStateException() {

        populatePriorityQueue(List.of(1,2,3,4,5,7,9,8,6,10));

        Executable executable = () -> priorityQueue.add(11);

        assertThrows(IllegalStateException.class, executable, "Expected IllegalStateException");
    }

    @DisplayName("Priority Queue - remove")
    @Test
    void testRemove_whenPriorityQueueIsPopulated_thenRemoveElementFromTheFront() {

        populatePriorityQueue(List.of(3,8,2,5));
        int expectedValue = 2;

        int value = priorityQueue.remove();

        assertNotNull(priorityQueue, "Priority Queue should not be null.");
        assertEquals(expectedValue, value, "Expected value to be removed is 2.");
    }

    @DisplayName("Priority Queue - remove - empty queue")
    @Test
    void testRemove_whenPriorityQueueIsEmpty_throwsIllegalStateException() {

        Executable executable = () -> priorityQueue.remove();

        assertThrows(IllegalStateException.class, executable, "Expected IllegalStateException.");
    }

    @DisplayName("Priority Queue - size")
    @Test
    void testSize_whenPriorityQueueIsPopulated_returnsSizeOfPriorityQueue() {

        populatePriorityQueue(List.of(8,2,6,9,0,6,4));
        int expectedSize = 7;

        int size = priorityQueue.size();

        assertNotNull(priorityQueue, "Priority Queue should not be null.");
        assertEquals(expectedSize, size, "Expected size should be 7.");
    }

    @DisplayName("Priority Queue - isEmpty")
    @Test
    void testIsEmpty_whenPriorityQueueIsPopulated_returnsFalse() {

        populatePriorityQueue(List.of(1,3,5));

        boolean isEmpty = priorityQueue.isEmpty();

        assertNotNull(priorityQueue, "Priority Queue should not be null.");
        assertFalse(isEmpty, "Method should return 'false'.");
    }

    @DisplayName("Priority Queue - isEmpty - empty queue")
    @Test
    void testIsEmpty_whenPriorityQueueIsEmpty_returnsTrue() {

        boolean isEmpty = priorityQueue.isEmpty();

        assertNotNull(priorityQueue, "Priority Queue should not be null.");
        assertTrue(isEmpty, "Method should return 'true'.");
    }

    private void populatePriorityQueue(List<Integer> list){
        list.forEach(priorityQueue::add);
    }
}