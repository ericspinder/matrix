package dev.inward.matrix;

import dev.inward.matrix.info.Path_ofInfo;
import dev.inward.matrix.predictable.Complication;

public class Service<K extends Info<Path_ofInfo>> implements Comparable<Service<K>> {

    protected final String name;
    protected Complication<Service<K>,K,?,?,?> complication;

    public Service(String name, Complication<Service<K>,K,?,?,?> complication) {
        this.name = name;
        this.complication = complication;
    }

    public Complication<Service<K>,K,?,?,?> getComplication() {
        return complication;
    }

    public void setComplication(Complication<Service<K>,K,?,?,?> complication) {
        this.complication = complication;
    }

    @Override
    public int compareTo(Service<K> that) {
        return this.name.compareTo(that.name);
    }
}
