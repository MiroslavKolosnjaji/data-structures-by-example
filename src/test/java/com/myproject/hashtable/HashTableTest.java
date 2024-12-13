package com.myproject.hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Miroslav Kološnjaji
 */
class HashTableTest {

    private HashTable hashTable;

    @BeforeEach
    void setUp() {
        hashTable = new HashTable();
    }

    @DisplayName("Hash Table - put")
    @Test
    void testAdd_whenValidArgumentsProvided_thenPopulateHashTable() {

        hashTable.put(3, "John");

        assertNotNull(hashTable, "Hash table should not be null.");
        assertEquals(1, hashTable.size(), "Hash table size should be 1.");
    }

    @DisplayName("Hash Table - get")
    @Test
    void testGet_whenValidKeyProvided_returnsValue() {

        populateHashTable(Map.of(1, "John", 5, "Alex", 9, "Sarah"));
        String expectedValue = "Alex";

        String value = hashTable.get(5);

        assertNotNull(hashTable, "Hash table should not be null.");
        assertEquals(expectedValue, value, "Value doesnt match expected value.");
        assertEquals(3, hashTable.size(), "Hash Table size should be 3.");
    }

    @DisplayName("Hash Table - get - empty hash table")
    @Test
    void testGet_whenKeyDoesntExistsInHashTable_returnsNull() {

        String value = hashTable.get(5);

        assertNull(value, "Method should return null.");
    }

    @DisplayName("Hash Table - remove")
    @Test
    void testRemove_whenValidKeyProvided_removeKeyValuePairFromTheHashTable() {

        populateHashTable(Map.of(1, "John", 5, "Alex", 9, "Sarah"));
        String expectedValue = "John";
        int expectedSize = 2;

        String value = hashTable.remove(1);
        String getRemovedValue = hashTable.get(1);

        assertEquals(expectedValue, value, "Value doesnt match expected value.");
        assertEquals(expectedSize, hashTable.size(), "Hash table size should be 2.");
        assertNull(getRemovedValue, "Value should be null.");
    }

    @DisplayName("Hash Table - remove - key doesnt exists")
    @Test
    void testRemove_whenProvidedKeyDoesntExistsInHashTable_returnsNull() {

        populateHashTable(Map.of(1, "John", 5, "Alex", 9, "Sarah"));
        int expectedSize = 3;

        String value = hashTable.remove(2);

        assertNull(value, "Value should be null.");
        assertEquals(expectedSize, hashTable.size(), "Hash table size should be 3.");
    }

    @DisplayName("Hash Table - remove - empty hash table")
    @Test
    void testRemove_whenHashTableIsEmpty_returnsNull() {

        int expectedSize = 0;

        String value = hashTable.remove(2);

        assertNull(value, "Value should be null.");
        assertEquals(expectedSize, hashTable.size(), "Hash table size should be 0.");
    }

    @DisplayName("Hash Table - size")
    @Test
    void testSize_whenHashTableIsPopulated_returnsSizeOfTheHashTable() {

        populateHashTable(Map.of(1, "John", 5, "Alex", 9, "Sarah"));
        int expectedSize = 3;

        int size = hashTable.size();

        assertEquals(expectedSize, size, "Hash Table size should be 3.");
    }

    @DisplayName("Hash Table - toString")
    @Test
    void testToString_whenHashTableIsPopulated_returnsStringRepresentationOfTheHashTable() {

        populateHashTable(Map.of(1, "John", 5, "Alex", 9, "Sarah"));
        String expectedPattern = """
                1=John
                5=Alex
                9=Sarah
                """;

        String pattern = hashTable.toString();

        assertEquals(expectedPattern, pattern, "String representation of the hash table should be the same as expected pattern.");
    }

    private void populateHashTable(Map<Integer, String> map){
        map.forEach(hashTable::put);
    }
}