package dev.inward.matrix;

import dev.inward.matrix.*;
import dev.inward.matrix.fact.*;

import javax.annotation.Nullable;
import java.lang.invoke.CallSite;
import java.nio.file.attribute.FileAttributeView;
import java.util.concurrent.locks.StampedLock;

public abstract class Aspect implements Meta_I, Comparable<Aspect> {

    protected final String label;
    protected final String description;

    public Aspect(String label, String description) {
        this.label = label;
        this.description = description;
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public int compareTo(Aspect that) {
        return this.label.compareTo(that.label);
    }
}

