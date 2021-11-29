package dev.inward.matrix.gathering;

import dev.inward.matrix.Addressable;
import dev.inward.matrix.model.Model;

import java.io.Serializable;
import java.util.List;

public abstract class Gathering<UM extends Comparable<UM> & Serializable, K, V extends Comparable<V> & Serializable> implements Addressable<UM> {

    public abstract List<V> getAll();

    public abstract <M extends Model<?, ?>> List<V> get(M model);
}
