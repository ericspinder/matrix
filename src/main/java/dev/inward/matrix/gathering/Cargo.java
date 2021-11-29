package dev.inward.matrix.gathering;

import java.util.Map;

public class Cargo<K, V> implements Map.Entry<K, V> {

    private K key;
    private V value;

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public V getValue() {
        return this.value;
    }

    @Override
    public V setValue(V value) {
        return null;
    }
}
