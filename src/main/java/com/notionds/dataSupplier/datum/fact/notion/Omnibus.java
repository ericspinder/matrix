package com.notionds.dataSupplier.datum.fact.notion;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Bus;
import com.notionds.dataSupplier.advisor.Advisor;

public class Omnibus<N extends Notion<N,I,X,?,?,?,?>,I extends Id<I,X>,X extends Context<X>> extends Bus<N,I,X,Omnibus<N,I,X>,> {

    protected Manager[] managers;
    public Omnibus(Advisor[] advisors, Manager[] managers) {
        super(advisors);
        this.managers = managers;
    }
}
