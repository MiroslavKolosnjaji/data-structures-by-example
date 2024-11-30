package com.myproject.hashtable;

import java.util.LinkedList;
import java.util.Objects;

/**
 * @author Miroslav Kološnjaji
 * @date 27.12.2023
 */
public class HashTable {

    LinkedList<Entry>[] list;

    public HashTable() {
        this.list = new LinkedList[10];
    }

    public void put(int key, String value) {
        var entry = new Entry(key, value);
        int index = hashCode(key);

        if (list[index] == null) {
            list[index] = new LinkedList<>();
        }

        for (var entry : list[index]){
            if(entry.getKey() == key){
                entry.setValue(value);
                return;
            }
        }

        list[index].addLast(entry);
    }

    public String get(int key) {
        int index = hashCode(key);
        return list[index].getLast().getValue();
    }

    public void remove(int key) {
        int index = hashCode(key);

        if (list[index] == null)
            throw new IllegalArgumentException();

        list[index].clear();
    }

    private String getItems(){
        StringBuffer sb = new StringBuffer();
        for(var item : list){
            if(item != null && !item.isEmpty()){
                sb.append(item.getLast() + "\n");;
            }
        }
        return sb.toString();
    }

    private int hashCode(int key) {
        return key % list.length;
    }

    @Override
    public String toString() {
        return getItems();
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return key == entry.key && Objects.equals(value, entry.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }
}
