package com.notionds.dataSupplier.task;

import com.notionds.dataSupplier.datum.notion.Notion;
import com.notionds.dataSupplier.datum.notion.why.Why;
import com.notionds.dataSupplier.datum.sanction.Sanction;
import com.notionds.dataSupplier.house.Ego;

public abstract class Request<D extends Notion<D,?,?,I>,I extends Ego<D,I>,S extends Sanction,W extends Request<D,I,S,W>> extends Why<S,W> {

    public Request(S sanction) {
        super(sanction);
    }
}
