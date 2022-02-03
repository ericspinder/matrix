package com.notionds.dataSupplier.datum.fact.notion;

import com.notionds.dataSupplier.datum.Bus;
import com.notionds.dataSupplier.advisor.Advisor;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.datum.fact.Support;
import com.notionds.dataSupplier.house.Ego;
import com.notionds.dataSupplier.meta.Meta;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.provider.Provider;

public class Omnibus<D extends Fact<D,O,C,I>,O extends Operational<D,O>,C extends Support<D,O,C,I,B>,I extends Ego<?,I,?>,B extends Omnibus<D,O,C,I,B,A,P,M>,A extends Advisor<D,O,C,I,A>,P extends Provider<D,O,C,I,P>,M extends Meta<D,M>> extends Bus<D,O,C,I,B,A,P,M> {

    public Omnibus(M meta, O operational,A advisor, P provider) {
        super(meta, operational,advisor, provider);
    }
}
