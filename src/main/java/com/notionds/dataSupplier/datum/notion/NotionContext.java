package com.notionds.dataSupplier.datum.notion;

import com.notionds.dataSupplier.context.Context;
import com.notionds.dataSupplier.datum.host.RemoteHost;
import com.notionds.dataSupplier.operational.Operational;

public abstract class NotionContext<D extends Notion<D,O,C,X,?>,O extends Operational<D,O>,C extends Aspect<D,O,C,X,?,?>,X extends NotionContext<D,O,C,X>> extends Context<D,O,C,X> {

    public NotionContext(RemoteHost remoteHost, String path, String name) {
        super(context, container);
    }
}
