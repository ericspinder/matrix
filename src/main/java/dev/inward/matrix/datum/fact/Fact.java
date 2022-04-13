package dev.inward.matrix.datum.fact;

import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Primogenitor;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.io.Serializable;

public abstract class Fact<F extends Fact<F,I,X,P,NP,IP,PP>,I extends Identity<I,X>,X extends Context<X>,P extends Progenitor<?,F,?,I,X,?,P>,NP extends Notion<NP,IP,X,PP>,IP extends Identity<IP,X>,PP extends Primogenitor<?,NP,?,IP,X,?,PP>> implements Comparable<F>, Serializable, Identity.Addressable<I,X> {

    protected final I id;

    public Fact(I id) {
        this.id = id;
    }

//    public void getComplication(Envoy<?,?,F,O,S,I,X,?> envoy, Class<Complication> complicationClass) {
//
//    }
//    public void add(Envoy<?,?,F,O,S,I,X> envoy, Complication<?,?,F,O,S,I,X,?,?,?> complication) {
//
//        Envoy[] tracks_n = new Envoy[envoys.length + 1];
//        for (int i = 0; i < envoys.length; i++)
//            tracks_n[i] = envoys[i];
//        tracks_n[envoys.length] = envoy;
//        envoys = tracks_n;
//    }
//    public void remove(Envoy envoy)

    @Override
    public I getId() {
        return this.id;
    }

    @Override
    public int compareTo(F that) {
        return this.id.compareTo(that.getId());
    }


//    public Class<DATUM> adjust(Class<DATUM> classOfNotion, DATUM notion) throws Issue {
//        if (notion instanceof Datum)
//        throw new Issue(Issue.Type.Adjustment_Not_Available)
//    }
//
//    public U wrapNotion(X container, DATUM notion) {
//
//    }
//

}
