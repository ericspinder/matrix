package com.notionds.dataSupplier.datum.notion.fact;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.context.Context;
import com.notionds.dataSupplier.datum.id.SuperEgo;
import com.notionds.dataSupplier.datum.notion.Aspect;
import com.notionds.dataSupplier.datum.notion.Notion;
import com.notionds.dataSupplier.datum.notion.NotionContext;
import com.notionds.dataSupplier.operational.Operational;


public abstract class Fact<D extends Fact<D,I>,I extends Id<D,I>> extends Notion<D, Fact.Operational,Fact.Container,I> {

    private class Operational extends com.notionds.dataSupplier.operational.Operational<D,Fact.Operational> {

    }
    private class Container extends com.notionds.dataSupplier.Container<D,Fact.Container> {

    }

    private final E driver;

    public Fact(E driver, I id, C container) {
        super(id,container);
    }

}
