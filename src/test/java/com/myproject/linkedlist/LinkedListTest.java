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
class LinkedListTest {

    private LinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
    }

    @DisplayName("Linked List - addFirst")
    @Test
    void testAddFirst_whenValidArgumentProvided_thenCorrect() {

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        assertNotNull(list, "List should not be null.");
        assertEquals(3, list.size(), "Size count should be 3.");
        assertEquals("[3, 2, 1]", list.toString(), "List print pattern is not the same.");
    }

    @DisplayName("Linked List - addLast")
    @Test
    void testAddLast_whenValidArgumentProvided_thenCorrect() {

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        assertNotNull(list, "List should not be null.");
        assertEquals(3, list.size(), "Size count should be 3.");
        assertEquals("[1, 2, 3]", list.toString(), "List print pattern is not the same.");
    }

    @DisplayName("Linked List - deleteFirst")
    @Test
    void testDeleteFirst_whenMethodCalled_thenRemoveFirstElementFromTheList() {

        populateList(List.of(1, 2, 3));

        list.deleteFirst();

        assertNotNull(list, "List should not be null.");
        assertEquals(2, list.size(), "Size count should be 2.");
        assertEquals("[2, 3]", list.toString(), "List print pattern is not the same.");
    }

    @DisplayName("Linked List - deleteFirst - element doesnt exists")
    @Test
    void testDeleteFirst_whenListIsEmpty_throwsNoSuchElementException() {

        Executable executable = () -> list.deleteFirst();

        assertThrows(NoSuchElementException.class, executable, "Expecting NoSuchElementException.");
    }

    @DisplayName("Linked List - deleteLast")
    @Test
    void testDeleteLast_whenMethodCalled_thenRemoveLastElementFromTheList() {

        populateList(List.of(1, 2, 3));

        list.deleteLast();

        assertNotNull(list, "List should not be null.");
        assertEquals(2, list.size(), "Size count should be 2.");
        assertEquals("[1, 2]", list.toString(), "List print pattern is not the same.");

    }

    @DisplayName("Linked List - deleteLast - element doesnt exists")
    @Test
    void testDeleteLast_whenListIsEmpty_throwsNoSuchElementException() {

        Executable executable = () -> list.deleteLast();

        assertThrows(NoSuchElementException.class, executable, "Expecting NoSuchElementException.");
    }

    @DisplayName("Linked List - indexOf")
    @Test
    void testIndexOf_whenListIsNotEmpty_returnsIndexOfChosenElement() {

        populateList(List.of(1,2,3,4,5));

        int index = list.indexOf(3);

        assertNotNull(list, "List should not be null.");
        assertEquals(5, list.size(), "Size count should be 5.");
        assertEquals(2, index, "Index is not equal as expected.");

    }

    @DisplayName("Linked List - indexOf - element not found")
    @Test
    void testIndexOf_whenElementDoesntExistsInList_returnsNegativeNumber() {

        populateList(List.of(1,2,3,4,5));

        int index = list.indexOf(7);

        assertNotNull(list, "List should not be null.");
        assertEquals(5, list.size(), "Size count should be 5.");
        assertEquals(-1, index, "Index is not equal as expected.");
    }

    @DisplayName("Linked List - indexOf - empty list, element not found")
    @Test
    void testIndexOf_whenListIsEmpty_returnsNegativeNumber() {

        int index = list.indexOf(7);

        assertNotNull(list, "List should not be null.");
        assertEquals(0, list.size(), "Size count should be 5.");
        assertEquals(-1, index, "Index is not equal as expected.");

    }

    @DisplayName("Linked List - contains")
    @Test
    void testContains_whenElementExistsInTheList_returnsTrue() {

        populateList(List.of(1,2,3,4,5));

        boolean contains = list.contains(3);

        assertNotNull(list, "List should not be null");
        assertEquals(5, list.size(), "Size count should be 5.");
        assertTrue(contains, "Method should return true.");

    }

    @DisplayName("Linked List - contains - element not found")
    @Test
    void testContains_whenElementDoesntExistsInTheList_returnsTrue() {

        populateList(List.of(1,2,3,4,5));

        boolean contains = list.contains(6);

        assertNotNull(list, "List should not be null");
        assertEquals(5, list.size(), "Size count should be 5.");
        assertFalse(contains, "Method should return false.");

    }

    @DisplayName("Linked List - isEmpty")
    @Test
    void testIsEmpty_whenListIsPopulated_returnsFalse() {

        populateList(List.of(1,2,3));

        boolean isEmpty = list.isEmpty();

        assertNotNull(list, "List should not be null.");
        assertEquals(3, list.size(), "Size count should be 3.");
        assertFalse(isEmpty, "Method should return false.");
    }

    @DisplayName("Linked List - isEmpty - empty list.")
    @Test
    void testIsEmpty_whenListIsEmpty_returnTrue() {

        boolean isEmpty = list.isEmpty();

        assertNotNull(list, "List should not be null.");
        assertEquals(0, list.size(), "Size count should be 3.");
        assertTrue(isEmpty, "Method should return true.");
    }

    @DisplayName("Linked List - size")
    @Test
    void testSize_whenListIsPopulated_returnsSizeOfElements() {

        populateList(List.of(1,2,3,4));

        int size = list.size();

        assertNotNull(list, "List should not be null.");
        assertEquals(4, size, "Size count should be 4");
    }

    @DisplayName("Linked List - size - empty list")
    @Test
    void testSize_whenListIsEmpty_returnsZero() {


        int size = list.size();

        assertNotNull(list, "List should not be null.");
        assertEquals(0, size, "Size count should be 0");
    }

    @DisplayName("Linked List EXTRAS - findKthNodeFromTheEnd")
    @Test
    void testGetKthFromTheEnd_whenListIsPopulated_returnsKthNode() {

        populateList(List.of(1,2,3,4,5,6,7,8,9,10));
        int expectedValue = 7;

        int value = list.getKthFromTheEnd(4);

        assertNotNull(list, "List should not be null");
        assertEquals(expectedValue, value, "Value doesnt match expected result.");
    }

    @DisplayName("Linked List EXTRAS - findKthNodeFromTheEnd - empty list")
    @Test
    void testGetKthFromTheEnd_whenListIsEmpty_throwsNoSuchElementException() {


       Executable executable = () -> list.getKthFromTheEnd(4);

        assertThrows(NoSuchElementException.class, executable, "Expecting NoSuchElementException.");
    }

    @DisplayName("Linked List EXTRAS - findKthNodeFromTheEnd - number out of bounds")
    @Test
    void testGetKthFromTheEnd_whenListIsEmpty_throwsIllegalArgumentException() {

        populateList(List.of(1,2,3));

        Executable executable = () -> list.getKthFromTheEnd(4);

        assertThrows(IllegalArgumentException.class, executable, "Expecting NoSuchElementException.");
    }

    @DisplayName("Linked List EXTRAS - printMiddle - even number of elements")
    @Test
    void testPrintMiddle_whenListHasEvenNumberOfElements_returnsTwoNumbers() {

        populateList(List.of(1,2,3,4,5,6));

        String result = list.printMiddle();

        assertNotNull(list, "List should not be null.");
        assertEquals("[3, 4]", result, "Result pattern doesnt match.");
    }

    @DisplayName("Linked List EXTRAS - printMiddle - odd number of elements")
    @Test
    void testPrintMiddle_whenListHasOddNumberOfElements_returnsOneNumber() {

        populateList(List.of(1,2,3,4,5));

        String result = list.printMiddle();

        assertNotNull(list, "List should not be null.");
        assertEquals("[3]", result, "Result pattern doesnt match.");
    }

    @DisplayName("Linked List EXTRAS - printMiddle - empty list")
    @Test
    void testPrintMiddle_whenListIsEmpty_returnsStringEmpty() {

        String result = list.printMiddle();

        assertNotNull(list, "List should not be null.");
        assertEquals("EMPTY", result, "Result pattern doesnt match.");
    }

    @DisplayName("Linked List EXTRAS - hasLoop")
    @Test
    void testHasLoop_whenListIsPopulated_returnsFalse() {

        populateList(List.of(1,2,3,4,5,6));

        boolean hasLoop = list.hasLoop();

        assertNotNull(list, "List should not be null.");
        assertFalse(hasLoop, "List should not have a loop.");
    }

    private void populateList(List<Integer> ls){
        ls.forEach(list::addLast);
    }
}