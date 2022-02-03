package com.notionds.dataSupplier.datum.fact.notion;

import com.notionds.dataSupplier.datum.fact.Support;
import com.notionds.dataSupplier.house.Ego;
import com.notionds.dataSupplier.operational.Operational;
import dev.inward.matrix.gathering.Lexicon;
import dev.inward.matrix.setting.Gate;

public class Aspect<D extends Notion<D,O,C,I>,O extends Operational<D,O>,C extends Aspect<D,O,C,I,B>,I extends Ego<?,?,I,?>,B extends Omnibus<D,O,C,I,B,?,?,?>> extends Support<D,O,C,I,B> {

    private Lexicon<D> lexicon;

    public Aspect(B omnibus, Gate gate, Lexicon<D> lexicon) {
        super(omnibus, gate);
        this.lexicon = lexicon;
    }

    @Override
    public int compareTo(C that) {
        return 0;
    }
}
