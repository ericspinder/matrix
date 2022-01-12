package com.notionds.dataSupplier.maker;

import java.io.Serializable;

public interface Fingerprint<F extends Fingerprint<F>> extends Comparable<F>, Serializable {

    default short getConfidence() {
        return 0;
    }
}
