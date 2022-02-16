package com.notionds.dataSupplier.meta;

import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.house.House;
import com.notionds.dataSupplier.library.Library;

public final class PriorSpecification<H extends House<H,L>,L extends Library<H,L>> extends Standard<H,L,PriorSpecification<H,L>> {

    protected PriorSpecification(Id.SuperEgo<H,L> id, String version) {
        super(id, version);
    }

    @Override
    public int compareTo(PriorSpecification<H, L> that) {
        return this.getId().compareTo(that.getId());
    }
}
