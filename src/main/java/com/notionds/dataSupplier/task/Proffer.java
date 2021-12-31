package com.notionds.dataSupplier.task;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.options.Options;

import java.time.Instant;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Proffer<N,O extends Options<N,W,T>,W extends Datum<N,O,T>,T extends Container<N,O,W>> extends Task<N,O,W,T> {



    public Proffer(String name, boolean doAsCleanup, Supplier<Result<N,O,W,T>> execution, Consumer<Exception> handler) {
        super(name, doAsCleanup, execution, handler);
    }

    @Override
    public Instant startTime() {
        return null;
    }
}
