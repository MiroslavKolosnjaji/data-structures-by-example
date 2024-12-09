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
class ArrayQueueTest {

    private ArrayQueue<Integer> arrayQueue;

    @BeforeEach
    void setUp() {
        arrayQueue = new ArrayQueue<>();
    }

    @DisplayName("Array Queue - add")
    @Test
    void testAdd_whenValidArgumentProvided_thenPopulateArrayQueue() {

        arrayQueue.add(1);

        assertNotNull(arrayQueue, "Array Queue should not be null.");
        assertFalse(arrayQueue.isEmpty(), "Array Queue should not be empty");
        assertEquals("[1]", arrayQueue.toString(), "String representation pattern of array queue should be the same as expected pattern.");
    }

    @DisplayName("Array Queue - add")
    @Test
    void testAdd_whenArrayQueueIsFull_throwsIllegasStateException() {

        populateArrayQueue(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        Executable executable = () -> arrayQueue.add(11);

        assertNotNull(arrayQueue, "Array Queue should not be null.");
        assertThrows(IllegalStateException.class, executable, "Expected IllegalStateException.");
    }

    @DisplayName("Array Queue - remove")
    @Test
    void testRemove_whenArrayQueueIsPopulated_removeElementFromTheFront() {

        populateArrayQueue(List.of(1, 2, 3));
        int expectedValue = 1;

        int value = arrayQueue.remove();

        assertNotNull(arrayQueue, "Array Queue should not be null.");
        assertEquals(expectedValue, value, "Removed value should be 1.");
        assertEquals(2, arrayQueue.size(), "Array Queue size should be 2.");
    }

    @DisplayName("Array Queue - remove - empty queue")
    @Test
    void testRemove_whenArrayQueueIsEmpty_throwsIllegalStateException() {

        Executable executable = () -> arrayQueue.remove();

        assertNotNull(arrayQueue, "Array Queue should not be null.");
        assertThrows(IllegalStateException.class, executable, "Expected IllegalStateException.");
    }

    @DisplayName("Array Queue - peek")
    @Test
    void testPeek_whenArrayQueueIsPopulated_returnsFrontElement() {

        populateArrayQueue(List.of(1, 2, 3));
        int expectedValue = 1;

        int value = arrayQueue.peek();

        assertNotNull(arrayQueue, "Array Queue should not be null.");
        assertEquals(expectedValue, value, "Expecting value 1.");

    }

    @DisplayName("Array Queue - peek - empty queue")
    @Test
    void testPeek_whenArrayQueueIsEmpty_throwsIllegalStateException() {

        Executable executable = () -> arrayQueue.peek();

        assertNotNull(arrayQueue, "Array Queue should not be null.");
        assertThrows(IllegalStateException.class, executable, "Expected IllegalStateException.");
    }

    @DisplayName("Array Queue - isEmpty")
    @Test
    void testIsEmpty_whenArrayQueueIsPopulated_returnsFalse() {

        populateArrayQueue(List.of(1, 2));

        boolean isEmpty = arrayQueue.isEmpty();

        assertNotNull(arrayQueue, "Array Queue should not be null.");
        assertFalse(isEmpty, "Expected 'false' because the list is populated.");
    }

    @DisplayName("Array Queue - isEmpty - empty queue")
    @Test
    void testIsEmpty_whenArrayQueueIsEmpty_returnsTrue() {

        populateArrayQueue(List.of());

        boolean isEmpty = arrayQueue.isEmpty();

        assertNotNull(arrayQueue, "Array Queue should not be null.");
        assertTrue(isEmpty, "Expected 'true' because the list is empty.");
    }

    @DisplayName("Array Queue - size")
    @Test
    void testSize_whenArrayQueueIsPopulated_returnsSizeOfArrayQueue() {

        populateArrayQueue(List.of(1, 2, 3));
        int expectedSize = 3;

        int size = arrayQueue.size();
        assertNotNull(arrayQueue, "Array Queue should not be null.");
        assertEquals(expectedSize, size, "Array Queue size should be 3.");

    }

    private void populateArrayQueue(List<Integer> list) {
        list.forEach(arrayQueue::add);
    }
}