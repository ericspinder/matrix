package com.notionds.dataSupplier.datum.fact;

import com.notionds.dataSupplier.datum.fact.notion.Notion;

import java.util.concurrent.locks.StampedLock;

public class Criterion<C extends Notion<C>> {

    private transient StampedLock gate = new StampedLock();
    private Class<C> cClass;
    private Version version;
    private Address address;

}
