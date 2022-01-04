package com.notionds.dataSupplier.datum.notion;

import com.notionds.dataSupplier.Bus;
import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.advisor.Advisor;
import com.notionds.dataSupplier.datum.id.SuperEgo;
import com.notionds.dataSupplier.meta.Meta;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.provider.Provider;

import java.util.UUID;

public class Omnibus<D extends Notion<D,O,C,X,I>,O extends Operational<D,O>,C extends Aspect<D,O,C,X,I,B>,X extends NotionContext<D,O,C,X>,I extends SuperEgo<D,O,C,X,I>,B extends Omnibus<D,O,C,X,I,B,A,P,M>,A extends Advisor<D,O,C,X,A,?>,P extends Provider<D,O,C,X>,M extends Meta<D>> extends Bus<D,O,C,X,B,A,P,M> {


    public Omnibus(UUID uuid, A advisor, M meta, P provider, O operational) {
        super(uuid, advisor, meta, provider, operational);
    }
}
