package com.notionds.dataSupplier.operational.task;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.delegation.Wrapper;
import com.notionds.dataSupplier.operational.Operational;

import java.time.Instant;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Proffer<N,O extends Operational<N,W,T>,W extends Wrapper<N,O,T>,T extends Container<N,O,W>> extends Task<N,O,W,T> {



    public Proffer(String name, boolean doAsCleanup, Supplier<Result<N,O,W,T>> execution, Consumer<Exception> handler) {
        super(name, doAsCleanup, execution, handler);
    }

    @Override
    public Instant startTime() {
        return null;
    }
}
