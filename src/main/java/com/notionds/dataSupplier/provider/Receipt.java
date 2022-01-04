package com.notionds.dataSupplier.provider;

import com.notionds.dataSupplier.Bus;
import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.Promise;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.context.Context;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.task.Task;

import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.time.Instant;
import java.util.Map;

public class Receipt<D extends Datum<D,O,C,X>,O extends Operational<D,O>,C extends Container<D,O,C,X,?>,X extends Context<D,O,C,X>> extends SoftReference<D> {

    private final Map<Task, Instant> taskMap;
    private final Promise promise;

    public Receipt(D datum, ReferenceQueue<? super D> referenceQueue, Map<Task, Instant> taskMap, Promise) {
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
