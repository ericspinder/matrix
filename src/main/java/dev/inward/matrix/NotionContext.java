package dev.inward.matrix;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.host.RemoteHost;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.datum.fact.Support;
import com.notionds.dataSupplier.operational.Operational;

public abstract class NotionContext<D extends Fact<D,O,C,X,?>,O extends Operational<D,O>,C extends Support<D,O,C,X,?,?>,X extends NotionContext<D,O,C,X>> extends Context<D,O,C,X> {

    public NotionContext(RemoteHost remoteHost, String path, String name) {
        super(context, container);
    }
}
