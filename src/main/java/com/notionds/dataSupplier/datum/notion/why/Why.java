package com.notionds.dataSupplier.datum.notion.why;

import com.notionds.dataSupplier.datum.sanction.Sanction;
import com.notionds.dataSupplier.meta.Meta;

import java.io.Serializable;

public abstract class Why<S extends Sanction,W extends Why<S,W>> implements Comparable<Why<S,W>>, Serializable {

    private S sanction;

    public Why(S sanction) {
        this.sanction = sanction;
    }

}
