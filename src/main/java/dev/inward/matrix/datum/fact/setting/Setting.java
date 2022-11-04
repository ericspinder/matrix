package dev.inward.matrix.datum.fact.setting;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.dataSupplier.Unspoken;
import dev.inward.matrix.datum.fact.matter.sanction.Sanction;

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
