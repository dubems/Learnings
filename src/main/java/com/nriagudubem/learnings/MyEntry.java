package com.nriagudubem.learnings;

public class MyEntry<K, V> {

    private K key;

    private V value;

    MyEntry<K, V> getNext() {
        return next;
    }

    void setNext(MyEntry<K, V> next) {
        this.next = next;
    }

    private MyEntry<K, V> next;

    MyEntry(K key, V value, MyEntry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
