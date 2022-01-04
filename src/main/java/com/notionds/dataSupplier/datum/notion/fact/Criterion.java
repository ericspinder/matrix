package com.notionds.dataSupplier.datum.notion.fact;

import java.util.concurrent.locks.StampedLock;

public class Criterion<C extends Fact<C>> {

    private transient StampedLock gate = new StampedLock();
    private Class<C> cClass;
    private Version version;
    private Address address;

}
