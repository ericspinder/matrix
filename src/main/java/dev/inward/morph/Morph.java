package dev.inward.morph;

import dev.inward.crud.Read;
import dev.inward.crud.Update;

public abstract class Morph<V extends Comparable<V>, C extends Crud<V, ?, ?, ? ,?>> {

    private Map<>
    private Read<V> read;
    private Update<V> update;
    private V value;


}
