package com.notionds.dataSupplier;

import com.notionds.dataSupplier.datum.Datum;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;

public abstract class Promise<D extends Datum<D,?,?,?>, M extends Maker<M,?,?,?>, P extends Promise<D,M,P>> implements Comparable<P>, Serializable {

    private final M maker;
    private Instant instantReady;
    private Duration durationAvailable;
    public Promise(M maker) {
        this.maker = maker;
    }

    public final M getMaker() {
        return this.maker;
    }
}
