package com.myproject.hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Miroslav Kološnjaji
 */
class HashMapTest {

    private HashMap hashMap;

    @BeforeEach
    void setUp() {
        hashMap = new HashMap();
    }

    @DisplayName("Hash Map - put")
    @Test
    void testPut_whenValidArgumentsProvided_thenPopulateHashMap() {

        hashMap.put(3, "Alex");

        assertNotNull(hashMap, "Hash map should not be null.");
        assertEquals(1, hashMap.size(), "Hash map size should be 1.");
    }

    @DisplayName("Hash Map - get")
    @Test
    void testGet_whenKeyExistsInHashMap_returnsValue() {

        populateHashMap(Map.of(1, "Alex", 2, "Sarah"));
        String exepctedValue = "Alex";
        int expectedSize = 2;


        String value = hashMap.get(1);

        assertEquals(exepctedValue, value, "Value doesn't match expected value.");
        assertEquals(expectedSize, hashMap.size(), "Hash map size should be 2.");
    }

    @DisplayName("Hash Map - get - key doesnt exists")
    @Test
    void testGet_whenKeyDoesntExistsInHashMap_returnsNull() {

        populateHashMap(Map.of(1, "Alex", 4, "Sarah"));
        int expectedSize = 2;

        String value = hashMap.get(2);

        assertNull(value, "Value should be null.");
        assertEquals(expectedSize, hashMap.size(), "Hash map size should be 2.");
    }

    @DisplayName("Hash Map - get - empty map")
    @Test
    void testGet_whenHashMapIsEmpty_returnsNull() {

        int expectedSize = 0;
        String value = hashMap.get(2);

        assertNull(value, "Value should be null.");
        assertEquals(expectedSize, hashMap.size(), "Hash map size should be 2.");
    }

    @DisplayName("Hash Map - remove")
    @Test
    void testRemove_whenKeyExistsInHashMap_thenRemoveValue() {

        populateHashMap(Map.of(1, "Alex", 2, "Sarah"));
        String exepctedValue = "Alex";
        int expectedSize = 1;

        String value = hashMap.remove(1);
        String removedValue = hashMap.get(1);

        assertEquals(exepctedValue, value, "Value doesn't match expected value.");
        assertNull(removedValue, "Removed value should not be in the map.");
        assertEquals(expectedSize, hashMap.size(), "Hash Map size should be 1 after removing value.");
    }

    @DisplayName("Hash Map - remove - key doesn't exists")
    @Test
    void testRemove_whenKeyDoesntExistsInHashMap_returnsNull() {

        populateHashMap(Map.of(1, "Alex", 2, "Sarah"));
        int expectedSize = 2;

        String value = hashMap.remove(5);

        assertNull(value, "Value should be null.");
        assertEquals(expectedSize, hashMap.size(), "Hash Map size should be 2.");
    }

    @DisplayName("Hash Map - remove - empty map")
    @Test
    void testRemove_whenHashMapIsEmpty_returnsNull() {

        int expectedSize = 0;
        String value = hashMap.remove(5);

        assertNull(value, "Value should be null.");
        assertEquals(expectedSize, hashMap.size(), "Hash Map size should be 0.");
    }

    @DisplayName("Hash Map - size")
    @Test
    void testSize_whenHashMapIsPopulated_returnsSizeOfTheHashMap() {

        populateHashMap(Map.of(1, "Alex", 2, "Sarah"));
        int expectedSize = 2;

        int size = hashMap.size();

        assertEquals(expectedSize, size, "Hash Map size should be 2.");
    }

    @DisplayName("Hash Map - isEmpty")
    @Test
    void testIsEmpty_whenHashMapIsPopulated_returnsFalse() {

        populateHashMap(Map.of(1, "Alex", 2, "Sarah"));
        int expectedSize = 2;

        boolean isEmpty = hashMap.isEmpty();

        assertFalse(isEmpty, "Method should return 'false'.");
        assertEquals(expectedSize, hashMap.size(), "Hash Map size should be 2.");
    }

    @DisplayName("Hash Map - isEmpty - empty map")
    @Test
    void testIsEmpty_whenHashMapIsEmpty_return() {

        int expectedSize = 0;
        boolean isEmpty = hashMap.isEmpty();

        assertTrue(isEmpty, "Method should return 'false'.");
        assertEquals(expectedSize, hashMap.size(), "Hash Map size should be 0.");
    }

    private void populateHashMap(Map<Integer, String> map){
        map.forEach(hashMap::put);
    }
}