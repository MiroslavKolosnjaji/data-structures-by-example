package com.myproject.hashtable;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @author Miroslav Kološnjaji
 * @date 2
 */
public class HashMap {

    /*
     * Build a hash table from scratch. Use linear probing for handling collisions. Implement the following operations:
     * - put(int, String)
     * - get(int)
     * - remove(int)
     * - size()
     * */


    private Entry[] entries;
    private int size;

    public HashMap() {
        this.entries = new Entry[5];
    }

    public void put(int key, String value) {
        int index = hash(key);

        if (entries[index] == null) {
            entries[index] = new Entry(key, value);

        } else {
            for (int i = index; i < entries.length; i++) {
                if (entries[i] == null) {
                    entries[i] = new Entry(key, value);
                    break;
                }
            }
        }
        size++;
    }

    public String get(int key) {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        for (Entry e : entries) {
            if (e != null && e.getKey() == key) {
                return e.getValue();

            }
        }
        return null;
    }

    public String remove(int key) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        String value = null;
        for (int i = 0; i < entries.length; i++) {

            if (entries[i] == null) continue;

            if (entries[i].getKey() == key) {
                value = entries[i].getValue();
                entries[i] = null;
                break;
            }
        }
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    private int hash(int key) {
        return key % entries.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(entries);
    }

    private class Entry {

        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

}
