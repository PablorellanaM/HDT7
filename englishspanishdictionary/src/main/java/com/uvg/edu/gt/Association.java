package com.uvg.edu.gt;

public class Association<K extends Comparable<K>, V> implements Comparable<Association<K, V>> {
    private K key;
    private V value;

    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public int compareTo(Association<K, V> o) {
        return this.getKey().compareTo(o.getKey());
    }

    @Override
    public String toString() {
        return "(" + key + " " + value + ")";
    }
}
