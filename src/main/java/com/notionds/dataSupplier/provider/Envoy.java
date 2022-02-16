package com.notionds.dataSupplier.provider;

import com.notionds.dataSupplier.container.Container;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.task.Task;

import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.time.Instant;
import java.util.Map;

public final class Envoy<D extends Datum<?,D,O,C,I>,O extends Operational<D,O>,C extends Container<D,O,C,I>,I extends Id<?,?,I,?>, PAR extends Fact<PAR,?,?,PI>,PI extends Id.Ego<?,?,PI,?>> extends SoftReference<D> implements Comparable<Envoy<D,O,C,I,PAR,PI>>, Serializable {

    private final Map<Task, Instant> taskMap;
    private final PAR parent;

    public Envoy(D datum, ReferenceQueue<? super D> referenceQueue, Map<Task, Instant> taskMap, PAR parent) {
        super(datum, referenceQueue);
        this.taskMap = taskMap;
        this.parent = parent;
    }


    public Map<Task,Instant> getTaskMap() {
        return this.taskMap;
    }

    @Override
    public int compareTo(Envoy<D,O,C,I,PAR,PI> that) {
        int result = this.parent.compareTo(that.parent);
        if (result == 0) {
            if (this.equals(that)) {
                return 0;
            }
            return -1;
        }
        return result;
    }

    public PAR getParent() {
        return this.parent;
    }
}
