package dev.inward.matrix.fact.setting;

import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.matter.sanction.Sanction;
import dev.inward.matrix.Context;
import dev.inward.matrix.fact.authoritative.notion.concept.dataSupplier.Unspoken;

public abstract class Setting<S extends Setting<S,I,X,ION>,I extends Identity<I,X>,X extends Context<X>,ION extends Sanction> extends Fact<S,I,X> {

    @Unspoken
    protected ION sanction;

    public Setting(I id, ION sanction) {
        super(id);
        this.sanction = sanction;
    }

    public void setSanction(ION sanction) {
        this.sanction = sanction;
    }
    public ION getSanction() {
        return this.sanction;
    }
}
