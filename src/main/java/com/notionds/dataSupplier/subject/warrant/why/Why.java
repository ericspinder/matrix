package com.notionds.dataSupplier.subject.warrant.why;

import com.notionds.dataSupplier.subject.sanction.Sanction;

import java.io.Serializable;

public abstract class Why<S extends Sanction,W extends Why<S,W>> implements Comparable<Why<S,W>>, Serializable {

    private S sanction;

    public Why(S sanction) {
        this.sanction = sanction;
    }

}
