package com.notionds.dataSupplier.task;

import com.notionds.dataSupplier.Bus;
import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.Id;
import com.notionds.dataSupplier.datum.context.Context;
import com.notionds.dataSupplier.datum.notion.Notion;
import com.notionds.dataSupplier.datum.notion.why.Why;
import com.notionds.dataSupplier.operational.Operational;

public class Request<D extends Notion<D,O,C,X,I,B>,O extends Operational<D,O>,C extends Container<D,O,C,?,?,?>,X extends Context<D,O,C,X>,I extends Id<D,O,C,X,I>,B extends Bus<D,O,C,D,B,?,?,?,?>> extends Why<> {
}
