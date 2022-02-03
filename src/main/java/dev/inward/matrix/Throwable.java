package dev.inward.matrix;

import com.notionds.dataSupplier.container.Container;
import com.notionds.dataSupplier.container.Phase;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.subject.sanction.Sanction;
import com.notionds.dataSupplier.subject.Subject;
import com.notionds.dataSupplier.operational.Operational;

public class Throwable<D extends Datum<D,O,C,I>,O extends Operational<D,O>, C extends Container<D,O,C,I,?>,I extends Id<D,I>, S extends Sanction<S,?,?,?,?>, M extends Throwable<D,O,C,I,S,M,T>,T extends java.lang.Throwable> extends Subject<D,O,C,I,S,M> {

    private final T throwable;

    public Throwable(String name, S sanction, Focus focus, Locus locus, T throwable) {
        super(name, sanction,focus,locus,Phase.Manic);
        this.throwable = throwable;
    }

}
