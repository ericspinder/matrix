package com.notionds.dataSupplier.datum.fact;

import com.notionds.dataSupplier.rubric.Complication;
import com.notionds.dataSupplier.Unspoken;
import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.provider.Parent;
import com.notionds.dataSupplier.provider.Envoy;

import java.util.Map;

public abstract class Fact<F extends Fact<F,O,I,X,B,A>,O extends Operational<F,O,I,X,B,A>,I extends Id<I,X>,X extends Context<X>,B extends Bus<F,I,X,B>,A extends Parent<F,O,I,X,A>>
        extends Datum<F,O,I,X,A> implements Id.Addressable<I,X> {

    protected final I id;
    private B bus;
    @Unspoken
    protected final O operational;
//    @Unspoken
    private Map<Envoy<?,F,O,I,X,>,Track[]> tracksByEnvoy;

    public Fact(final I id, B bus, Complication) {
        this.operational = ((Edition<X>)this.getClass().getClassLoader()).assignOperational(id,);
        this.id = id;
        this.bus = bus;

    }

    public Fact(I id, O operational, B bus) {
        this.id = id;
        this.bus = bus;
        this.operational = operational;
    }

    public void setBus(B bus) {
        this.bus = bus;
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

    public B getBus() {
        return bus;
    }
    public O getOperational() {
        return this.operational;
    }

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
