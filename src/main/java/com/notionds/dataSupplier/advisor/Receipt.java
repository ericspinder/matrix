package com.notionds.dataSupplier.advisor;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.task.Task;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.time.Instant;
import java.util.Map;

public class Receipt<N, O extends Operational<N,W,T>, W extends Datum<N,O,T>, T extends Container<N,O,W>> extends SoftReference<W> {

    private final Map<Task, Instant> taskMap;
    private final Instant nextExecutionTime;

    public Receipt(W wrapper, Map<Task, Instant> taskMap, Instant nextExecutionTime) {
        super(wrapper);
        this.taskMap = taskMap;
        this.nextExecutionTime = nextExecutionTime;
    }

    public Receipt(W wrapper, ReferenceQueue<? super W> referenceQueue, Map<Task, Instant> taskMap, Instant nextExecutionTime) {
        super(wrapper, referenceQueue);
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
