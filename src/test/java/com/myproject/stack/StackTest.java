package com.myproject.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Miroslav Kološnjaji
 */
class StackTest {

    private Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>();
    }

    @DisplayName("Stack - push")
    @Test
    void testPush_whenValidArgumentProvided_thenCorrect() {

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertNotNull(stack, "Stack should not be null.");
        assertEquals(3, stack.size(), "Stack size should be 3.");
    }

    @DisplayName("Stack - push - stack is full")
    @Test
    void testPush_whenStackLimitReached_throwsStackOverflowException() {

         stack = new Stack<>(3);

         populateStack(List.of(1,2,3));

        Executable executable = () -> stack.push(4);

        assertThrows(StackOverflowError.class, executable, "Expected StackOverflowError exception.");
    }

    @DisplayName("Stack - pop")
    @Test
    void testPop_whenStackIsPopulated_removeLastElementFromTheStackAndReturns() {

        populateStack(List.of(1,2,3,4));
        int expectedValue = 4;

        int value = stack.pop();

        assertNotNull(stack, "Stack should not be null.");
        assertEquals(3, stack.size(), "Stack size should be 3 after the pop method is called.");
        assertEquals(expectedValue, value, "Value doesn't match expected value.");
    }

    @DisplayName("Stack - pop - empty stack")
    @Test
    void testPop_whenStackIsEmpty_throwsIllegalStateException() {

        Executable executable = () -> stack.pop();

        assertThrows(IllegalStateException.class, executable, "Expected IllegalStateException.");
    }

    @DisplayName("Stack - peek")
    @Test
    void testPeek_whenStackIsNotEmpty_returnsLastElement() {

        populateStack(List.of(1,2,3,4,5));
        int expectedValue = 5;

        int value = stack.peek();

        assertNotNull(stack, "Stack should not be null.");
        assertEquals(5, stack.size(), "Stack size should be 5");
        assertEquals(expectedValue, value, "Value doesn't match expected value.");

    }

    @DisplayName("Stack - peek - empty stack")
    @Test
    void testPeek_whenStackIsEmpty_throwsIllegalStateException() {

        Executable executable = () -> stack.peek();

        assertThrows(IllegalStateException.class, executable, "Expected IllegalStateException.");
    }

    @DisplayName("Stack - size")
    @Test
    void testSize_whenStackIsPopulated_returnsSizeOfTheStack() {

        populateStack(List.of(1,2,3,4,5));
        int expectedSize = 5;

        int size = stack.size();

        assertNotNull(stack, "Stack should not be null.");
        assertEquals(expectedSize, size, "Stack size should be equal to expected size.");
    }

    @DisplayName("Stack - isEmpty")
    @Test
    void testIsEmpty_whenStackIsPopulated_returnsFalse() {

        populateStack(List.of(1));

        boolean isEmpty = stack.isEmpty();

        assertNotNull(stack, "Stack should not be null.");
        assertFalse(isEmpty, "Expected value should be 'false'");
    }

    @DisplayName("Stack - isEmpty - empty stack")
    @Test
    void testIsEmpty_whenStackIsEmpty_returnsFalse() {


        boolean isEmpty = stack.isEmpty();

        assertNotNull(stack, "Stack should not be null.");
        assertTrue(isEmpty, "Expected value should be 'false'");
    }

    @DisplayName("Stack - toString")
    @Test
    void testToString_whenStackIsNotEmpty_returnsElements() {

        populateStack(List.of(1,2,3,4));

        String elements = stack.toString();

        assertNotNull(stack, "Stack should not be null.");
        assertEquals("[1, 2, 3, 4]", elements, "Pattern doesnt match expected pattern.");
    }

    private void populateStack(List<Integer> list){
        list.forEach(stack::push);
    }
}