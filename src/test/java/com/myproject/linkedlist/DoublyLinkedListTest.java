package com.myproject.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Miroslav Kološnjaji
 */
class DoublyLinkedListTest {

    private DoublyLinkedList<Integer> linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new DoublyLinkedList<>();
    }

    @DisplayName("Doubly Linked List - addFirst")
    @Test
    void testAddFirst_whenValidArgumentProvided_thenPopulateList() {

        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);

        assertNotNull(linkedList, "Doubly linked list should not be null");
        assertEquals(3, linkedList.size(), "List size should be 3.");
        assertEquals("[3, 2, 1]", linkedList.toString(), "Mismatch in list string representation: expected [3, 2, 1], but got '." + linkedList.toString() + "'");
    }

    @DisplayName("Doubly Linked List - addLast")
    @Test
    void testAddLast_whenValidArgumentProvided_thenPopulateList() {

        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);

        assertNotNull(linkedList, "Doubly linked list should not be null");
        assertEquals(3, linkedList.size(), "List size should be 3.");
        assertEquals("[1, 2, 3]", linkedList.toString(), "Mismatch in list string representation: expected [1, 2, 3], but got '." + linkedList.toString() + "'");
    }

    @DisplayName("Doubly Linked List - deleteFirst")
    @Test
    void testDeleteFirst_whenListIsPopulated_thenRemoveFirstElementFromTheList() {

        populateList(List.of(1,2,3));
        int removedValue = 1;

        linkedList.deleteFirst();

        assertNotNull(linkedList, "Doubly linked list should not be null.");
        assertEquals(2, linkedList.size(), "List size should be 2.");
        assertFalse(linkedList.contains(removedValue), "List should not contain removed element.");
    }

    @DisplayName("Doubly Linked List - deleteFirst - empty list")
    @Test
    void TestDeleteFirst_whenListIsEmpty_throwsNoSuchElementException() {

        Executable executable = () -> linkedList.deleteFirst();

        assertThrows(NoSuchElementException.class, executable, "Expected NoSuchElementException.");
    }

    @DisplayName("Doubly Linked List - deleteLast")
    @Test
    void testDeleteLast_whenListIsPopulated_thenRemoveLastElementFromTheList() {

        populateList(List.of(1,2,3));
        int removedValue = 3;

        linkedList.deleteLast();

        assertNotNull(linkedList, "Doubly linked list should not be null.");
        assertEquals(2, linkedList.size(), "List size should be 2.");
        assertFalse(linkedList.contains(removedValue), "List should not contain removed element.");
    }

    @DisplayName("Doubly Linked List - deleteLast - empty list")
    @Test
    void testDeleteLast_whenListIsEmpty_throwsNoSuchElementException() {

        Executable executable = () -> linkedList.deleteLast();

        assertThrows(NoSuchElementException.class, executable, "Expected NoSuchElementException.");
    }

    @DisplayName("Doubly Linked List - indexOf")
    @Test
    void testIndexOf_whenListIsPopulated_returnsIndexOfChosenElement() {

        populateList(List.of(1,2,3,4,5));
        int expectedIndex = 3;

        int index = linkedList.indexOf(4);

        assertNotNull(linkedList, "Doubly linked list should not be null.");
        assertEquals(expectedIndex, index, "Expecting index 3, but got '" + index + "'");
    }

    @DisplayName("Doubly Linked List - indexOf - element not found")
    @Test
    void testIndexOf_whenElementDoesntExistsInList_returnsNegativeNumber() {

        populateList(List.of(1,2,3,4,6));
        int expectedIndex = -1;

        int index = linkedList.indexOf(5);

        assertNotNull(linkedList, "Doubly linked list should not be null.");
        assertEquals(expectedIndex, index, "Expecting index -1, but got '" + index + "'");
    }

    @DisplayName("Doubly Linked List - size")
    @Test
    void testSize_whenListIsPopulated_thenReturnSizeOfTheList() {

        populateList(List.of(1,2,3));
        int expectedSize = 3;

        int size = linkedList.size();

        assertNotNull(linkedList, "Doubly linked list should not be null.");
        assertEquals(expectedSize, size, "Size should be 3, but got '" + size + "'");
    }

    @DisplayName("Doubly Linked List - size - empty list")
    @Test
    void testSize_whenListIsEmpty_thenReturnSizeOfTheList() {

        populateList(List.of());
        int expectedSize = 0;

        int size = linkedList.size();

        assertNotNull(linkedList, "Doubly linked list should not be null.");
        assertEquals(expectedSize, size, "Size should be 0, but got '" + size + "'");
    }

    @DisplayName("Doubly Linked List - contains")
    @Test
    void testContains_whenListContainChosenNumber_returnsTrue() {

        populateList(List.of(1,2,3));

        boolean contains = linkedList.contains(3);

        assertNotNull(linkedList, "Doubly linked list should not be null.");
        assertTrue(contains, "List should contain selected element.");
    }

    @DisplayName("Doubly Linked List - contains - element not found")
    @Test
    void testContains_whenListDoesntContainChosenNumber_returnsFalse() {

        populateList(List.of(1,2,5));

        boolean contains = linkedList.contains(3);

        assertNotNull(linkedList, "Doubly linked list should not be null.");
        assertFalse(contains, "List should not contain selected element.");
    }

    @DisplayName("Doubly Linked List - isEmpty")
    @Test
    void testIsEmpty_whenListIsPopulated_returnsFalse() {

        populateList(List.of(1,2,3,4,5));

        boolean isEmpty = linkedList.isEmpty();

        assertNotNull(linkedList, "Doubly linked list should not be null.");
        assertFalse(isEmpty, "Method should return false.");
    }

    @DisplayName("Doubly Linked List - isEmpty - empty list")
    @Test
    void testIsEmpty_whenListIsEmpty_returnsTrue() {

        populateList(List.of());

        boolean isEmpty = linkedList.isEmpty();

        assertNotNull(linkedList, "Doubly linked list should not be null.");
        assertTrue(isEmpty, "Method should return true.");
    }

    @DisplayName("Doubly Linked List - toString")
    @Test
    void testToString_whenListIsPopulated_shouldReturnElementsRepresentation() {

        populateList(List.of(1,2,3,4,5));
        String expectedPattern = "[1, 2, 3, 4, 5]";

        String pattern = linkedList.toString();

        assertNotNull(linkedList, "Doubly linked list should not be null.");
        assertEquals(expectedPattern, pattern, "String pattern representation is not equal as expected pattern.");
    }

    @DisplayName("Doubly Linked List - toString - empty list")
    @Test
    void testToString_whenListIsEmpty_shouldReturnElementsRepresentation() {

        populateList(List.of());
        String expectedPattern = "[]";

        String pattern = linkedList.toString();

        assertNotNull(linkedList, "Doubly linked list should not be null.");
        assertEquals(expectedPattern, pattern, "String pattern representation is not equal as expected pattern.");
    }

    private void populateList(List<Integer> list){
        list.forEach(linkedList::addLast);
    }
}