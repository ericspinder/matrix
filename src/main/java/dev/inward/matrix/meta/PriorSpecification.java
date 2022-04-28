package dev.inward.matrix.meta;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.house.House;

public final class PriorSpecification<H extends House<H,?,?>,L extends Factory<L>> extends Standard<H,L,PriorSpecification<H,L>> {

    protected PriorSpecification(Identity.SuperEgo<H,L> id, L library, String version) {
        super(id,library,version);
    }

    @Override
    public int compareTo(PriorSpecification<H, L> that) {
        return this.getId().compareTo(that.getId());
    }
}
