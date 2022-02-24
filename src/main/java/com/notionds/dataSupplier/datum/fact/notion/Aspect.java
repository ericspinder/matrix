package com.notionds.dataSupplier.datum.fact.notion;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Support;
import com.notionds.dataSupplier.operational.Operational;
import dev.inward.matrix.gathering.Lexicon;

public class Aspect<N extends Notion<N,I,X>,I extends Id<I,X>,X extends Context<X>> extends Support<N,Asperational<N,I,X>,Aspect<N,I,X>,I,X,Omnibus<N,I,X>> {

    private Lexicon<N> lexicon;

    public Aspect(Omnibus<N,O,I,X> omnibus, Authority track, Lexicon<N> lexicon) {
        super(omnibus, track);
        this.lexicon = lexicon;
    }


    @Override
    public int compareTo(Aspect<N, O, I, X> o) {
        return 0;
    }
}
