package com.notionds.dataSupplier.task;

import com.notionds.dataSupplier.advisor.Matter;

import java.time.Duration;
import java.time.Instant;

public abstract class Result<R extends Request> extends Matter<R> {


    public Result(String name, Footing footing, Locus locus, Boolean goodThing) {
        super(name, footing, locus, goodThing);
    }
}
