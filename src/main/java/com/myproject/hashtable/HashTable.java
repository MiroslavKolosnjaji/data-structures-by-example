package com.myproject.hashtable;

import java.util.LinkedList;
import java.util.Objects;

/**
 * @author Miroslav Kološnjaji
 * @date 27.12.2023
 */
public class HashTable {

    private final LinkedList<Entry>[] list;
    private int size;

    public HashTable() {
        this.list = new LinkedList[10];
    }

    public void put(int key, String value) {
        var entry = new Entry(key, value);
        int index = hashCode(key);

        if (list[index] == null) {
            list[index] = new LinkedList<>();
        }

        for (var e : list[index]){
            if(e.getKey() == key){
                e.setValue(value);
                return;
            }
        }

        list[index].addLast(entry);
        size++;
    }

    public String get(int key) {
        int index = hashCode(key);
        return list[index] == null ? null : list[index].isEmpty() ? null : list[index].getLast().getValue();
    }

    public String remove(int key) {
        int index = hashCode(key);

        if (list[index] == null || list[index].isEmpty())
            return null;

        String value = list[index].getLast().getValue();
        list[index].clear();
        size--;

        return value;
    }

    public int size(){
        return size;
    }

    private String getItems(){
        StringBuilder sb = new StringBuilder();
        for(var item : list){
            if(item != null && !item.isEmpty()){
                sb.append(item.getLast()).append("\n");;
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

    private static class Entry {

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
