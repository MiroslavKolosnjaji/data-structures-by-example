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
class LinkedListQueueTest {

    private LinkedListQueue<Integer> linkedListQueue;

    @BeforeEach
    void setUp() {
        linkedListQueue = new LinkedListQueue<>();
    }

    @DisplayName("Linked List Queue - add")
    @Test
    void testAdd_whenValidArgumentProvided_thenPopulateLinkedListQueue() {

        linkedListQueue.add(1);

        assertNotNull(linkedListQueue, "Linked List Queue should not be null.");
        assertEquals(1, linkedListQueue.size(), "Linked List Queue size should be 1.");
    }

    @DisplayName("Linked List Queue - remove")
    @Test
    void testRemove_whenLinkedListQueueIsPopulated_removeElementFromTheFront() {

        populateLinkedListQueue(List.of(1, 2, 4, 5, 6));
        int expectedValue = 1;
        int expectedSize = 4;

        int value = linkedListQueue.remove();

        assertNotNull(linkedListQueue, "Linked List Queue should not be null.");
        assertEquals(expectedValue, value, "Removed value should be 1");
        assertEquals(expectedSize, linkedListQueue.size(), "Linked List Queue size should be 4 after element removed.");
    }

    @DisplayName("Linked List Queue - remove - empty queue")
    @Test
    void testRemove_whenLinkedListQueueIsEmpty_throwsIllegalStateException() {

        Executable executable = () -> linkedListQueue.remove();

        assertThrows(IllegalStateException.class, executable, "Expecting IllegalStateException.");
    }

    @DisplayName("Linked List Queue - peek")
    @Test
    void testPeek_whenLinkedListQueueIsPopulated_returnsFirstElementOfTheLinkedListQueue() {

        populateLinkedListQueue(List.of(4,2,6));
        int expectedValue = 4;
        int expectedSize = 3;

        int value = linkedListQueue.peek();


        assertNotNull(linkedListQueue, "Linked List Queue should not be null.");
        assertEquals(expectedValue, value, "Peek value should be 4.");
        assertEquals(expectedSize, linkedListQueue.size(), "Linked List Queue size should be 3");

    }

    @DisplayName("Linked List Queue - peek - empty queue")
    @Test
    void testPeek_whenLinkedListQueueIsEmpty_returnsNull() {

        Integer value = linkedListQueue.peek();

        assertNotNull(linkedListQueue, "Linked List Queue should not be null.");
        assertNull(value, "Value should be null.");
    }

    @DisplayName("Linked List Queue - size")
    @Test
    void testSize_whenLinkedListQueueIsPopulated_returnsSizeOfTheLinkedListQueue() {

        populateLinkedListQueue(List.of(1,2,3,5));
        int expectedSize = 4;

        int size = linkedListQueue.size();

        assertNotNull(linkedListQueue, "Linked List Queue should be not null.");
        assertEquals(expectedSize, size, "Linked List Queue size should be 4.");
    }

    @DisplayName("Linked List Queue - isEmpty")
    @Test
    void testIsEmpty_whenLinkedListQueueIsPopulated_returnsFalse() {

        populateLinkedListQueue(List.of(1,2,3,5));

        boolean isEmpty = linkedListQueue.isEmpty();

        assertNotNull(linkedListQueue, "Linked List Queue should be not null.");
        assertFalse(isEmpty, "Method should return 'false'");
    }

    @DisplayName("Linked List Queue - IsEmpty - empty queue")
    @Test
    void testIsEmpty_whenLinkedListQueueIsEmpty_returnTrue() {


        boolean isEmpty = linkedListQueue.isEmpty();

        assertNotNull(linkedListQueue, "Linked List Queue should be not null.");
        assertTrue(isEmpty, "Method should return 'true'");
    }

    @Test
    void testToString_whenLinkedListQueueIsPopulated_returnsStringRepresentationOfLinkedListQueue() {

        populateLinkedListQueue(List.of(4,6,3,8,2,5));
        String expectedPattern = "[4, 6, 3, 8, 2, 5]";

        String pattern = linkedListQueue.toString();

        assertNotNull(linkedListQueue, "Linked List Queue should be not null.");
        assertEquals(expectedPattern, pattern, "String representation pattern of the linked list queue should be the same as expected pattern.");
    }

    private void populateLinkedListQueue(List<Integer> list) {
        list.forEach(linkedListQueue::add);
    }
}
