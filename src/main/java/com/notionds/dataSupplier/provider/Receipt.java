package com.notionds.dataSupplier.provider;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.Promise;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.context.Context;
import com.notionds.dataSupplier.datum.notion.fact.Id;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.task.Task;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.time.Instant;
import java.util.Map;

public class Receipt<D extends Datum<D,O,C,I>,O extends Operational<D,O>,C extends Container<D,O,C,I,?>,I extends Id<D,I>> extends SoftReference<D> {

    private final Map<Task, Instant> taskMap;

    public Receipt(D datum, ReferenceQueue<? super D> referenceQueue, Map<Task, Instant> taskMap) {
        super(datum, referenceQueue);
        this.taskMap = taskMap;
    }


    public Map<Task,Instant> getTaskMap() {
        return this.taskMap;
    }

}
