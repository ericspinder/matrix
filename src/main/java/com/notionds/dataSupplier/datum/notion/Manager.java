package com.notionds.dataSupplier.datum.notion;

import com.notionds.dataSupplier.Factory;
import com.notionds.dataSupplier.advisor.Advisor;
import com.notionds.dataSupplier.datum.id.SuperEgo;
import com.notionds.dataSupplier.datum.notion.warrant.Warrant;
import com.notionds.dataSupplier.operational.Operational;

public abstract class Manager<D extends Notion<D,O,C,X,I>,O extends Operational<D,O>, C extends Aspect<D,O,C,X,I,?>,X extends NotionContext<D,O,C,X>,I extends SuperEgo<D,O,C,X,I>,A extends Manager<D,O,C,X,I,A,F>, F extends Factory<D,O,?,?,?,F>> extends Advisor<D,O,C,X,A,F> {

    public Manager(F factory) {
        super(factory);
    }

    public abstract void escalate(Warrant<D,O,C,X> warrant) throws ;
}
