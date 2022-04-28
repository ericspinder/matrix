package dev.inward.matrix.meta;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.house.House;
import dev.inward.matrix.matter.sanction.Notarized;

public final class Specification<H extends House<H,?,?>,L extends Factory<L>> extends Standard<H,L,Specification<H,L>> {

    private Notarized[] notarizedArray;

    public Specification(Identity.SuperEgo<H,L> id, L library, String version, Notarized<H,L,?,?>[] notarizedArray) {
        super(id,library,version);
        this.notarizedArray = notarizedArray;
    }

    @Override
    public int compareTo(Specification<H,L> that) {
        return that.getId().compareTo(that.getId());
    }
}
