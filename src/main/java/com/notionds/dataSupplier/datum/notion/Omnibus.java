package com.notionds.dataSupplier.datum.notion;

import com.notionds.dataSupplier.datum.Bus;
import com.notionds.dataSupplier.advisor.Advisor;
import com.notionds.dataSupplier.datum.notion.fact.Id;
import com.notionds.dataSupplier.meta.Meta;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.provider.Provider;

public class Omnibus<D extends Notion<D,O,C,I>,O extends Operational<D,O>,C extends Aspect<D,O,C,I,B>,I extends Id<D,I>,B extends Omnibus<D,O,C,I,B,A,P,M>,A extends Advisor<D,O,C,I,A,?>,P extends Provider<D,O,C,I>,M extends Meta<D>> extends Bus<D,O,C,I,B,A,P,M> {

    public Omnibus(A advisor, M meta, P provider, O operational) {
        super(advisor, meta, provider, operational);
    }
}
