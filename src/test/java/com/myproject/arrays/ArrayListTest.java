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
        assertEquals(expectedSize, size, "Array list size should be 3.");
    }


    /**
     * Verifies that the ArrayList expands its capacity when the number of added elements
     * exceeds the initial capacity. Since internal resizing logic is not directly accessible,
     * this behavior is verified indirectly by observing the ability to add elements
     * beyond the initial size without errors.
     */
    @DisplayName("Array List Expansion")
    @Test
    void testArrayListExpansion_whenInitialSizeIsExceeded() {

        int initialSize = 3;
        arrayList = new ArrayList<>(initialSize);

        populateList(List.of(1,2,3,4,5));

        boolean isGreater = arrayList.size() > initialSize;

        assertNotNull(arrayList, "Array list should not be null.");
        assertTrue(isGreater, "Array list size should be greater than initial size.");
        assertEquals(5, arrayList.size(), "Array list size should be 5.");
        
    }

    /**
     * Verifies that the ArrayList reduces its capacity when elements are removed
     * and the size falls below a threshold. This behavior is verified indirectly
     * by removing elements and ensuring that the list still behaves correctly
     * without errors or inefficiencies.
     */
    @DisplayName("Array List Shrink")
    @Test
    void testArrayListShrink_whenElementsAreRemoved() {

        int initialSize = 5;
        arrayList = new ArrayList<>(initialSize);
        populateList(List.of(1,2,3,4,5,6,7,8,9,10));

        while(arrayList.size() != 0){
            arrayList.removeAt(0);
        }

        boolean isSmaller = arrayList.size() < initialSize;

        assertNotNull(arrayList, "Array list should not be null.");
        assertTrue(isSmaller, "Array list size should be smaller than initial size.");
        assertEquals(0, arrayList.size(), "Array list size should be 0.");

    }

    private void populateList(List<Integer> list) {
        list.forEach(arrayList::insert);
    }
}