package dev.inward.matrix.fact.authoritative;

import dev.inward.matrix.Meta_I;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class Reachable<S extends Reachable<S>> implements Comparable<S>, Meta_I {

    protected final String label;
    protected final String description;
    protected Boolean open;


    protected Reachable(@Nonnull String label, @Nullable String description, @Nullable Boolean open) {
        this.label = label;
        this.description = description;
        this.open = open;
    }
    protected abstract Boolean init();
    public abstract boolean canReopen();

    public Boolean isOpen() {
        if (open == null) {
            return this.init();
        }
        return this.open;
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
    public int compareTo(Reachable o) {
        return 0;
    }

}
