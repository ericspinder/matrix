package dev.inward.matrix.fact;

import com.notionds.dataSupplier.Bus;
import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.notion.Notion;
import com.notionds.dataSupplier.options.Options;

import java.io.Serializable;

public abstract class Fact<F extends Fact<F,O,B,C,U>,O extends Options<F,O,B,C,U>, B extends Bus<F,O,B,C,U,?,?,?,?>, C extends Container<F,O,B,C,U>,U extends Datum<F,O,B,C,U>> extends Notion<F,O,B,C,U> implements Comparable<F>, Serializable {

    private  criterion;
    public Fact(B bus) {
        super(bus);
    }

    @Override
    public int compareTo(F o) {
        return 0;
    }
}
