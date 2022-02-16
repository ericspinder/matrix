package com.notionds.dataSupplier.datum.fact.notion;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Bus;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.datum.fact.Support;
import com.notionds.dataSupplier.meta.Meta;
import com.notionds.dataSupplier.operational.Operational;
import dev.inward.matrix.gathering.Lexicon;
import com.notionds.dataSupplier.setting.Track;

public class Aspect<N extends Notion<N,O,I,X>,O extends Operational<N,O>,I extends Id<I,X>,X extends Context<X>> extends Support<N,O,Aspect<N,O,I,X>,I,X,Omnibus<N,O,I,X>> {

    private Lexicon<N> lexicon;

    public Aspect(Omnibus<N,O,I,X> omnibus, Circuit track, Lexicon<N> lexicon) {
        super(omnibus, track);
        this.lexicon = lexicon;
    }


    @Override
    public int compareTo(Aspect<N, O, I, X> o) {
        return 0;
    }
}
