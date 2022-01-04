package com.notionds.dataSupplier.datum.notion;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.datum.context.Context;
import com.notionds.dataSupplier.datum.id.SuperEgo;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.provider.Situation;
import com.notionds.dataSupplier.task.Task;

import java.util.concurrent.LinkedBlockingDeque;

public abstract class Aspect<D extends Notion<D,O,C,X,I>,O extends Operational<D,O>,C extends Aspect<D,O,C,X,I,B>,X extends Context<D,O,C,X>,I extends SuperEgo<D,O,C,X,I>,B extends Omnibus<D,O,C,X,I,B,?,?,?>> extends Container<D,O,C,X,B> {

    public Aspect(B bus) {
        this(bus,null,null);
    }
    public Aspect(B bus, Situation currentSituation, LinkedBlockingDeque<Task<?,?,?>> tasks) {
        super(bus,currentSituation,tasks);
    }
}
