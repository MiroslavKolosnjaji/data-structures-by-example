package com.myproject.stack;

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
class LinkedStackTest {

    private LinkedStack<Integer> linkedStack;

    @BeforeEach
    void setUp() {
        linkedStack = new LinkedStack<>();
    }

    @DisplayName("Linked Stack - push")
    @Test
    void testPush_whenValidArgumentProvided_thenPopulateStack() {

        linkedStack.push(1);

        assertNotNull(linkedStack, "Linked Stack should not be null.");
        assertFalse(linkedStack.isEmpty(), "Linked Stack should not be empty.");
        assertEquals("[1]", linkedStack.toString(), "String representation pattern of Linked Stack should be equal as expected pattern.");
    }

    @DisplayName("Linked Stack - pop")
    @Test
    void testPop_whenLinkedStackIsPopulated_removeTopElement() {

        populateLinkedStack(List.of(1,2,3));
        int expectedValue = 3;

        int removedValue = linkedStack.pop();

        assertNotNull(linkedStack, "Linked Stack should not be null.");
        assertFalse(linkedStack.isEmpty(), "Linked Stack should not be empty.");
        assertEquals(2, linkedStack.size(), "Linked Stack size should be 2.");
        assertEquals(expectedValue, removedValue, "Removed value should be 3.");
    }

    @DisplayName("Linked Stack - pop - empty stack")
    @Test
    void testPop_whenLinkedStackIsEmpty_throwsNoSuchElementException() {

        Executable executable = () -> linkedStack.pop();

        assertThrows(NoSuchElementException.class, executable, "Expected NoSuchElementException.");
    }

    @Test
    void testPeek_whenLinkedStackIsPopulated_returnsLastElement() {

        populateLinkedStack(List.of(1,2,3));
        int expectedValue = 3;

        int value = linkedStack.peek();

        assertNotNull(linkedStack, "Linked Stack should not be null.");
        assertFalse(linkedStack.isEmpty(), "Linked Stack should not be empty.");
        assertEquals(3, linkedStack.size(), "Linked Stack size should be 3.");
        assertEquals(expectedValue, value, "Expected value should be 3.");
    }

    private void populateLinkedStack(List<Integer> list){
        list.forEach(linkedStack::push);
    }
}