package dev.inward.matrix.setting;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.dataSupplier.Unspoken;
import dev.inward.matrix.matter.sanction.Sanction;

import java.io.Serializable;

public abstract class Setting<I extends Identity<I,X>,X extends Context<X>,ION extends Sanction,S extends Setting<I,X,ION,S>> implements Comparable<S>, Serializable, Identity.Addressable<L,I,X> {

    protected final I id;
    @Unspoken
    protected ION sanction;

    public Setting(I id, ION sanction) {
        this.id = id;
    }

    @Override
    public int compareTo(S that) {
        return this.id.compareTo(that.id);
    }

    public final I getId() {
        return this.id;
    }
    public void setSanction(ION sanction) {
        this.sanction = sanction;
    }
    public ION getSanction() {
        return this.sanction;
    }
}
