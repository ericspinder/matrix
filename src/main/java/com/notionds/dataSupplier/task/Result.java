package com.notionds.dataSupplier.task;

import com.notionds.dataSupplier.subject.Matter;

public abstract class Result<R extends Request> extends Matter<R> {


    public Result(String name, Focus focus, Locus locus, Boolean goodThing) {
        super(name, focus, locus, goodThing);
    }
}
