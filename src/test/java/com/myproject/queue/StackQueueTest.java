package com.myproject.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.EmptyStackException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Miroslav Kološnjaji
 */
class StackQueueTest {

    private StackQueue<Integer> stackQueue;

    @BeforeEach
    void setUp() {
        stackQueue = new StackQueue<>();
    }

    @DisplayName("Stack Queue - add")
    @Test
    void testAdd_whenValidArgumentProvided_thenPopulateStackQueue() {

        stackQueue.add(1);

        assertNotNull(stackQueue, "Stack Queue should not be null.");
        assertEquals(1, stackQueue.size(), "Stack Queue size should be 1.");
    }

    @DisplayName("Stack Queue - remove")
    @Test
    void testRemove_whenStackQueueIsPopulated_thenRemoveElementFromFront() {

        populateStackQueue(List.of(1,2,3,4));
        int expectedValue = 1;

        int removedValue = stackQueue.remove();

        assertNotNull(stackQueue, "Stack Queue should not be null.");
        assertEquals(expectedValue, removedValue, "Removed value should be 1.");
    }

    @DisplayName("Stack Queue - remove - empty queue")
    @Test
    void testRemove_whenStackQueueIsEmpty_thenThrowEmptyStackException() {

        Executable executable = () -> stackQueue.remove();

        assertNotNull(stackQueue, "Stack Queue should not be null.");
        assertThrows(EmptyStackException.class, executable, "Expected EmptyStackException");
    }

    @DisplayName("Stack Queue - size")
    @Test
    void testSize_whenStackQueueIsPopulated_returnsSizeOfTheStackQueue() {

        populateStackQueue(List.of(1,2,3,4,5));
        stackQueue.remove();

        populateStackQueue(List.of(12,15,6,13));

        int expectedSize = 8;

        int size = stackQueue.size();

        assertNotNull(stackQueue, "Stack Queue should not be null.");
        assertEquals(expectedSize, size, "Stack Queue size should be 8.");
    }

    @DisplayName("Stack Queue - isEmpty")
    @Test
    void testIsEmpty_whenStackQueueIsPopulated_returnsFalse() {

        populateStackQueue(List.of(1,2,3,4,5));

        boolean isEmpty = stackQueue.isEmpty();

        assertNotNull(stackQueue, "Stack Queue should not be null.");
        assertFalse(isEmpty, "Expected value should be 'false'.");
    }

    @DisplayName("Stack Queue - isEmpty - empty queue")
    @Test
    void testIsEmpty_whenStackQueueIsEmpty_returnsFalse() {

        boolean isEmpty = stackQueue.isEmpty();

        assertNotNull(stackQueue, "Stack Queue should not be null.");
        assertTrue(isEmpty, "Expected value should be 'true'.");
    }

    @Test
    void testToString_whenStackQueueIsPopulated_returnsStringRepresentationOfStackQueue() {

        populateStackQueue(List.of(1,2,3));
        String expectedPattern = "[1, 2, 3]";

        String pattern = stackQueue.toString();

        assertNotNull(stackQueue, "Stack Queue should not be null.");
        assertEquals(expectedPattern, pattern, "String representation of Stack Queue should be the same as expected pattern.");
    }

    @Disabled
    @Test
    void testToString_whenStackQueueIsPopulatedMultipleTimes_returnsStringRepresentationOfStackQueue() {

        populateStackQueue(List.of(1,2,3,4,5));
        stackQueue.remove();
        populateStackQueue(List.of(6,7,8,9));


        String expectedPattern = "[2, 3, 4, 5, 6, 7, 8, 9]";

        String pattern = stackQueue.toString();

        assertNotNull(stackQueue, "Stack Queue should not be null.");
        assertEquals(expectedPattern, pattern, "String representation of Stack Queue should be the same as expected pattern.");
    }

    private void populateStackQueue(List<Integer> list){
        list.forEach(stackQueue::add);
    }
}