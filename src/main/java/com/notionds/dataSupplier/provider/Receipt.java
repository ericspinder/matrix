package com.notionds.dataSupplier.provider;

import com.notionds.dataSupplier.Bus;
import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.options.Options;
import com.notionds.dataSupplier.task.Task;

import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.time.Instant;
import java.util.Map;

public class Receipt<DATUM extends Comparable<DATUM> & Serializable,O extends Options<DATUM,O,B,C,U>,B extends Bus<DATUM,O,B,C,U,?,?,?,?>, C extends Container<DATUM,O,B,C,U>,U extends Datum<DATUM,O,B,C,U>> extends SoftReference<U> {

    private final Map<Task, Instant> taskMap;
    private final Instant nextExecutionTime;

    public Receipt(U datum, Map<Task, Instant> taskMap, Instant nextExecutionTime) {
        super(datum);
        this.taskMap = taskMap;
        this.nextExecutionTime = nextExecutionTime;
    }

    public Receipt(U datum, ReferenceQueue<? super U> referenceQueue, Map<Task, Instant> taskMap, Instant nextExecutionTime) {
        super(datum, referenceQueue);
        this.taskMap = taskMap;
        this.nextExecutionTime = nextExecutionTime;
    }

    public Instant getNextExecutionTime() {
        return nextExecutionTime;
    }

    public Map<Task,Instant> getTaskMap() {
        return this.taskMap;
    }

}
