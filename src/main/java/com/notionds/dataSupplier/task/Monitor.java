package com.notionds.dataSupplier.task;

import com.notionds.dataSupplier.subject.Matter;
import com.notionds.dataSupplier.provider.Envoy;

import java.lang.ref.ReferenceQueue;
import java.time.Duration;
import java.time.Instant;

public class Monitor<T extends Task,M extends Matter> extends Envoy<T> {

    private final Instant stagedTime;
    private Instant startTime;
    private Duration duration;
    private Matter matter;
    public Monitor(Instant stagedTime,T task, ReferenceQueue referenceQueue) {
        super(task);
        this.stagedTime = stagedTime;
    }

}
