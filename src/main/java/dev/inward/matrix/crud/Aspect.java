package dev.inward.matrix.crud;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.notion.Aspirational;
import com.notionds.dataSupplier.datum.fact.notion.Authority;
import com.notionds.dataSupplier.datum.fact.notion.Notion;
import com.notionds.dataSupplier.datum.fact.notion.Omnibus;
import dev.inward.matrix.gathering.Lexicon;

public class Aspect<N extends Notion<N,I,X,NP,IP,XP>,I extends Id<I,X>,X extends Context<X>,NP extends Notion<NP,IP,XP,?,?,?>,IP extends Id<IP,XP>,XP extends Context<XP>>
        extends Support<N, Aspirational<N,I,X,NP,IP,XP>,Aspect<N,I,X,NP,IP,XP>,I,X, Omnibus<N,I,X>,NP, Aspirational<NP,IP,XP,?,?,?>,Aspect<NP,IP,XP,?,?,?>,IP,XP, Authority<N,I,X,NP,IP,XP>> {

    private Lexicon<N> lexicon;

    public Aspect(Omnibus<N,I,X> omnibus, Authority track, Lexicon<N> lexicon) {
        super(omnibus, track);
        this.lexicon = lexicon;
    }


    @Override
    public int compareTo(Aspect<N, I, X, NP, IP, XP> o) {
        return 0;
    }
}
