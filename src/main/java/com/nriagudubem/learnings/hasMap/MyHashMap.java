package com.nriagudubem.learnings.hasMap;

import com.nriagudubem.learnings.hasMap.MyEntry;

import java.lang.reflect.Array;

public class MyHashMap<K, V> {

    private MyEntry<K, V>[] myEntries;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        myEntries = (MyEntry<K, V>[]) Array.newInstance(MyEntry.class, 10);
    }

    public MyEntry<K, V>[] getMyEntries() {
        return myEntries;
    }

    public void put(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Map key or value cannot be null");
        }
        int index = getIndex(key);
        if (myEntries[index] == null) {
            myEntries[index] = new MyEntry<K, V>(key, value, null);
        } else {
            MyEntry<K, V> entry = myEntries[index];
            while (entry.getNext() != null) {
                entry = entry.getNext();
            }
            entry.setNext(new MyEntry<K, V>(key, value, null));
        }
    }

    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Map key cannot be null");
        }
        int index = getIndex(key);
        MyEntry<K, V> entry = myEntries[index];

        if (entry == null) {
            return null;
        }

        while (true) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
            if (entry.getNext() == null) {
                break;
            }
            entry = entry.getNext();
        }

        return null;
    }

    private int getIndex(K key) {
        int hashCode = key.hashCode();
        return (hashCode % myEntries.length);
    }
}
