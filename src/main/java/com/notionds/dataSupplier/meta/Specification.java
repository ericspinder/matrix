package com.notionds.dataSupplier.meta;

import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.house.House;
import com.notionds.dataSupplier.library.Library;

public final class Specification<H extends House<H>,L extends Library<L,?>> extends Standard<H,L,Specification<H,L>> {

    //private final Endorsement[] endorsements;

    public Specification(Id.SuperEgo<H,L> id, String version) {
        super(id, version);
    }

    @Override
    public int compareTo(Specification<H,L> o) {
        return 0;
    }
}
