package com.notionds.dataSupplier.task;

import com.notionds.dataSupplier.subject.Subject;

public abstract class Result<R extends Request> extends Subject<R> {


    public Result(String name, Focus focus, Locus locus, Boolean goodThing) {
        super(name, focus, locus, goodThing);
    }
}
