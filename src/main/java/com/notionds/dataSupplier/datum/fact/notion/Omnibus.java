package com.notionds.dataSupplier.datum.fact.notion;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Bus;
import com.notionds.dataSupplier.advisor.Advisor;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.datum.fact.Support;
import com.notionds.dataSupplier.meta.Meta;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.provider.Provider;

public class Omnibus<N extends Notion<N,O,I,X>,O extends Operational<N,O>,I extends Id<I,X>,X extends Context<X>> extends Bus<N,O,I,X,Omnibus<N,O,I,X>> {

    protected Manager[] managers;
    public Omnibus(O operational,Advisor[] advisors, Manager[] managers) {
        super(operational, advisors);
        this.managers = managers;
    }
}
