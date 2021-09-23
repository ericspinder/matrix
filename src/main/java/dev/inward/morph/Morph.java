package dev.inward.morph;

import dev.inward.crud.Crudem;

import java.io.Serializable;
import java.util.EnumMap;

public abstract class Morph<V extends Comparable<V>> implements Comparable<V>, Serializable {

    protected final EnumMap<Crudem.Operation, Crudem> crudemMap;

    protected V value;


    public Morph(EnumMap<Crudem.Operation, Crudem> crudemMap) {
        this.crudemMap = crudemMap;
    }

    @Override
    public int compareTo(V o) {
        return 0;
    }
}
