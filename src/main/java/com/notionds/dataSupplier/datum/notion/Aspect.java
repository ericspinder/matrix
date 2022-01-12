package com.notionds.dataSupplier.datum.notion;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.datum.notion.fact.Id;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.task.Task;

import java.util.concurrent.LinkedBlockingDeque;

public abstract class Aspect<D extends Notion<D,O,C,I>,O extends Operational<D,O>,C extends Aspect<D,O,C,I,B>,I extends Id<D,I>,B extends Omnibus<D,O,C,I,B,?,?,?>> extends Container<D,O,C,I,B> {

    public Aspect(B bus) {
        this(bus,null,null);
    }
    public Aspect(B bus, State currentState, LinkedBlockingDeque<Task<?,?,?>> tasks) {
        super(bus, currentState,tasks);
    }

}
