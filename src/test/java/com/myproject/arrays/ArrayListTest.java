package com.myproject.arrays;

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
class ArrayListTest {

    private ArrayList<Integer> arrayList;

    @BeforeEach
    void setUp() {
        arrayList = new ArrayList<>();
    }

    @DisplayName("Array List - constructor")
    @Test
    void testArrayListConstructor_withChosenSizeOfElements_returnsNewArrayList() {

        ArrayList<Integer> list = new ArrayList<>(5);

        assertNotNull(list, "Array list should not be null.");

    }

    @DisplayName("Array List - insert")
    @Test
    void testInsert_whenValidArgumentProvided_thenCorrect() {

        arrayList.insert(1);
        arrayList.insert(2);
        arrayList.insert(3);

        assertNotNull(arrayList, "Array list should not be null.");
        assertEquals(3, arrayList.size(), "Size count should be 3.");
        assertEquals("[1, 2, 3]", arrayList.toString());

    }

    @DisplayName("Array List - removeAt")
    @Test
    void testRemoveAt_whenValidIndexProvided_thenRemoveElementFromList() {

        Integer removedValue = 7;
        populateList(List.of(2, 5, 7));

        arrayList.removeAt(2);

        assertNotNull(arrayList, "Array list should not be null");
        assertEquals(2, arrayList.size(), "Size count should be 2.");
        assertFalse(arrayList.contains(removedValue), "Value " + removedValue + " should be removed from the list.");
        assertEquals("[2, 5]", arrayList.toString(), "Array list content should contains two elements.");

    }

    @DisplayName("Array List - removeAt - empty list")
    @Test
    void testRemoveAt_whenListIsEmpty_throwsNoSuchElementException() {

        Executable executable = () -> arrayList.removeAt(1);

        assertThrows(NoSuchElementException.class, executable, "Expecting NoSuchElementException");
    }

    @DisplayName("Array List - removeAt - index out of range")
    @Test
    void testRemoveAt_whenIndexIsOutOfBounds_throwsIllegalArgumentsException() {

        populateList(List.of(1));

        Executable executable = () -> arrayList.removeAt(2);

        assertThrows(IllegalArgumentException.class, executable, "Expecting IllegalArgumentException");
    }

    @DisplayName("Array List - indexOf")
    @Test
    void testIndexOf_whenValidIndexProvided_returnsIndexOfChosenElement() {

        int expectedIndex = 12;
        populateList(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 13, 15, 11, 16, 14, 12, 17, 19, 18, 20));

        int index = arrayList.indexOf(11);

        assertNotNull(arrayList, "Array list should not be null.");
        assertEquals(expectedIndex, index, "Index should match expected index.");
        assertEquals(20, arrayList.size(), "Size count should be 20");

    }

    @DisplayName("Array List - indexOf - element not found")
    @Test
    void testIndexOf_whenElementDoesntExistsInList_returnsNegativeNumber() {

        int expectedIndex = -1;

        int index = arrayList.indexOf(1);

        assertEquals(0, arrayList.size(), "Size count should be 0.");
        assertEquals(expectedIndex, index, "index should be -1.");

    }

    @DisplayName("Array List - lastIndexOf")
    @Test
    void testLastIndexOf_whenListContainsElement_returnsLastIndexOf() {

        int expectedIndex = 1;
        populateList(List.of(1,2,3));

        int index = arrayList.lastIndexOf(2);

        assertNotNull(arrayList, "Array list should not be null.");
        assertEquals(3, arrayList.size(), "Size count should be 3.");
        assertEquals(expectedIndex, index, "Index should match expected index.");
    }

    @DisplayName("Array List - lastIndexOf - element not found")
    @Test
    void testLastIndexOf_whenElementDoesntExistsInList_returnsNegativeNumber() {

        int expectedIndex = -1;
        populateList(List.of(1,2,3));

        int index = arrayList.lastIndexOf(4);

        assertNotNull(arrayList, "Array list should not be null.");
        assertEquals(3, arrayList.size(), "Size count should be 3.");
        assertEquals(expectedIndex, index, "Index should match expected index.");
    }

    @DisplayName("Array List - contains")
    @Test
    void testContains_whenListContainsElement_returnsTrue() {

        populateList(List.of(1,2,4));

        boolean isTrue = arrayList.contains(4);

        assertNotNull(arrayList, "Array list should not be null");
        assertTrue(isTrue, "Method should return true.");
    }

    @DisplayName("Array List - contains - element not found")
    @Test
    void testContains_whenElementDoesntExistsInList_returnsFalse() {

        populateList(List.of(1,2,4));

        boolean isTrue = arrayList.contains(3);

        assertNotNull(arrayList, "Array list should not be null");
        assertFalse(isTrue, "Method should return fa    .");
    }


    @DisplayName("Array List - size")
    @Test
    void testSize_whenListIsPopulated_returnsSizeOfTheList() {

        populateList(List.of(1,2,3));
        int expectedSize = 3;

        int size = arrayList.size();

        assertNotNull(arrayList, "Array list should not be null.");
        assertEquals(expectedSize, size, "Size count should be 3.");
    }

    private void populateList(List<Integer> list) {
        list.forEach(arrayList::insert);
    }
}